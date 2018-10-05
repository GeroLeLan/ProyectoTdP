package PaqueteJuego;

import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteObjetos.Personaje;
import PaqueteObjetosImplementados.*;

public class Juego {
	
	private PositionList<Enemigo> listaEnemigos;
	private Obstaculo[] obstaculos;
	private Personaje jugador;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiará cuando cambie el nivel.
	
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
	
	public void setJugador(Personaje j) {
		jugador = j;
	}
	public Personaje getPersonaje() {
		return jugador;
	}
	
	public void moverEnemigos() {
		for (Position<Enemigo> enem : listaEnemigos.positions())
			enem.element().mover(0); //El método mover de los Enemigos está definido para recibir un entero en la clase Animado. Quizás debamos cambiar eso.
	}
}
