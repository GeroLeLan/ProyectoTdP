package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

import PaqueteObjetos.Personaje;


public class Jugador extends Personaje {
	protected int velocidad;

	
	public Jugador(int vel, int x, int y) {
		super(vel, x, y);
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

	

	public int morir() {
		return 0;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mover(int i) {
		// TODO Auto-generated method stub
		
	}
	
}
