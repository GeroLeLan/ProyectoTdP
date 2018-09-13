package PaqueteObjetosNacho;

import javax.swing.ImageIcon;

public class BarricadaEnemigos extends Obstaculo {
	
	public BarricadaEnemigos(int x, int y) {
		super(x, y);
		setGrafico();
	}
	
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("C:\\Users\\nacho\\Documents\\Nacho - Universidad\\Nacho - Universidad 2018\\Segundo Cuatrimestre\\Tecnología de Programación\\Proyecto\\ProyectoTdP - Chiaravalle, Schimpfle y Le Lan Toussaint\\ProyectoTdP\\src\\ImageIcons\\BARRICADA.png"));
	}

}
