package PaqueteJuego;

import PaqueteDisparos.Disparo;
import PaqueteDrops.Drop;
import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteGenericos.Objeto;
import PaqueteObstaculos.*;
import PaquetePersonajes.Personaje;

public class Juego {
	private GUI gui;
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Drop> listaDrops;
	private PositionList<Disparo> listaDisparos;
	private PositionList<Objeto> listaObjetos;
	private Obstaculo[] obstaculos;
	private Personaje personaje;
	private MovimientosAutomaticos movedor;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiar� cuando cambie el nivel.
	
	public Juego(int dificultad, GUI g) {
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		listaDrops = new ListaDoblementeEnlazada<Drop>();
		listaDisparos = new ListaDoblementeEnlazada<Disparo>();
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		listaObjetos = new ListaDoblementeEnlazada<Objeto>();
		obstaculos = new Obstaculo[3];
		gui = g;
		mapa = new Mapa(dificultad, this);
		movedor = new MovimientosAutomaticos(listaObjetos, listaEnemigos, listaDisparos, listaDrops, gui, personaje);
	}
	
	public void agregarEnemigo(Enemigo e){
		listaEnemigos.addLast(e);
		listaObjetos.addLast(e);
	}
	public void agregarObstaculo(int pos, Obstaculo o) { //pos puede valer 0, 1 o 2.
		obstaculos[pos] = o;
		listaObjetos.addLast(o);
	}
	public void setPersonaje(Personaje p) {
		personaje = p;
		listaObjetos.addLast(p);
	}
	
	public PositionList<Objeto> getListaObjetos() {
		return listaObjetos;
	}
	public PositionList<Enemigo> getListaEnems() {
		return listaEnemigos;
	}
	public PositionList<Disparo> getListaDisp() {
		return listaDisparos;
	}
	public Obstaculo getObstaculo(int pos) {
		return obstaculos[pos];
	}
	public GUI getGui() {
		return gui;
	}
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void moverObjetos() {
		movedor.moverObjetos();
	}
	public void disparosEnemigos() {
		movedor.disparosEnemigos();
	}
	public void moverDisparosYDrops() {
		movedor.moverDisparosYDrops();
	}
}
