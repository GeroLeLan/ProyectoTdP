package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.ColisionadorDisparoEnemigo;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;

public class DisparoEnemigo extends Disparo {
	public DisparoEnemigo(int x, int y) {
		super(x, y);
		setGrafico();
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/Disparo - Enemigo.png"));
	}

	public void mover() {
		pos.setLocation(pos.x, pos.y + 2);
		if(pos.y > Ymax)
			morir();
		grafico.setLocation(pos);
	}
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparoEnemigo(this));
	}
	
	public int dañarObstaculo(Obstaculo obstaculo) { //Necesita ser redefinido para que el Obstáculo lo reciba como un DisparoEnemigo.
		return obstaculo.recibirDisparo(this);
	}
}
