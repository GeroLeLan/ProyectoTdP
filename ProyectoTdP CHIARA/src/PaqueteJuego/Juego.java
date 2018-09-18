package PaqueteJuego;

import TDAListaDE.*;
import PaqueteObjetos.*;
import PaqueteEnemigos.*;

public class Juego {
	private PositionList<Enemigo> listaEnemigos;
	private Obstaculo[] obstaculos;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiar� cuando cambie el nivel.
	
	public Juego() {
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		obstaculos = new Obstaculo[2];
		mapa = new Mapa(1, this);
	}
	
	public Position<Enemigo> agregarEnemigo(Enemigo e){
		try {
			listaEnemigos.addLast(e);
			return listaEnemigos.last();
		}
		catch (EmptyListException exc) {
			System.out.println("Problema con la lista.");
			exc.printStackTrace();
			return null;
		}
	}
	public PositionList<Enemigo> getListaEnems() {
		return listaEnemigos;
	}
	
	
	public void agregarObstaculo(int pos, Obstaculo o) { //pos puede valer 0 o 1.
		obstaculos[pos] = o;
	}
	public Obstaculo getObstaculo(int pos) {
		return obstaculos[pos];
	}
}