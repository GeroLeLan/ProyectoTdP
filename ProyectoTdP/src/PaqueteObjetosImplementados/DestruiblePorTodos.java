package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

public class DestruiblePorTodos extends Obstaculo {

	public DestruiblePorTodos(int x, int y) {
		super(x, y);
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/DESTRUIBLE.png"));
	}

	public int morir() {
		return 0;
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
	}
	
}
