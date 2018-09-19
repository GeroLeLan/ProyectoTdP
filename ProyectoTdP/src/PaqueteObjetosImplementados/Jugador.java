package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

import PaqueteObjetos.Personaje;


public class Jugador extends Personaje {
	protected int velocidad;

	
	public Jugador(int vel, int x, int y) {
		super(x, y);
		velocidad = vel;
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/Jugador - Estándar.png"));
		grafico.setSize(75, 90);
		grafico.setLocation(pos);
	}
	
	public int getVel() {
		return velocidad;
	}

	@Override
	protected void movimiento() {
		// TODO Auto-generated method stub
		
	}

	public int morir() {
		return 0;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}
	
}
