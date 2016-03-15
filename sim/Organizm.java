package sim;

abstract class Organizm
{
	protected ButtonPanel _panel;
	protected int _sila;
	protected int _x;
	protected int _y;
	protected int _inicjatywa;
	protected int _wiek;
	protected char _wyglad;
	protected Swiat _swiat;
	protected Supermoc _moc;

	public abstract void akcja();
	public abstract void zielone_swiatlo();
	public abstract void wykonaj_ruch(int x, int y);
	
	
	public void kolizja(Organizm napastnik)
	{
		 walcz(napastnik);
	}
	
	public void odpal_moc()
	{
		_moc.zmien_aktywnosc();
	}
	
	public final void rysuj()
	{
		_panel.rysuj(_x,_y, _wyglad);
		//TODO
	}
	
	public final int gdzie_x()
	{
		return _x;
	}
	
	public final int gdzie_y()
	{
		return _y;
	}
	
	final int okresl_sile()
	{
		return _sila;
	}
	
	final char okresl_wyglad()
	{
		return _wyglad;
	}
	
	final int okresl_inicjatywe()
	{
		return _inicjatywa;
	}
	
	final int okresl_wiek()
	{
		return _wiek;
	}
	
	final void ustaw_x_y(int x, int y)
	{
		_x = x;
		_y = y;
	}
	
	final boolean spytaj_obecnosc(int x, int y)
	{
		return _swiat.sprawdz_obecnosc(x, y);
	}
	
	final void popros_odkolejkowanie(int x, int y)
	{
		_swiat.usun_zkolejki(x, y);
	}
	
	final void popros_wyzerowanie(int x, int y)
	{
		_swiat.wyzeruj_pole(x, y);
	}
	
	final void zabij(int x, int y)
	{
		_swiat.zabij(x, y);
	}
	
	final void grow_stronger()
	{
		_sila++;
	}
	
	final void postarz()
	{
		_wiek++;
	}
	
	
	protected final void walcz(Organizm napastnik)
	{
		int nap_x = napastnik.gdzie_x();
		int nap_y = napastnik.gdzie_y();
		if (_sila > napastnik.okresl_sile())
		{
			_swiat.wyzeruj_pole(nap_x, nap_y);
			_swiat.zabij(napastnik);
		}
		else
		{
			napastnik.ustaw_x_y(_x, _y);
			_swiat.przesun(_x, _y, napastnik);
			_swiat.wyzeruj_pole(nap_x, nap_y);
			_swiat.zabij(this);
		}
	}
	protected final void rozmnoz(Organizm nowy)
	{
		boolean czy_ma_miejsce = false;
		for (int i = -1; i < 2; i++)
		{
			for (int j = -1; j < 2; j++)
			{
				if (!_swiat.sprawdz_obecnosc(_x + i, _y + j) && _x + i<21 && 
						_x + i>0 && _y + j<21 && _y + j>0 && _swiat.ile_zwierzat()<400)
				{
					nowy.ustaw_x_y(_x + i, _y + j);
					_swiat.ustaw_istote(_x + i, _y + j, nowy);
					_swiat.skolejkuj(nowy);
					czy_ma_miejsce = true;
					break;
				}
			}
			if (czy_ma_miejsce)
				break;
		}
	}
}
