package sim;
import java.awt.Point;

public class Lis extends Zwierze
{
	private static final char LISEK = 'L';
	Lis(int x, int y, Swiat swiat)
	{
		_sila = 4;
		_inicjatywa = 7;
		_wiek = 0;
		_wyglad = LISEK;
		ustaw_x_y(x, y);
		_zasieg = 1;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	Lis(Swiat swiat)
	{
		_sila = 4;
		_inicjatywa = 7;
		_wiek = 0;
		_wyglad = LISEK;
		_zasieg = 1;
		_swiat = swiat;
		_panel = _swiat.daj_panel();
	}

	Lis(int x, int y, Swiat swiat, int sila)
	{
		_sila = sila;
		_inicjatywa = 7;
		_wiek = 0;
		_wyglad = LISEK;
		ustaw_x_y(x, y);
		_zasieg = 1;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	public void akcja()
	{
		int ilosc = 0, nowy_x = _x, nowy_y = _y;
		Point coord[] = new Point[8];
		for(int i=0;i<8;i++)
		{
			coord[i] = new Point();
		}
		ilosc = ustal_kierunek(coord, ilosc);
		mieszaj(coord, ilosc);
		for (int i = 0; i < ilosc; i++)
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
					break;
				}
				else if (_swiat.okresl_wyglad(nowy_x, nowy_y) == _wyglad)
				{
					Lis nowy = new Lis(_swiat);
					rozmnoz(nowy);
					break;
				}
				else if (_sila >= _swiat.okresl_sile(nowy_x,nowy_y))
				{
					_swiat.wywolaj_obrone(nowy_x, nowy_y, this);
					break;
				}	
			}
		}
	}

	public void kolizja(Organizm napastnik)
	{
		walcz(napastnik);
	}

	@Override
	public void zielone_swiatlo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void wykonaj_ruch(int x, int y) {
		// TODO Auto-generated method stub
		
	}
}
