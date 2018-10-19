package PaqueteJuego;

public class ContadorTiempo extends Thread {
	private Juego elJuego;
	private int cuanto;
	
	ContadorTiempo(Juego j) {
		elJuego = j;
<<<<<<< HEAD
		cuanto=0;
=======
		parar = false;
		cuanto = 0;
>>>>>>> 1c09ce1f2121ab38be223e0bfdfd160a2389b17e
	}

	public void run() {
		while(true) {
			try {
				if(cuanto!=0) {
					Thread.sleep(cuanto);
<<<<<<< HEAD
					cuanto=0;
=======
					parar = false;
>>>>>>> 1c09ce1f2121ab38be223e0bfdfd160a2389b17e
				}
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverObjetos();
			elJuego.disparosEnemigos();
			
			if(elJuego.getPersonaje().getEscudo() == false)
				elJuego.getGui().actualizarIconoEscudo();
		}
	}
	
	public void wait (int i) {
<<<<<<< HEAD
		//parar=true;
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		cuanto=i;
=======
		parar = true;
		cuanto = i;
>>>>>>> 1c09ce1f2121ab38be223e0bfdfd160a2389b17e
	}
}