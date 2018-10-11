package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;
import PaqueteObjetos.DisparoEnemigo;

public class BarricadaEnemigos extends Obstaculo {
	
	public BarricadaEnemigos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 60;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/BARRICADA.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}
	
	public int recibirDisparo(DisparoEnemigo dispEnem) { //El disparo del Enemigo no le hace nada a este tipo de obstáculos.
		return 0;
	}

}
