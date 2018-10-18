package PaqueteJuego;

public class ContadorTDisparo extends Thread {
	private Juego elJuego;

	ContadorTDisparo(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(11);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverDisparosyDrops();
		}
	}
}