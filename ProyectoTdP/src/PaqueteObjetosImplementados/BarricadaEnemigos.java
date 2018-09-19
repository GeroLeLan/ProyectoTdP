package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

public class BarricadaEnemigos extends Obstaculo {
	
	public BarricadaEnemigos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 20;
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/BARRICADA.png"));
	}

	public int morir() {
		return puntosKill;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}

}
