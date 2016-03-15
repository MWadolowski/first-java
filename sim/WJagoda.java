package sim;

public class WJagoda extends Roslina
{
	private static final char JAGODA = 'X';

	WJagoda(int x, int y, Swiat swiat)
	{
		_wiek = 0;
		_wyglad = JAGODA;
		_sila = 99;
		_inicjatywa = 0;
		_swiat = swiat;
		ustaw_x_y(x, y);
		_swiat.ustaw_istote(x, y, this);
		_swiat.skolejkuj(this);
		_panel = _swiat.daj_panel();
	}

	WJagoda(Swiat swiat)
	{
		_wiek = 0;
		_wyglad = JAGODA;
		_sila = 99;
		_inicjatywa = 0;
		_swiat = swiat;
		_panel = _swiat.daj_panel();
	}

	public void akcja()
	{
		WJagoda nowy = new WJagoda(_swiat);
		rozmnoz(nowy);
	}

	public void kolizja(Organizm napastnik)
	{
		_swiat.wyzeruj_pole(napastnik.gdzie_x(), napastnik.gdzie_y());
		zabij(napastnik.gdzie_x(), napastnik.gdzie_y());
		_swiat.wyzeruj_pole(_x, _y);
		zabij(_x, _y);
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
