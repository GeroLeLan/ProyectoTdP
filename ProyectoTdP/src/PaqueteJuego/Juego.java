package PaqueteJuego;

import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteObjetos.Disparo;
import PaqueteObjetos.DisparoEnemigo;
import PaqueteObjetosImplementados.*;

public class Juego {
	private GUI gui;
	private int frecuencia =0;//camabiar en un futuro cercano 
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Disparo> listaDisparos;
	private Obstaculo[] obstaculos;
	private Personaje jugador;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiará cuando cambie el nivel.
	
	public Juego(int dificultad, GUI g) {
		gui=g;
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		listaDisparos = new ListaDoblementeEnlazada<Disparo>();
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
	public PositionList<Disparo> getListaDisp() {
		return listaDisparos;
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
		for (Position<Enemigo> enem : listaEnemigos.positions()) {
		enem.element().mover(0); //El método mover de los Enemigos está definido para recibir un entero en la clase Animado. Quizás debamos cambiar eso.
		frecuencia++;
		if(frecuencia==97) {
			Disparo dis =enem.element().disparar();
			//Disparo dis=new DisparoEnemigo(enem.element().getPos().x,enem.element().getPos().y);
			if(dis!=null) {
			listaDisparos.addLast(dis);
			gui.getPanel().add(dis.getGrafico());
			}
			frecuencia=0;
		}
			
		}
	}

	public void moverMoverDisparos() {
		for (Position<Disparo> dis : listaDisparos.positions()) {
			
			dis.element().avanzar();
			if(dis.element().soyBorrable())
				try {
					listaDisparos.remove(dis);
				} catch (InvalidPositionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
