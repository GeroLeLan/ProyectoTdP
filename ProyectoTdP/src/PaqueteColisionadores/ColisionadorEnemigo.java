package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.Drop;
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
		if(!personaje.getEscudo()) {
			System.out.print(personaje.getEscudo());
			miEnemigo.recibirDa�o(100);
			return personaje.recibirDa�o(30);
		}else {
			miEnemigo.recibirDa�o(100);
			personaje.chocoEscudo();
			return 0;
		}
	}

	
	public int chocarDrop(Drop drop) {
		return 0;
	}
}
