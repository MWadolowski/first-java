package sim;

public class Guarana extends Roslina
{
	public static final char GUARANA = '+';

	Guarana(int x, int y, Swiat swiat)
	{
		_wyglad = GUARANA;
		_x = x;
		_y = y;
		_sila = 0;
		_swiat = swiat;
		_inicjatywa = 0;
		_wiek = 0;
		_swiat.skolejkuj(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
	}

	Guarana(Swiat swiat)
	{
		_wyglad = GUARANA;
		_sila = 0;
		_swiat = swiat;
		_inicjatywa = 0;
		_wiek = 0;
		_panel = _swiat.daj_panel();
	}

	public void akcja()
	{
		Guarana nowy = new Guarana(_swiat);
		rozmnoz(nowy);
	}

	public void kolizja(Organizm napastnik)
	{
		napastnik.grow_stronger();
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
