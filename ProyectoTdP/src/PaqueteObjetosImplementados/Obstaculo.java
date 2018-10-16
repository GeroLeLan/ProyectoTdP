package PaqueteObjetosImplementados;

import java.awt.Image;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoEnemigo;

public abstract class Obstaculo extends Objeto { //Permite que el mapa defina los tipos de Obstáculo en el nivel (basándose en la dificultad del nivel), y no la GUI.
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
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/obstaculoDestruido1.gif");
		//grafico.setIcon( new ImageIcon(escalarGrafico(iconoOriginal)));
		ImageIcon iconoEscala= new ImageIcon(iconoOriginal.getImage().getScaledInstance((int) (grafico.getWidth()*0.7), (int) (grafico.getHeight()*1.4), java.awt.Image.SCALE_DEFAULT));
		//ImageIcon esc
		grafico.setIcon( iconoEscala);
		return puntosKill;
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
}
