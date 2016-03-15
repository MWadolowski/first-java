package sim;

public class Mlecz extends Roslina{
	private static final char MLECZ = 'M';
	Mlecz(int x, int y, Swiat swiat)
	{
		_wiek = 0;
		_wyglad = MLECZ;
		_sila = 0;
		_inicjatywa = 0;
		_swiat = swiat;
		ustaw_x_y(x, y);
		_swiat.ustaw_istote(x, y, this);
		_swiat.skolejkuj(this);
		_panel = _swiat.daj_panel();
	}

	Mlecz(Swiat swiat)
	{
		_wiek = 0;
		_wyglad = MLECZ;
		_sila = 0;
		_inicjatywa = 0;
		_swiat = swiat;
		_panel = _swiat.daj_panel();
	}
	
	public void akcja()
	{
		Mlecz nowy = new Mlecz(_swiat);
		rozmnoz(nowy);
		Mlecz nowy1 = new Mlecz(_swiat);
		rozmnoz(nowy1);
		Mlecz nowy2 = new Mlecz(_swiat);
		rozmnoz(nowy2);
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
