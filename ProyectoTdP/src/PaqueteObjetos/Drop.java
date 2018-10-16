package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDrop;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Personaje;

public abstract class Drop extends Intangible {
	protected boolean  borrable;
	protected ImageIcon icono;
	protected Drop(int x, int y) {
		super(x, y);
		

		
		setGrafico();
		borrable=false;
	}
	protected void setGrafico() {
		System.out.println("hola set grafico");
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		//grafico.setIcon(new ImageIcon(escalarGrafico(intel.getIcono())));
		grafico.setVisible(true);
		grafico.setLocation(pos);
	}
	public int serChocado(Colisionador c) {
		return 0;
	}

	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDrop(this));
	}

	abstract public void mejorar(Personaje personaje) ;
	public void mover () {
		pos.setLocation(pos.x, pos.y + 1);
		if(pos.y > Ymax) {
			morir();
			borrable=false;
		}
		grafico.setLocation(pos);
	}
	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	public boolean soyBorrable() {
		return borrable;
	}
}
