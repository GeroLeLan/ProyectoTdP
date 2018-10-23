package PaqueteDisparos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.ColisionadorDisparoEnemigo;
import PaqueteGenericos.Objeto;
import PaqueteObstaculos.Obstaculo;

public class DisparoEnemigo extends Disparo {

	public DisparoEnemigo(int x, int y,int d) {

		super(x + 30, y + 15,d);


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
	
	public int da�arObstaculo(Obstaculo obstaculo) { //Necesita ser redefinido para que el Obst�culo lo reciba como un DisparoEnemigo.
		return obstaculo.recibirDisparo(this);
	}
}