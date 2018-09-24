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
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Estándar.png");
		ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(grafico.getWidth(), grafico.getHeight(), java.awt.Image.SCALE_DEFAULT));
		grafico.setIcon(iconoEscala);
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
