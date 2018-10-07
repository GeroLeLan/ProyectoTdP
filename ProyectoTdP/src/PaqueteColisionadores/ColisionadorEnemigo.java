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
		miEnemigo.recibirDaño(100);
		return personaje.recibirDaño(30); //Quizás estaría bueno que al recibir daño perdieras 5 puntos, o algo así. (Nacho)
	}
}
