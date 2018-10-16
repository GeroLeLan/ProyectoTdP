package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.DisparoEnemigo;
import PaqueteObjetos.Drop;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;

public class ColisionadorDisparoEnemigo extends Colisionador {
private DisparoEnemigo miDisparo;
	
	public ColisionadorDisparoEnemigo(DisparoEnemigo disp) {
		super();
		miDisparo = disp;
	}
	
	public int chocarEnemigo(Enemigo enemigo) {
		return 0;
	}
	
	public int chocarPersonaje(Personaje personaje) {
		if (!miDisparo.soyBorrable()) {
			miDisparo.morir();
			return personaje.recibirDaño(miDisparo.getDaño());
		}
		return 0;
	}
	
	public int chocarObstaculo(Obstaculo obstaculo) {
		if (!miDisparo.soyBorrable())
			return miDisparo.dañarObstaculo(obstaculo);
		return 0;
		
	}

	
	public int chocarDrop(Drop drop) {
		return 0;
	}
}
