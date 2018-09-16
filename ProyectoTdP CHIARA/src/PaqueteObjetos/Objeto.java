package PaqueteObjetos;

import javax.swing.JLabel;

public abstract class Objeto {
	protected int vida;
	protected JLabel grafico;
	protected int posX, posY;
	
	protected Objeto(int x, int y) {
		posX = x;
		posY = y;
		grafico = new JLabel();
	}

	public int getX() {
		return posX;
	}
	public int getY() {
		return posY;
	}
	
	
	protected abstract void setGrafico();
	
	public JLabel getGrafico() {
		if(grafico == null)
			grafico = new JLabel();
		
		return grafico;
	}
}
