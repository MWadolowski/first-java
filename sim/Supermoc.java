package sim;

abstract public class Supermoc 
{
	protected Organizm wlasciciel;
	protected int cooldown;
	protected int czas_dzialania;
	protected boolean aktywna;
	
	
	public void zmien_aktywnosc()
	{
		if (aktywna == true)
			aktywna = false;
		else aktywna = true;
	}

	public boolean sprawdz_aktywnosc()
	{
		return aktywna;
	}

	public int zwroc_cd()
	{
		return cooldown;
	}

	public int zwroc_czas()
	{
		return czas_dzialania;
	}

	abstract public void akcja();
}
