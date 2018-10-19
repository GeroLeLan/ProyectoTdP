package PaqueteDrops;

import javax.swing.ImageIcon;

import PaqueteColisionadores.Colisionador;
import PaqueteColisionadores.ColisionadorDrop;
import PaqueteGenericos.Objeto;
import PaquetePersonajes.Personaje;
import PaqueteJuego.GUI;

public abstract class Drop extends Objeto {
	protected boolean  borrable;
	protected ImageIcon icono;
	protected GUI gui;
	
	protected Drop(int x, int y, GUI gui) {
		super(x, y);

		this.gui = gui;

		setGrafico();
		borrable = false;
	}
	
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		grafico.setVisible(true);
		grafico.setLocation(pos);
	}
	
	public int serChocado(Colisionador c) {
		return 0;
	}
	public int colisionar(Objeto o) {
		return o.serChocado(new ColisionadorDrop(this));
	}

	abstract public void mejorar(Personaje personaje);
	
	public void mover () {
		pos.setLocation(pos.x, pos.y + 1);
		if(pos.y > Ymax) {
			morir();
			borrable = true;
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
	
	public abstract Drop clone(); //Clonador para el Generador.
}
