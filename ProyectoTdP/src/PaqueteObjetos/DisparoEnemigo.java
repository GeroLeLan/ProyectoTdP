package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.ColisionadorDisparoEnemigo;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;

public class DisparoEnemigo extends Disparo {
<<<<<<< HEAD
	public DisparoEnemigo(int x, int y) {
		super(x+30, y+10);
=======
	public DisparoEnemigo(int x, int y,int d) {

		super(x + 30, y + 15,d);

>>>>>>> 6c8ac22eacaaf15be989a03ccc8976d64f8c6d42
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
