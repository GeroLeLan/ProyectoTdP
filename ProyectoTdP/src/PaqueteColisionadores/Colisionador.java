package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;

public abstract class Colisionador {
	protected Colisionador() {}
	
	public abstract int chocarEnemigo(Enemigo enemigo);
	public abstract int chocarPersonaje(Personaje personaje);
	public abstract int chocarObstaculo(Obstaculo obstaculo);
	//public abstract int chocarDrop(Drop drop);
	//public abstract void chocarDisparo(Disparo disparo);
	//CREO QUE EL serChocado() DE UN DISPARO O DE UN DROP NO DEBERÍA HACER NADA. (Nacho)
}
