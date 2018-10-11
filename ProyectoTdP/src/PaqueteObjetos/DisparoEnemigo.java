package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.ColisionadorDisparoEnemigo;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;

public class DisparoEnemigo extends Disparo {
	public DisparoEnemigo(int x, int y) {
<<<<<<< HEAD
		super(x+30, y+10);
=======
		super(x + 30, y + 15);
>>>>>>> fb99eba33ee07c51505146a6903428833e8d0e65
		setGrafico();
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/dispEnemigo2.gif"));
	}

	public void mover() {
		pos.setLocation(pos.x, pos.y + 5);
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
