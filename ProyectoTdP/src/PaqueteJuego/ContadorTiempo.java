package PaqueteJuego;

public class ContadorTiempo extends Thread {

	private Juego elJuego;

	ContadorTiempo(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(true){
			try {
<<<<<<< HEAD
				Thread.sleep(100);
=======
				Thread.sleep(150);
>>>>>>> fb99eba33ee07c51505146a6903428833e8d0e65
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverObjetos();
			elJuego.disparosEnemigos();
		}
	}
}