package PaqueteArmas;

import PaqueteArmas.Arma;
import PaqueteDisparos.Disparo;

public class ArmaMejoraDaño extends Arma {

	public ArmaMejoraDaño() {
		daño = 100;
	}
	
	public Disparo disparar(int x,int y) {
		return new Disparo(x,y, daño);
		 
	}
}
