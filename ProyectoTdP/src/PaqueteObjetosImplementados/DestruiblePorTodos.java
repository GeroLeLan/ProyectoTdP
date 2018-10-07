package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoEnemigo;

public class DestruiblePorTodos extends Obstaculo {

	public DestruiblePorTodos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 10;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/DESTRUIBLE.png");
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

	public int recibirDaño(int d, Disparo disp) {
		vida -= d;
		if (vida <= 0)
			return morir();
		return 0;
	}
	
	public int recibirDisparo(DisparoEnemigo dispEnem) {
		vida -= dispEnem.getDaño();
		if (vida <= 0)
			return morir();
		return 0;
	}
	
}
