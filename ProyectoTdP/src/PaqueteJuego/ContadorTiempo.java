package PaqueteJuego;

import javax.swing.ImageIcon;

public class ContadorTiempo extends Thread {

	private Juego elJuego;

	ContadorTiempo(Juego j) {
		elJuego = j;
	}

	public void run() {
		while(true){
			try {

				Thread.sleep(100);

	
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (elJuego.getPersonaje().getVida() <= 0)
				break;
			elJuego.moverObjetos();
			elJuego.disparosEnemigos();
			
			if(elJuego.getPersonaje().getEscudo()==false) {
				elJuego.getGui().actualizarIconoEscudo();
		}
	}
	}
}