package PaqueteDisparos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparoPersonaje;
import PaqueteGenericos.Objeto;
import PaqueteObstaculos.Obstaculo;


public class Disparo extends Objeto {
	protected boolean borrable;
	protected int da�o;
	protected int velocidad;
	
	public Disparo(int x, int y,int d) {
		super(x, y);
		borrable = false;
		da�o = d;
		setGrafico();
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/dispEnemigo.gif"));
	}
	
	public int getDa�o() {
		return da�o;
	}
	public boolean soyBorrable() {
		return borrable;
	}
	public int da�arObstaculo(Obstaculo obstaculo) {
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
		pos.setLocation(pos.x, pos.y - 6);
		if(pos.y <= 0)
			morir();
		grafico.setLocation(pos);
	}

}
