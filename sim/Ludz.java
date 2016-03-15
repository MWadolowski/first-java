package sim;

public class Ludz extends Zwierze
{
	private boolean _czy_ruszyc;
	private int vx;
	private int vy;
	
	Ludz(Swiat swiat)
	{
		//_plik = plik;
		_swiat = swiat;
		_sila = 5;
		_inicjatywa = 4;
		_x = 1;
		_y = 1;
		_wiek = 0;
		_zasieg = 1;
		_wyglad = '#';
		_swiat.ustaw_gracza(this);
		_swiat.skolejkuj(this);
		_moc = new Calopalenie(this);
		_swiat.ustaw_istote(_x, _y, this);
		_panel = _swiat.daj_panel();
		_czy_ruszyc = false;
	}

	Ludz(int x, int y, Swiat swiat, int sila)
	{
		//_plik = plik;
		_swiat = swiat;
		_sila = sila;
		_inicjatywa = 4;
		_x = x;
		_y = y;
		_wiek = 0;
		_zasieg = 1;
		_wyglad = '#';
		_swiat.ustaw_gracza(this);
		_swiat.skolejkuj(this);
		_moc = new Calopalenie(this);
		_panel = _swiat.daj_panel();
		_czy_ruszyc = false;
	}

	Ludz(int x, int y, Swiat swiat)
	{
		//_plik = plik;
		_swiat = swiat;
		_sila = 5;
		_inicjatywa = 4;
		_x = x;
		_y = y;
		_wiek = 0;
		_zasieg = 1;
		_wyglad = '#';
		_swiat.skolejkuj(this);
		_moc = new Calopalenie(this);
		_panel = _swiat.daj_panel();
		_czy_ruszyc = false;
	}
	
	public void ustawxy(int x, int y)
	{
		vx = x;
		vy = y;
	}

	public void akcja()
	{
		//_panel.ustaw(this);
		//while(!_czy_ruszyc);
		//_czy_ruszyc = false;
		wykonaj_ruch(vx, vy);
	}
	
	public void ustaw_panel()
	{
		_panel = _swiat.daj_panel();
	}
	
	public void zielone_swiatlo()
	{
		_czy_ruszyc = true;
	}
	
	public void wykonaj_ruch(int x, int y)
	{
		if(vx==0 && vy==0)
		{
			odpal_moc();
			return;
		}
		if(_moc.sprawdz_aktywnosc())
		{
			_moc.akcja();
		}
		if(x+_x>20 || x+_x<1 || y+_y>20 || y+_y<1)
			return;
		if(!_swiat.sprawdz_obecnosc(x+_x, y+_y))
		{
			if(_czy_ruszyc == true)
				_panel.wypisz_komunikat("true");
			else _panel.wypisz_komunikat("false");
			_swiat.wyzeruj_pole(_x, _y);
			_swiat.przesun(x+_x, y+_y, this);
			_x+=x;
			_y+=y;		
		}
		else
		{
			_swiat.wywolaj_obrone(x+_x, y+_y, this);
		}
	}
}
