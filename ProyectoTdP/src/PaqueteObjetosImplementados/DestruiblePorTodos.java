package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

public class DestruiblePorTodos extends Obstaculo {

	public DestruiblePorTodos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 10;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/DESTRUIBLE.png");
		ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(grafico.getWidth(), grafico.getHeight(), java.awt.Image.SCALE_DEFAULT));
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
