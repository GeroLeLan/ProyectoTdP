package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;

public class ColisionadorEnemigo extends Colisionador {
	private Enemigo miEnemigo;
	
	public ColisionadorEnemigo(Enemigo enem) {
		super();
		miEnemigo = enem;
	}
	
	public int chocarEnemigo(Enemigo enemigo) { return 0; }
	public int chocarObstaculo(Obstaculo obstaculo) { return 0;	}
	
	public int chocarPersonaje(Personaje personaje) {
		miEnemigo.recibirDa�o(100);
		return personaje.recibirDa�o(30); //Quiz�s estar�a bueno que al recibir da�o perdieras 5 puntos, o algo as�. (Nacho)
	}
}
