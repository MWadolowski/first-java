package sim;

public class Trawa extends Roslina
{
	private static final char TRAWKA = 'T';
	Trawa(int x, int y, Swiat swiat)
	{
		_wyglad = TRAWKA;
		_x = x;
		_y = y;
		_sila = 0;
		_inicjatywa = 0;
		_wiek = 0;
		_swiat = swiat;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	Trawa(Swiat swiat)
	{
		_wyglad = TRAWKA;
		_sila = 0;
		_inicjatywa = 0;
		_wiek = 0;
		_swiat = swiat;
	}

	public void akcja()
	{
		Trawa nowy = new Trawa(_swiat);
		rozmnoz(nowy);
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
