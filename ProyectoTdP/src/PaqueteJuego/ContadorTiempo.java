package PaqueteJuego;

import javax.swing.ImageIcon;

public class ContadorTiempo extends Thread {

	private Juego elJuego;
	private boolean parar;
	private int cuanto;
	ContadorTiempo(Juego j) {
		elJuego = j;
		parar=false;
		cuanto=0;
	}

	public void run() {
		while(true){
			try {
				if(parar) {
					Thread.sleep(cuanto);
					parar=false;
					elJuego.getGui().mostrarIconoDrop(3, new ImageIcon("./bin/ImageIcons/iconoDropCongelar_Deshabilitado.png"));
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
			
			
			
			elJuego.getGui().actualizarIconos();
		}
	}

	
	public void wait (int i) {
		parar=true;
		cuanto=i;

	}
}