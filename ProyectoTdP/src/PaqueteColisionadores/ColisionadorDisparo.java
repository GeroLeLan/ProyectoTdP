package PaqueteColisionadores;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.Disparo;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;

public class ColisionadorDisparo extends Colisionador {
	private Disparo miDisparo;
	
	public ColisionadorDisparo(Disparo disp) {
		super();
		miDisparo = disp;
	}
	
	public int chocarEnemigo(Enemigo enemigo) {
		return enemigo.recibirDa�o(miDisparo.getDa�o());
	}
	
	public int chocarPersonaje(Personaje personaje) {
		return personaje.recibirDa�o(miDisparo.getDa�o()); //Quiz�s estar�a bueno que al recibir da�o perdieras 5 puntos, o algo as�. (Nacho)
	}
	
	public int chocarObstaculo(Obstaculo obstaculo) {
		return miDisparo.da�arObstaculo(obstaculo);
	}
}
