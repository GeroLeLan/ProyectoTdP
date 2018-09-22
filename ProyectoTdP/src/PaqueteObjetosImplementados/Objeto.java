package PaqueteObjetosImplementados;

import javax.swing.JLabel;
import java.awt.Point;

public abstract class Objeto {
	protected static final int Ymax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	protected static final int Xmax = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	
	protected int vida;
	protected JLabel grafico;
	protected Point pos;   
	
	protected Objeto(int x, int y) {
		pos = new Point(x, y);
		grafico = new JLabel();
	}

	public Point getPos() {
		return pos;
	}
		
	protected abstract void setGrafico();
	
	public JLabel getGrafico() {
		if(grafico == null)
			grafico = new JLabel();
		
		return grafico;
	}
	
	
	protected abstract int morir();
	public abstract void colisionar();
	
}
