package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
<<<<<<< HEAD
import PaqueteObjetos.DisparoEnemigo;
=======
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
import PaqueteObjetosImplementados.Personaje;

public class ITAP extends Inteligencia {
	private Inteligencia intelActual;
<<<<<<< HEAD
	private boolean tieneArma;
	
	public ITAP(Personaje p) {
		super(p);
		tieneArma=true;
=======
	
	public ITAP(Personaje p) {
		super(p);
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
		icono = new ImageIcon("./bin/ImageIcons/ITAP - Armado.png");
		puntosKill = 20;
		velocidad = 1;
		intelActual = new ITieneArma(p);
	}
	
	public void mover(Point pos) {
		intelActual.mover(pos);
	}
	
	public void cambiarInteligencia(int vida, Enemigo enem) {
		if (vida <= 20) {
			intelActual = new IKB(personajeJuego);
			icono = new ImageIcon("./bin/ImageIcons/ITAP - Desarmado.png");
			enem.setGrafico();
<<<<<<< HEAD
			tieneArma=false;
=======
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
		}
	}
	
	public boolean iniciaConMovimiento() {
		return true;
	}
<<<<<<< HEAD

	@Override
	public Disparo disparar(Point pos) {
		if(tieneArma)
			 return new DisparoEnemigo(pos.x,pos.y);
		return null;
=======
	
	public Disparo disparar(Point pos) {
		return intelActual.disparar(pos);
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	}
}
