package PaqueteEnemigos;

import java.awt.Point;
import javax.swing.ImageIcon;

import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoEnemigo;
import PaqueteObjetosImplementados.Personaje;

public class ITAP extends Inteligencia {
	private Inteligencia intelActual;
	private boolean tieneArma;
	
	public ITAP(Personaje p) {
		super(p);
		tieneArma=true;
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
			tieneArma=false;
		}
	}
	
	public boolean iniciaConMovimiento() {
		return true;
	}

	@Override
	public Disparo disparar(Point pos) {
		if(tieneArma)
			 return new DisparoEnemigo(pos.x,pos.y);
		return null;
	}
}
