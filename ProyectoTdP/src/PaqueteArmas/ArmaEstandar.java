package PaqueteArmas;

import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoPersonaje;

public class ArmaEstandar extends Arma {
	public ArmaEstandar() {
		daño=10;
	}
	public Disparo disparar(int x,int y) {
		return new DisparoPersonaje(x,y, daño);
		 
	}
}
