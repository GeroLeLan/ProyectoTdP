package PaqueteArmas;

import PaqueteArmas.Arma;
import PaqueteDisparos.Disparo;

public class ArmaMejoraDa�o extends Arma {

	public ArmaMejoraDa�o() {
		da�o = 100;
	}
	
	public Disparo disparar(int x,int y) {
		return new Disparo(x,y, da�o);
		 
	}
}
