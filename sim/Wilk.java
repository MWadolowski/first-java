package sim;

public class Wilk extends Zwierze
{
	private static final char WILKU = 'W';
	Wilk(int x, int y, Swiat swiat)
	{
		_sila = 9;
		_inicjatywa = 5;
		_wiek = 0;
		_wyglad = WILKU;
		ustaw_x_y(x, y);
		_zasieg = 1;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	Wilk(Swiat swiat)
	{
		_sila = 9;
		_inicjatywa = 5;
		_wiek = 0;
		_wyglad = WILKU;
		_zasieg = 1;
		_swiat = swiat;
		_panel = _swiat.daj_panel();
	}

	Wilk(int x, int y, Swiat swiat, int sila)
	{
		_sila = sila;
		_inicjatywa = 5;
		_wiek = 0;
		_wyglad = WILKU;
		ustaw_x_y(x, y);
		_zasieg = 1;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	public void akcja()
	{
		Wilk nowy = new Wilk(_swiat);
		rusz(nowy);
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
