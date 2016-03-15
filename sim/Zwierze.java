package sim;
import java.util.Random;
import java.awt.Point;

public abstract class Zwierze extends Organizm
{
	protected int _zasieg;
	
	
	public abstract void akcja();
	
	protected void rusz(Organizm ten)
	{
		_panel.ustaw(this);
		int ilosc = 0, nowy_x = _x, nowy_y = _y;
		Point coord[] = new Point[8];
		for(int i = 0;i<8;i++)
		{
			coord[i] = new Point(21,21);
		}
		ilosc = ustal_kierunek(coord, ilosc);
		mieszaj(coord, ilosc);
		for (int i = 0; i < ilosc;i++)
		{
			nowy_x = coord[i].x;
			nowy_y = coord[i].y;
			if (nowy_x != _x || nowy_y != _y)
			{
				if (!_swiat.sprawdz_obecnosc(nowy_x, nowy_y))
				{
					_swiat.przesun(nowy_x, nowy_y, this);
					_swiat.wyzeruj_pole(_x, _y);
					_x = nowy_x;
					_y = nowy_y;
				}
				else
				{
					if (_swiat.okresl_wyglad(nowy_x, nowy_y) == _wyglad)
						rozmnoz(ten);	
					else
					{
						_swiat.wywolaj_obrone(nowy_x, nowy_y, this);
					}
				}
				break;
			}
		}
	}
	
	protected int ustal_kierunek(Point coord[], int ilosc)
	{
		int nowy_x, nowy_y;
		for (int i = 1; i >= -1; i--)
		{
			for (int j = 1; j >= -1; j--)
			{
				if(!(i == 0 && j == 0))
				{
					nowy_x = _x + _zasieg*i;
					nowy_y = _y + _zasieg*j;
					if (nowy_x <= 20 && nowy_x>= 1 &&
							nowy_y <= 20 && nowy_y>= 1 && (i != 0 || j != 0))
					{
						coord[ilosc].x = nowy_x;
						coord[ilosc].y = nowy_y;
						(ilosc)++;
					}
				}
				
			}
		}
		return ilosc;
	}
	
	protected void mieszaj(Point coord[], int ilosc)
	{
		Random generator = new Random();
		int mieszana1, mieszana2;
		for (int i = 0; i<11; i++)
		{
			if (ilosc > 1)
			{
				mieszana1 = generator.nextInt(ilosc);
				mieszana2 = generator.nextInt(ilosc);
				//swap(coord[mieszana1], coord[mieszana2]);
				Point temp = new Point(coord[mieszana1]);
				coord[mieszana1].x = coord[mieszana2].x;
				coord[mieszana1].y = coord[mieszana2].y;
				coord[mieszana2].x = temp.x;
				coord[mieszana2].y = temp.y;
			}
		}
	}
	
	protected void swap(Point a, Point b)
	{
		Point temp = new Point(a);
		/*temp.x = a.x;
		temp.y = a.y;
		a.x = b.x;
		a.y = b.y;
		b.x = temp.x;
		b.y = temp.y;*/
		a.x = b.x;
		a.y = b.y;
		b = temp;
		
	}
}
