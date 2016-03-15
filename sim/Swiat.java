package sim;

public class Swiat 
{
	public static final int ILOSC = 20;
	protected Organizm plansza[][];
	protected Organizm kolejka[];
	protected int _ilosc;
	protected int _kopiailosc;
	protected ButtonPanel _panel;
	
	Swiat()
	{
		plansza = new Organizm[ILOSC][];
		for(int i = 0; i<ILOSC; i++)
		{
			plansza[i] = new Organizm[ILOSC];
		}
		kolejka = new Organizm[ILOSC];
		_ilosc = 0;
		_kopiailosc = 0;
		for (int i = 0; i < ILOSC; i++)
		{
			for (int j = 0; j < ILOSC; j++)
			{
				plansza[i][j] = null;
			}
		}
	}
	
	public void ustaw_panel(ButtonPanel panel)
	{
		_panel = panel;
	}
	
	public ButtonPanel daj_panel()
	{
		return _panel;
	}
	
	public void rysuj()
	{
		for(int i = 0; i < ILOSC; i++)
		{
			for(int j = 0; j < ILOSC; j++)
			{
				if(plansza[i][j] != null)
					plansza[i][j].rysuj();
				else
					_panel.rysuj(i+1, j+1, '9');
			}
		}
	}
	
	public void wykonaj(int x, int y, Ludz gracz)
	{
		gracz.ustawxy(x, y);
		for (int i = 0; i < _ilosc; i++)
		{
			kolejka[i].akcja();
		}
		rysuj();
	}
	
	public void ustaw_gracza(Ludz gracz)
	{
		plansza[gracz.gdzie_x()-1][gracz.gdzie_y()-1] = gracz;
	}
	
	public boolean sprawdz_obecnosc(int x, int y)
	{
		if (plansza[x - 1][y - 1] != null)
			return true;
		else return false;
	}
	
	public void wyzeruj_pole(int x, int y)
	{
		plansza[x - 1][y - 1] = null;
	}
	
	public void przesun(int x, int y, Organizm kto)
	{
		plansza[x - 1][y - 1] = kto;
	}
	
	public int okresl_sile(int x, int y) 
	{
		return plansza[x - 1][y - 1].okresl_sile();
	}
	
	public char okresl_wyglad(int x, int y)
	{
		return plansza[x - 1][y - 1].okresl_wyglad();
	}
	
	public void wywolaj_obrone(int x, int y, Organizm napastnik)
	{
		plansza[x - 1][y - 1].kolizja(napastnik);
	}
	
	public void ustaw_istote(int x, int y, Organizm nowy)
	{
		plansza[x - 1][y - 1] = nowy;
	}
	
	public void zabij(Organizm trup)
	{
		usun_zkolejki(trup);
	}
	
	public void zabij(int x, int y)
	{
		zabij(plansza[x - 1][y - 1]);
	}
	
	public void skolejkuj(Organizm nowy)
	{
		kolejka[_kopiailosc] = nowy;
		if (_kopiailosc < 400)
			_kopiailosc++;
	}
	
	public int okresl_inicjatywe(int x, int y)
	{
		return plansza[x - 1][y - 1].okresl_inicjatywe();

	}
	
	public int okresl_wiek(int x, int y)
	{
		return plansza[x - 1][y - 1].okresl_wiek();
	}
	
	public void sortuj()
	{
		for (int i = _ilosc - 1; i >= 0; i--)
		{
			skopcuj(i, _ilosc);
			postarz(kolejka[i]);
		}
	}
	
	public void usun_zkolejki(int x, int y)
	{
		usun_zkolejki(plansza[x - 1][y - 1]);
	}
	public void usun_zkolejki(Organizm trup)
	{
		for (int i = 0; i < ILOSC*ILOSC; i++)
		{
			if (kolejka[i] == trup)
			{
				_ilosc--;
				_kopiailosc--;
				kolejka[i] = null;
				for (int j = i; j < ILOSC*ILOSC-1; j++)
				{
					kolejka[j] = kolejka[j + 1];
				}
				break;
			}
		}
	}
	
	public void ustaw_ilosc_stworzen()
	{
		_ilosc = _kopiailosc;
	}
	
	public void skopiuj(Swiat gdzie, Organizm kto)
	{
		if (gdzie.sprawdz_obecnosc(kto.gdzie_x(), kto.gdzie_y()))
		{
			gdzie.ustaw_istote(kto.gdzie_x(), kto.gdzie_y(),kto);
			usun_zkolejki(kto);
			wyzeruj_pole(kto.gdzie_x(), kto.gdzie_y());
			gdzie.skolejkuj(kto);
		}
	}
	
	public int ile_zwierzat()
	{
		return _kopiailosc;
	}
	
	public void postarz(Organizm kto)
	{
		kto.postarz();
	}
	
	
	protected void skopcuj(int i, int ilosc)
	{
		int duza;
		int p = prawy(i), l = lewy(i);//, rodzic = mama(i);
		if (l<ilosc && 
				(kolejka[l].okresl_inicjatywe() > kolejka[i].okresl_inicjatywe() 
						|| (kolejka[l].okresl_inicjatywe()==kolejka[i].okresl_inicjatywe() 
						&& kolejka[l].okresl_wiek()>kolejka[i].okresl_wiek())))
			duza = l;
		else duza = i;
		if (p<ilosc && 
				(kolejka[p].okresl_inicjatywe() > kolejka[duza].okresl_inicjatywe() 
						|| (kolejka[p].okresl_inicjatywe() == kolejka[duza].okresl_inicjatywe() 
						&& kolejka[p].okresl_wiek()>kolejka[duza].okresl_wiek())))
			duza = p;
		if (duza != i)
		{
			zamien(i, duza);
			skopcuj(duza, ilosc);
		}
	}
	
	protected int lewy(int i)
	{
		return i * 2;
	}
	
	protected int prawy(int i)
	{
		return i * 2 + 1;
	}
	
	protected int mama(int i)
	{
		return i / 2;
	}
	
	protected void zamien(int i, int j)
	{
		Organizm temp;
		temp = kolejka[i];
		kolejka[i] = kolejka[j];
		kolejka[j] = temp;
	}
}
