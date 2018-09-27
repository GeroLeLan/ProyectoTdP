package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

public class BarricadaEnemigos extends Obstaculo {
	
	public BarricadaEnemigos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 20;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/BARRICADA.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}

	public int morir() {
		return puntosKill;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

}
