package PaqueteJuego;

public class ContadorTiempo extends Thread {

	private Juego elJuego;

	ContadorTiempo(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(200);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			elJuego.moverEnemigos();
		}
	}
}