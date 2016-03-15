package sim;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
//plansza 400x400 od p.(10,40)

@SuppressWarnings("serial")
public class swingowy extends JFrame
{
	private Swiat _swiat;
	private Ludz _gracz;
	private static ButtonPanel _panel;
	
	public swingowy(Swiat swiat, Ludz gracz) 
	{
		super("Micha³ W¹do³owski 155219");
		_swiat = swiat;		
		_gracz = gracz;
		ButtonPanel buttonPanel = new ButtonPanel(_swiat, _gracz);
		_panel = buttonPanel;
		add(buttonPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setLocation(200,50);
		setResizable(false);
	}
	
	public static ButtonPanel daj_panel()
	{
		return _panel;
	}
}

@SuppressWarnings("serial")
class ButtonPanel extends JPanel implements ActionListener
{
	private Ludz _gracz;
	private Swiat _swiat;//jeszcze wykombinuj
	private Organizm _mojatura;
	
	public static final int HEIGHT = 100;
	public static final int WIDTH = 300;
	private static final int SZEROKOSC = 100;
	
	private JButton holokaust;
	private JButton gora;
	private JButton dol;
	private JButton lewo;
	private JButton prawo;
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem save;
	private JMenuItem load;
	private JMenuItem example;
	private TextArea log;
	
	protected void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(10, 40, 400, 400);
	}

	@SuppressWarnings("deprecation")
	public ButtonPanel(Swiat swiat, Ludz gracz) 
	{
		_gracz = gracz;
		_swiat = swiat;
		_mojatura = null;
		holokaust = new JButton("RIP");
		gora = new JButton("gora");
		dol = new JButton("dol");
		lewo = new JButton("lewo");
		prawo = new JButton("prawo");
		menu = new JMenuBar();
		file = new JMenu("file");
		save = new JMenuItem("save");
		load = new JMenuItem("load");
		example = new JMenuItem("example");
		log = new TextArea();

		holokaust.addActionListener(this);
		gora.addActionListener(this);
		dol.addActionListener(this);
		lewo.addActionListener(this);
		prawo.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		example.addActionListener(this);

		add(holokaust);
		add(gora);
		add(dol);
		add(lewo);
		add(prawo);
		add(menu);
		add(log);
		menu.add(file);
		file.add(save);
		file.add(load);
		file.add(example);
		
		holokaust.setBounds(170, 480, 80, 60);
		menu.setBounds(0, 0, 800, 20);
		lewo.setBounds(60, 500, SZEROKOSC, 20);
		prawo.setBounds(260,500,SZEROKOSC,20);
		gora.setBounds(160, 450, SZEROKOSC, 20);
		dol.setBounds(160,550,SZEROKOSC,20);
		log.setBounds(450, 40, 250, 550);
		log.setEditable(false);
		log.setText("lol");
		log.appendText("\n");
		log.appendText("dziala");
		
		setLayout(null);
		setPreferredSize(new Dimension(700, 600));
	}
	
	public void wypisz_komunikat(String komunikat)
	{
		log.append(komunikat);
	}
	
	public void ustaw(Organizm kto)
	{
		_mojatura = kto;
	}
	
	public void rysuj(int x, int y, char wyglad)
	{
		Graphics g = this.getGraphics();
		switch(wyglad)
		{
			case 'W':
				g.setColor(Color.RED);
				break;
			case 'O':
				g.setColor(Color.darkGray);
				break;
			case 'L':
				g.setColor(Color.ORANGE);
				break;
			case 'Z':
				g.setColor(Color.BLUE);
				break;
			case 'T':
				g.setColor(Color.GREEN);
				break;
			case '+':
				g.setColor(Color.YELLOW);
				break;
			case 'A':
				g.setColor(Color.MAGENTA);
				break;
			case 'M':
				g.setColor(Color.PINK);
				break;
			case 'X':
				g.setColor(Color.BLACK);
				break;
			case '#':
				g.setColor(Color.CYAN);
				break;
			default:
				g.setColor(Color.GRAY);
				break;
		}
		g.drawRect(10 + (x-1)*20, 40 + (y-1)*20, 20, 20);
		g.fillRect(10 + (x-1)*20, 40 + (y-1)*20, 20, 20);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		Object source = e.getSource();
		if(source == save)
		{
			
		}
		else if(source == load)
		{
			
		}
		else if(source == example)
		{
			
		}
		//else if(_mojatura != null)
		//{
			//if(_mojatura.getClass() == Ludz.class)
			//{
				_swiat.rysuj();
				if (source == gora) 
				{
					_swiat.wykonaj(0, -1, _gracz);
					_swiat.ustaw_ilosc_stworzen();
					//_mojatura.wykonaj_ruch(0, -1);
					//_mojatura.zielone_swiatlo();
				} 
				else if (source == dol) 
				{
					_swiat.wykonaj(0, 1, _gracz);
					_swiat.ustaw_ilosc_stworzen();
					//_mojatura.wykonaj_ruch(0, 1);
					//_mojatura.zielone_swiatlo();
				} 
				else if (source == lewo) 
				{
					_swiat.wykonaj(-1, 0, _gracz);
					_swiat.ustaw_ilosc_stworzen();
					//_mojatura.wykonaj_ruch(-1, 0);
					//_mojatura.zielone_swiatlo();
				} 
				else if (source == prawo) 
				{
					_swiat.wykonaj(1, 0, _gracz);
					_swiat.ustaw_ilosc_stworzen();
					//_mojatura.wykonaj_ruch(1, 0);
					//_mojatura.zielone_swiatlo();
				} 
				else if (source == holokaust) 
				{
					_swiat.wykonaj(0, 0, _gracz);
					_swiat.ustaw_ilosc_stworzen();
					//_mojatura.odpal_moc();
					//_mojatura.zielone_swiatlo();
				}
			//}
		//}	
	}
}