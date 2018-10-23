package PaqueteDrops;

import javax.swing.ImageIcon;


import PaqueteArmas.ArmaSupermisil;
import PaqueteContadores.ContadorTemporales;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public class SuperMisil extends Temporales {
	private Personaje p;
	ContadorTemporales tiempo;
	public SuperMisil(int x, int y, GUI gui) {
		super(x, y,gui);
		tiempo=new ContadorTemporales(this);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleSupermisil.gif"));
		setGrafico();
	}
	
	public void mejorar(Personaje personaje) {
		personaje.cambiarAarmaTemporal(new ArmaSupermisil());
		p=personaje;
		tiempo.start();
	}
	
	
	public Drop clone() {
		return new SuperMisil(pos.x, pos.y, gui);
	}
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
		
	}
	@SuppressWarnings("deprecation")
	public void terminar() {
		// aca karina hace lo que salga el iconito de la pantalla 
		p.recuperarArma();
		tiempo.stop();
	}
	
}
