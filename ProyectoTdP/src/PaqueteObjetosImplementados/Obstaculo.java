package PaqueteObjetosImplementados;

import PaqueteColisionadores.Colisionador;
import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoEnemigo;

public abstract class Obstaculo extends Objeto { //Permite que el mapa defina los tipos de Obstáculo en el nivel (basándose en la dificultad del nivel), y no la GUI.
	protected int puntosKill;
	
	protected Obstaculo(int x, int y) {
		super(x, y);
		grafico.setSize((int)(Xmax*0.09),(int)(Ymax*0.07));
		grafico.setLocation(pos);
	}
	
	public int recibirDisparo(Disparo dispPer) {
		vida -= dispPer.getDaño();
		if (vida <= 0)
			return morir();
		return 0;
	}
	public abstract int recibirDisparo(DisparoEnemigo dispEnem);
	
	public int serChocado(Colisionador c) {
		return c.chocarObstaculo(this);
	}
}
