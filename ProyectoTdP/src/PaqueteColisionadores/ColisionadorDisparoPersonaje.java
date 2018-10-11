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
			return enemigo.recibirDa�o(miDisparo.getDa�o());
		}
		return 0;
	}
	
	public int chocarPersonaje(Personaje personaje) {
		return 0;
	}
	
	public int chocarObstaculo(Obstaculo obstaculo) {
		if (!miDisparo.soyBorrable())
			return miDisparo.da�arObstaculo(obstaculo);
		return 0;
	}
}
