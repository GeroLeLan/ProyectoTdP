package PaqueteObjetos;

import javax.swing.ImageIcon;

<<<<<<< HEAD
public class DisparoEnemigo extends Disparo {

	
	public DisparoEnemigo(int x, int y) {
		super(x, y);
		grafico.setVisible(true);
		grafico.setSize((int)(Xmax*0.05),(int) (Ymax*0.05));
		grafico.setIcon( new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png"));
		grafico.setLocation(pos);
	}
	
	public int morir() {
		return 0;
	}
	
	protected void setGrafico() {
		// TODO Auto-generated method stub
		
	}

	public void avanzar() {
		pos.setLocation(pos.x, pos.y +2);
		if(pos.y>Ymax)
			borrable=true;
		grafico.setLocation(pos);
	}


	
	
	

=======
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
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
}
