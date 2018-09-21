package PaqueteObjetosImplementados;

import java.awt.Point;

import PaqueteObjetosImplementados.Objeto;

public abstract class Animado extends Objeto {
	protected int velocidad;
	protected Animado(int velocidad, int x, int y) {
		super(x, y);
		this.pos = new Point(x, y);
		this.velocidad = velocidad;
	}
	public int recibirDaño(int d) {
		vida-=d;
		if(vida<=0) {
			return morir();
		}else
			return 0;
	}
	protected int fuerzaK;//es el daño que produce al chocar con algo (yo propongo cambiarlo a fuerzaI o fuerza solo (gero))
	//public abstract void mover (int i) ;//no se si deberia ser protected 
	public void mover(int dir){	
		switch (dir) {
			case 0 : //Arriba
				pos.setLocation(pos.x, pos.y - velocidad);
				break;
			case 1 : //Abajo
				pos.setLocation(pos.x, pos.y + velocidad);
				break;
			case 2 : //Izquierda
				pos.setLocation(pos.x - velocidad, pos.y);
				break;
			case 3 : //Derecha
				pos.setLocation(pos.x + velocidad, pos.y);
				break;
				
		}
		grafico.setLocation(pos);
	}
}
