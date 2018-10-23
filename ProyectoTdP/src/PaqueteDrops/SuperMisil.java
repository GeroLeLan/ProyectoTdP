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

		personaje.setArma(new ArmaSupermisil());
		gui.mostrarIconoDrop(2,  new ImageIcon("./bin/ImageIcons/iconoDropSupermisil_Habilitado.png"));
		gui.mostrarIconoDrop(1,  new ImageIcon("./bin/ImageIcons/iconoDropDaño_Deshabilitado.png"));
		gui.mostrarIconoDrop(4,  new ImageIcon("./bin/ImageIcons/iconoDropPerforador_Deshabilitado.png"));

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
