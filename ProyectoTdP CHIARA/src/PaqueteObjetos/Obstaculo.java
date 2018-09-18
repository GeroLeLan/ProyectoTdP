package PaqueteObjetos;

public abstract class Obstaculo extends Objeto { //Permite que el mapa defina los tipos de Obstáculo en el nivel, basándose en la dificultad.

	protected Obstaculo(int x, int y) {
		super(x, y);
	}

}
