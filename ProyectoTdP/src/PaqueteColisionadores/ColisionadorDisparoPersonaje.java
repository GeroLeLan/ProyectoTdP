package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.Disparo;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;

public class ColisionadorDisparoPersonaje extends Colisionador {
	private Disparo miDisparo;
	
	public ColisionadorDisparoPersonaje(Disparo disp) {
		super();
		miDisparo = disp;
	}
	
	public int chocarEnemigo(Enemigo enemigo) {
		if (!miDisparo.soyBorrable()) {
			miDisparo.morir();
			return enemigo.recibirDaņo(miDisparo.getDaņo());
		}
		return 0;
	}
	
	public int chocarPersonaje(Personaje personaje) {
		return 0;
	}
	
	public int chocarObstaculo(Obstaculo obstaculo) {
		if (!miDisparo.soyBorrable())
			return miDisparo.daņarObstaculo(obstaculo);
		return 0;
	}
}
