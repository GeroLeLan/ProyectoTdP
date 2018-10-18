package PaqueteObstaculos;

import javax.swing.ImageIcon;

import PaqueteDisparos.DisparoEnemigo;

public class DestruiblePorTodos extends Obstaculo {

	public DestruiblePorTodos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 40;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/DESTRUIBLE.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}
	
	public int recibirDisparo(DisparoEnemigo dispEnem) {
		dispEnem.morir();
		vida -= dispEnem.getDa�o();
		if (vida <= 0)
			morir(); //Si un enemigo destruye al Obst�culo, no se suman puntos.
		return 0;
	}
	
}
