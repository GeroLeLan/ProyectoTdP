package PaqueteJuego;

import TDAListaDE.*;

import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Random;

import PaqueteEnemigos.*;

import PaqueteObjetosImplementados.*;

public class Juego {
	
	private PositionList<Enemigo> listaEnemigos;
	private Obstaculo[] obstaculos;
	private Jugador jugador;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiar� cuando cambie el nivel.
	
	public Juego(int dificultad) {
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		obstaculos = new Obstaculo[3];
		mapa = new Mapa(dificultad, this);
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
	
	
	public void agregarObstaculo(int pos, Obstaculo o) { //pos puede valer 0, 1 o 2.
		obstaculos[pos] = o;
	}
	public Obstaculo getObstaculo(int pos) {
		return obstaculos[pos];
	}
	
	public void setJugador(Jugador j) {
		jugador = j;
	}
	public Jugador getJugador() {
		return jugador;
	}
	
	public void mover(){	
		for (Position<Enemigo> c : listaEnemigos.positions()) {
			Random r = new Random();
			int dir = r.nextInt(4);
			c.element().mover(dir);
		}
	}
}
