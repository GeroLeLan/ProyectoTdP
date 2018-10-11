package PaqueteObjetos;

<<<<<<< HEAD
import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparo;
=======
import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDisparoPersonaje;
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;


<<<<<<< HEAD
public abstract class Disparo extends Intangible {
=======
public class Disparo extends Intangible {
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	protected boolean borrable;
	protected int daño;
	protected int velocidad;
	
	public Disparo(int x, int y) {
		super(x, y);
<<<<<<< HEAD

		borrable=false;

		daño = 200;

=======
		borrable = false;
		daño = 10;
		setGrafico();
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/Disparo - Personaje.png"));
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
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

	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparo(this));
	}
	
	protected void setGrafico() {}
	
	protected int morir() {
		return 0;
	}
	
	//DEBE REDEFINIR A mover().
=======
	
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDisparoPersonaje(this));
	}
	
	protected void setGrafico() {
		grafico.setVisible(true);
		grafico.setSize((int)(Xmax*0.01),(int) (Ymax*0.03));
		grafico.setLocation(pos);
	}
	
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mover() {
		pos.setLocation(pos.x, pos.y - 2);
		if(pos.y <= 0)
			borrable=true;
		grafico.setLocation(pos);
	}
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929

}
