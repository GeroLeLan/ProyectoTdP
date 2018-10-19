package PaqueteObstaculos;


import javax.swing.ImageIcon;
import PaqueteColisionadores.Colisionador;
import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoEnemigo;
import PaqueteGenericos.Objeto;

public abstract class Obstaculo extends Objeto {
	protected int puntosKill;
	
	protected Obstaculo(int x, int y) {
		super(x, y);
		grafico.setSize((int)(Xmax*0.09),(int)(Ymax*0.07));
		grafico.setLocation(pos);
		vida = 50;
	}
	
	public int recibirDisparo(Disparo dispPer) {
		vida -= dispPer.getDaño();
		dispPer.morir();
		if (vida <= 0)
			return morir();
		return 0;
	}
	public abstract int recibirDisparo(DisparoEnemigo dispEnem); //Método sobrecargado para diferenciar si debe hacerle daño el DisparoEnemigo o no.
	
	public int serChocado(Colisionador c) {
		return c.chocarObstaculo(this);
	}
	
	protected int morir() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/obstaculoDestruido.gif");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		return puntosKill;
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
}
