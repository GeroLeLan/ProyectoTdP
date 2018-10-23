package PaqueteArmas;

import PaqueteDisparos.Disparo;
import PaqueteDisparos.DisparoPerforador;

public class ArmaDisparoPerforador extends Arma {
	
	public ArmaDisparoPerforador() {
		super();
	}
	
	public Disparo disparar(int x, int y) {
		return new DisparoPerforador(x, y, daño);
	}

}
