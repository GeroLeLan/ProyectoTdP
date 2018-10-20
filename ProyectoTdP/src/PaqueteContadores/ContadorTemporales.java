package PaqueteContadores;

import PaqueteJuego.Juego;

public class ContadorTemporales extends Contador {

	public ContadorTemporales(Juego j) {
		super(j);
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(4);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.moverDisparosYDrops();
		}
	}
}