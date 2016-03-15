package sim;

public class Owca extends Zwierze
{
	private static final char OWCA = 'O';
	Owca(int x, int y, Swiat swiat)
	{
		ustaw_x_y(x, y);
		_sila = 4;
		_zasieg = 1;
		_wiek = 0;
		_inicjatywa = 4;
		_swiat = swiat;
		_wyglad = OWCA;
		_swiat.ustaw_istote(x, y, this);
		_swiat.skolejkuj(this);
		_panel = _swiat.daj_panel();
	}

	Owca(Swiat swiat)
	{
		_sila = 4;
		_zasieg = 1;
		_wiek = 0;
		_inicjatywa = 4;
		_swiat = swiat;
		_wyglad = OWCA;
		_panel = _swiat.daj_panel();
	}

	Owca(int x, int y, Swiat swiat, int sila)
	{
		ustaw_x_y(x, y);
		_sila = sila;
		_zasieg = 1;
		_wiek = 0;
		_inicjatywa = 4;
		_swiat = swiat;
		_wyglad = OWCA;
		_swiat.ustaw_istote(x, y, this);
		_swiat.skolejkuj(this);
		_panel = _swiat.daj_panel();
	}

	public void akcja()
	{
		Owca nowa = new Owca(_swiat);
		rusz(nowa);
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
