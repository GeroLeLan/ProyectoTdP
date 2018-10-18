package PaqueteArmas;

import PaqueteArmas.Arma;
import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoPersonaje;

public class ArmaMejorada extends Arma {

	public ArmaMejorada() {
		super();
		daño=100;
	}

	@Override

	public Disparo disparar(int x,int y) {
		return new DisparoPersonaje(x,y, daño);
		 
	}
}
