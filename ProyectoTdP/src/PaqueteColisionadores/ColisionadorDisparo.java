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
		return enemigo.recibirDaño(miDisparo.getDaño());
	}
	
	public int chocarPersonaje(Personaje personaje) {
		return personaje.recibirDaño(miDisparo.getDaño()); //Quizás estaría bueno que al recibir daño perdieras 5 puntos, o algo así. (Nacho)
	}
	
	public int chocarObstaculo(Obstaculo obstaculo) {
		return miDisparo.dañarObstaculo(obstaculo);
	}
}
