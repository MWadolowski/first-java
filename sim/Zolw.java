package sim;
import java.util.Random;

public class Zolw extends Zwierze
{
	private static final char ZOLWIK = 'Z';
	Zolw(int x, int y, Swiat swiat)
	{
		_wyglad = ZOLWIK;
		_sila = 2;
		ustaw_x_y(x, y);
		_inicjatywa = 1;
		_wiek = 0;
		_zasieg = 1;
		_swiat = swiat;
		_swiat.ustaw_istote(x, y, this);
		_swiat.skolejkuj(this);
		_panel = _swiat.daj_panel();
	}

	Zolw(Swiat swiat)
	{
		_wyglad = ZOLWIK;
		_sila = 2;
		_inicjatywa = 1;
		_wiek = 0;
		_zasieg = 1;
		_swiat = swiat;
		_panel = _swiat.daj_panel();
	}

	Zolw(int x, int y, Swiat swiat, int sila)
	{
		_wyglad = ZOLWIK;
		_sila = sila;
		ustaw_x_y(x, y);
		_inicjatywa = 1;
		_wiek = 0;
		_zasieg = 1;
		_swiat = swiat;
		_swiat.ustaw_istote(x, y, this);
		_swiat.skolejkuj(this);
		_panel = _swiat.daj_panel();
	}

	public void akcja()
	{
		_panel.ustaw(this);
		Random gen = new Random();
		int i = gen.nextInt(4);
		if (i == 4)
		{
			Zolw nowy = new Zolw(_swiat);
			rusz(nowy);
		}
	}

	public void kolizja(Organizm napastnik)
	{
		if (napastnik.okresl_sile() > 5)
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
