package sim;

public class main 
{
    public static void main(String args[]) 
    {
    	final Swiat gra = new Swiat();
		Ludz gracz = new Ludz(gra);    	
    	final swingowy swing = new swingowy(gra, gracz);
    	//gra.ustaw_panel(swingowy.daj_panel());
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
            	swing.setVisible(true);
            }
        });
        gra.ustaw_panel(swingowy.daj_panel());
        gracz.ustaw_panel();
        @SuppressWarnings("unused")

        //Owca owca = new Owca(7,3,gra);
        //Lis lis = new Lis(3,3,gra);
        //Trawa trawa = new Trawa(5,5,gra);
        Guarana guarana = new Guarana(5,5,gra);
    	/*while(true)
    	{
    		gra.rysuj();
    		gra.wykonaj();
    		gra.ustaw_ilosc_stworzen();
    		gra.sortuj();
    	}*/
    }
}
