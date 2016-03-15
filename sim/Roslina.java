package sim;
import java.util.Random;

abstract class Roslina  extends Organizm{

	private static final int ILOSC = 20;

	abstract public void akcja();
	
	public void kolizja(Organizm napastnik)
	{
		walcz(napastnik);
	}
	
	protected void rozmnoz(Roslina nowy)
	{
		_panel.ustaw(this);
		boolean juz = false;
		Random gen = new Random();
		int losowanie = gen.nextInt(5);
		if (losowanie == 3)
		{
			for (int i = -1; i < 2; i++)
			{
				for (int j = -1; j < 2; j++)
				{
					if (_x + i>0 && _x + i <= ILOSC && _y + j <= ILOSC && _y + j>0)
					{
						if (!_swiat.sprawdz_obecnosc(_x + i, _y + j) && 
								_swiat.ile_zwierzat()<400)
						{
							nowy.ustaw_x_y(_x + i, _y + j);
							this._swiat.ustaw_istote(_x + i, _y + j, nowy);
							_swiat.skolejkuj(nowy);
							juz = true;
						}
					}
					if (juz)
						break;
				}
				if (juz)
					break;
			}
		}
	}
}
