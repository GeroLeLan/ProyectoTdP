package PaqueteObjetosImplementados;

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
<<<<<<< HEAD
		vida = 150;
=======
		vida = 50;
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	}
	
	public int recibirDisparo(Disparo dispPer) {
		vida -= dispPer.getDaño();
<<<<<<< HEAD
=======
		dispPer.morir();
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
		if (vida <= 0)
			return morir();
		return 0;
	}
<<<<<<< HEAD
	public abstract int recibirDisparo(DisparoEnemigo dispEnem);
=======
	public abstract int recibirDisparo(DisparoEnemigo dispEnem); //Método sobrecargado para diferenciar si debe hacerle daño el DisparoEnemigo o no.
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	
	public int serChocado(Colisionador c) {
		return c.chocarObstaculo(this);
	}
	
	protected int morir() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Animación - Muerte de Enemigo.gif");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		return puntosKill;
	}
	
	public int colisionar(Objeto o) {
		return 0;
	}
}
