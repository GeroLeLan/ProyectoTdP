package PaqueteJuego;

public class ContadorTemporales extends Thread {
	private Juego elJuego;

	ContadorTemporales(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(4);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverDisparos();
		}
	}
}