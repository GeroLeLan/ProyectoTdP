package PaqueteObjetosNacho;

public abstract class Obstaculo extends Objeto { //Permite que el mapa defina los tipos de Obst�culo en el nivel, bas�ndose en la dificultad.

	protected Obstaculo(int x, int y) {
		super(x, y);
		grafico.setSize(250, 75);
		grafico.setLocation(pos);
	}

}
