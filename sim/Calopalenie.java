package sim;

public class Calopalenie extends Supermoc
{
	Calopalenie(Organizm owner)
	{
		cooldown = 0;
		czas_dzialania = 5;
		aktywna = false;
		wlasciciel = owner;
	}

	public void akcja()
	{
		if (cooldown == 0)
		{
			if (aktywna == true)
			{
				int x, y;
				int poz_x = wlasciciel.gdzie_x();
				int poz_y = wlasciciel.gdzie_y();
				for (int i = -1; i <= 1; i++)
				{
					for (int j = -1; j <= 1; j++)
					{
						if (i != 0 || j != 0)
						{
							x = poz_x + i;
							y = poz_y + j;
							if(x>0 && x<21 && y>0 && y<21)
							{
								if (wlasciciel.spytaj_obecnosc(x, y) 
										&& x!=wlasciciel.gdzie_x()
										&& y!=wlasciciel.gdzie_y())
								{
									wlasciciel.popros_odkolejkowanie(x, y);
									wlasciciel.popros_wyzerowanie(x, y);
									wlasciciel.zabij(x, y);
								}	
							}

						}
					}
				}
				czas_dzialania--;
				if (czas_dzialania == 0)
				{
					cooldown = 5;
					aktywna = false;
				}
			}
		}
		else
		{
			czas_dzialania = 5;
			cooldown--;
		}
	}

	public void akcja_obronna()
	{

	}

	public void wykonaj_bezwzglednie()
	{
		if (cooldown == 0)
		{
			if (aktywna == true)
			{
				int x, y;
				int poz_x = wlasciciel.gdzie_x();
				int poz_y = wlasciciel.gdzie_y();
				for (int i = -1; i <= 1; i++)
				{
					for (int j = -1; j <= 1; j++)
					{
						if (i != 0 || j != 0)
						{
							x = poz_x + i;
							y = poz_y + j;
							if (wlasciciel.spytaj_obecnosc(x, y));
							{
								wlasciciel.popros_odkolejkowanie(x, y);
								wlasciciel.popros_wyzerowanie(x, y);
								wlasciciel.zabij(x, y);

							}
						}
					}
				}
			}
		}
	}
}
