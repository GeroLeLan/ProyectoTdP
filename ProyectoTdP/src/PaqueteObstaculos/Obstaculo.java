package PaqueteObstaculos;


import javax.swing.ImageIcon;
import PaqueteColisionadores.Colisionador;
import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoEnemigo;
import PaqueteGenericos.Objeto;

public abstract class Obstaculo extends Objeto { //Permite que el mapa defina los tipos de Obst�culo en el nivel (bas�ndose en la dificultad del nivel), y no la GUI.
	protected int puntosKill;
	
	protected Obstaculo(int x, int y) {
		super(x, y);
		grafico.setSize((int)(Xmax*0.09),(int)(Ymax*0.07));
		grafico.setLocation(pos);
		vida = 50;
	}
	
	public int recibirDisparo(Disparo dispPer) {
		vida -= dispPer.getDa�o();
		dispPer.morir();
		if (vida <= 0)
			return morir();
		return 0;
	}
	public abstract int recibirDisparo(DisparoEnemigo dispEnem); //M�todo sobrecargado para diferenciar si debe hacerle da�o el DisparoEnemigo o no.
	
	public int serChocado(Colisionador c) {
		return c.chocarObstaculo(this);
	}
	
	protected int morir() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/obstaculoDestruido.gif");
		//ImageIcon iconoEscala= new ImageIcon(iconoOriginal.getImage().getScaledInstance((int) (iconoOriginal.getIconWidth()), (int) (iconoOriginal.getIconHeight()), java.awt.Image.SCALE_DEFAULT));
	//	grafico.setSize(iconoOriginal.getIconWidth(),iconoOriginal.getIconWidth());
		grafico.setIcon( iconoOriginal);
		return puntosKill;
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
}
