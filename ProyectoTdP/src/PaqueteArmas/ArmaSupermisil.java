package PaqueteArmas;


import PaqueteDisparos.Disparo;
import PaqueteDisparos.MegaDisparo;

public class ArmaSupermisil extends Arma{

	public ArmaSupermisil() {
		daño=20;
	}
	public Disparo disparar(int x, int y) {
		return new MegaDisparo(x,y,daño);
	}

}
