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
				Thread.sleep(200);
=======
				Thread.sleep(400);
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverObjetos();
<<<<<<< HEAD
=======
			elJuego.disparosEnemigos();
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
		}
	}
}