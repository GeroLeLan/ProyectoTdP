package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparoPersonaje;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;


public class Disparo extends Intangible {
	protected boolean borrable;
	protected int daño;
	protected int velocidad;
	
	public Disparo(int x, int y) {
		super(x, y);
		borrable = false;
		daño = 10;
		setGrafico();
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/Disparo - Personaje.png"));
	}
	
	public int getDaño() {
		return daño;
	}
	public boolean soyBorrable() {
		return borrable;
	}
	public int dañarObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparoPersonaje(this));
	}
	
	protected void setGrafico() {
		grafico.setVisible(true);
		grafico.setSize((int)(Xmax*0.01),(int) (Ymax*0.03));
		grafico.setLocation(pos);
	}
	
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mover() {
		pos.setLocation(pos.x, pos.y - 2);
		if(pos.y <= 0)
			borrable=true;
		grafico.setLocation(pos);
	}

}
