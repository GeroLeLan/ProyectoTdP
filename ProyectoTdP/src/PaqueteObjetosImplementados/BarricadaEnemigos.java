package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

public class BarricadaEnemigos extends Obstaculo {
	
	public BarricadaEnemigos(int x, int y) {
		super(x, y);
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("C:\\Yo\\Nueva carpeta\\ProyectoTdP\\src\\ImageIcons\\DESTRUIBLE.png"));
	}

}
