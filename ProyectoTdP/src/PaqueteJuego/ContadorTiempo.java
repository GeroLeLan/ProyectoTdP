package PaqueteJuego;

public class ContadorTiempo extends Thread {

	private Juego elJuego;
	private int cuanto;
	ContadorTiempo(Juego j) {
		elJuego = j;
		cuanto=0;
	}

	public void run() {
		while(true){
			try {
				if(cuanto!=0) {
					Thread.sleep(cuanto);
					cuanto=0;
				}
				Thread.sleep(70);
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
	public void wait (int i) {
		//parar=true;
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cuanto=i;
	}
}