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
<<<<<<< HEAD
			elJuego.moverMoverDisparos();
=======
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverDisparos();
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
		}
	}
}