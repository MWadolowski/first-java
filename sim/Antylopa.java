package sim;
import java.util.Random;


public class Antylopa extends Zwierze
{
	public static final char ANTYLOPA = 'A';

	Antylopa(int x, int y, Swiat swiat)
	{
		_sila = 4;
		_inicjatywa = 4;
		_wiek = 0;
		_wyglad = ANTYLOPA;
		ustaw_x_y(x, y);
		_zasieg = 2;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}
	
	Antylopa(Swiat swiat)
	{
		_sila = 4;
		_inicjatywa = 4;
		_wiek = 0;
		_wyglad = ANTYLOPA;
		_zasieg = 2;
		_swiat = swiat;
		_panel = _swiat.daj_panel();
	}
	
	Antylopa(int x, int y, Swiat swiat, int sila)
	{
		_sila = sila;
		_inicjatywa = 4;
		_wiek = 0;
		_wyglad = ANTYLOPA;
		ustaw_x_y(x, y);
		_zasieg = 2;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	public void akcja() 
	{
		_panel.ustaw(this);
		Antylopa nowy = new Antylopa(_swiat);
		rusz(nowy);	
	}
	
	public void kolizja(Organizm napastnik)
	{
		Random generator = new Random();
		int m = generator.nextInt(2);
		if (m == 1)
		{
			int x, y;
			for (int i = -1; i < 2; i++)
			{
				for (int j = -1; j < 2; j++)
				{
					if (i != 0 || j != 0)
					{
						x = _x + _zasieg*i;
						y = _y + _zasieg*j;
						if (!_swiat.sprawdz_obecnosc(x, y))
						{
							_swiat.przesun(x, y, this);
							ustaw_x_y(x, y);
							break;
						}
					}
				}
			}
		}
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
