package PaqueteObjetosImplementados;

import javax.swing.JLabel;
import java.awt.Point;

public abstract class Objeto {
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
	public abstract void morir();
	public abstract void colisionar();
	
}
