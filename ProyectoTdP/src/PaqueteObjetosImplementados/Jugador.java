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
		grafico.setIcon(new ImageIcon(this.getClass().getResource("src/ImageIcons/JUGADOR.png")));
		System.out.print("H");
		grafico.setSize(250, 75);
		grafico.setLocation(pos);
	}
	
	public int getVel() {
		return velocidad;
	}

	@Override
	protected void movimiento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void morir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}
	
}
