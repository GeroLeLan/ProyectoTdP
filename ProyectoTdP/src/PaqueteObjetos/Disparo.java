package PaqueteObjetos;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparo;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;

<<<<<<< HEAD
public abstract class Disparo extends Intangible {
	protected boolean borrable;
=======
public class Disparo extends Intangible {
>>>>>>> 3d9c1112bc17bf89a881453e8bd8f7bd21b7b5ad
	protected int daño;
	protected int velocidad;
	
	public Disparo(int x, int y) {
		super(x, y);
<<<<<<< HEAD
		borrable=false;
=======
		daño = 200;
>>>>>>> 3d9c1112bc17bf89a881453e8bd8f7bd21b7b5ad
	}
	
	public int getDaño() {
		return daño;
	}
	public boolean soyBorrable() {
		return borrable;
	}
	public int dañarObstaculo(Obstaculo obstaculo) {
		return obstaculo.recibirDisparo(this);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
<<<<<<< HEAD

	abstract public void avanzar() ;
=======
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparo(this));
	}
	
	protected void setGrafico() {}
	
	protected int morir() {
		return 0;
	}
	
	//DEBE REDEFINIR A mover().
>>>>>>> 3d9c1112bc17bf89a881453e8bd8f7bd21b7b5ad
}
