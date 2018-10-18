package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.Drop;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;

public class ColisionadorDrop extends Colisionador {
	private Drop miDrop;
	
	public ColisionadorDrop(Drop drop) {
		super();
		miDrop = drop;
	}
	
	public int chocarEnemigo(Enemigo enemigo) { return 0; }
	public int chocarObstaculo(Obstaculo obstaculo) { return 0;	}
	
	public int chocarPersonaje(Personaje personaje) {
		//personaje.mejorar(miDrop);
		if (!miDrop.soyBorrable()) {
			miDrop.mejorar(personaje);
			miDrop.morir();
			return 15; //Creo que estar�a bueno que agarrar un Drop te sume puntos. (Nacho)
		}
		return 0;
	}

	
	public int chocarDrop(Drop drop) {
		return 0;
	}
	
}
