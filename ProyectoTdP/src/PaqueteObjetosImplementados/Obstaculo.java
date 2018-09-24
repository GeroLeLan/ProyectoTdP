package PaqueteObjetosImplementados;

public abstract class Obstaculo extends Objeto { //Permite que el mapa defina los tipos de Obst�culo en el nivel, bas�ndose en la dificultad.
	protected int puntosKill;
	
	protected Obstaculo(int x, int y) {
		super(x, y);
		grafico.setSize((int)(Xmax*0.09),(int)(Ymax*0.07));
		grafico.setLocation(pos);
	}

}
