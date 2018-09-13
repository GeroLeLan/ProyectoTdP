package PaqueteObjetosNacho;

import javax.swing.ImageIcon;


public class Jugador extends Objeto {
	protected int velocidad;

	
	public Jugador(int vel, int x, int y) {
		super(x, y);
		velocidad = vel;
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("C:\\Users\\nacho\\Documents\\Nacho - Universidad\\Nacho - Universidad 2018\\Segundo Cuatrimestre\\Tecnología de Programación\\Proyecto\\ProyectoTdP - Chiaravalle, Schimpfle y Le Lan Toussaint\\ProyectoTdP\\src\\ImageIcons\\JUGADOR.png"));
		grafico.setSize(250, 75);
		grafico.setLocation(pos);
	}
	
	public int getVel() {
		return velocidad;
	}
	
}
