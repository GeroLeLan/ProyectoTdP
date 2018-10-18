package PaqueteArmas;

import PaqueteArmas.Arma;
import PaqueteDisparos.Disparo;

public class ArmaMejorada extends Arma {

	public ArmaMejorada() {
		super();
		da�o = 100;
	}
	
	public Disparo disparar(int x,int y) {
		System.out.println("hola disparo mejorado disparar");
		return new Disparo(x,y, da�o);
		 
	}
}
