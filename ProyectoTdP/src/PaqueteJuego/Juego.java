package PaqueteJuego;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteObjetosImplementados.*;

public class Juego {
	
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Objeto> listaObjetos;
	private Obstaculo[] obstaculos;
	private Personaje personaje;
	private GUI gui;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiará cuando cambie el nivel.
	
	public Juego(int dificultad, GUI g) {
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		listaObjetos = new ListaDoblementeEnlazada<Objeto>();
		obstaculos = new Obstaculo[3];
		gui = g;
		mapa = new Mapa(dificultad, this);
	}
	
	public Position<Enemigo> agregarEnemigo(Enemigo e){
		try {
			listaEnemigos.addLast(e);
			listaObjetos.addLast(e);
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
		listaObjetos.addLast(o);
	}
	public Obstaculo getObstaculo(int pos) {
		return obstaculos[pos];
	}
	
	public void setPersonaje(Personaje p) {
		personaje = p;
		listaObjetos.addLast(p);
	}
	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void moverObjetos() {
		try {
			for (Position<Objeto> obj: listaObjetos.positions()) {
				if (obj.element().getVida() <= 0)
					listaObjetos.remove(obj);
				else {
					obj.element().mover();
					Rectangle rectanguloObj = obj.element().getGrafico().getBounds();
					for (Position<Objeto> pos : listaObjetos.positions()) {
						if (pos.element() != obj.element()) {
							Rectangle rectanguloPos = pos.element().getGrafico().getBounds();
							if (rectanguloObj.intersects(rectanguloPos)) {
								int puntos = gui.getPuntaje() + obj.element().colisionar(pos.element());
								if (puntos < 0)
									puntos = 0;
								gui.setPuntaje(puntos);
								gui.getPuntuacion().setText("Puntaje: " + puntos);
							}
						}
					}
					actualizarVida();
				}
			}
		}
		catch (InvalidPositionException exc) {
			System.out.println("Problema con la lista.");
			exc.printStackTrace();
		}
	}
	
	private void actualizarVida() {
		if (personaje.getVida() <= 20) {
			if (personaje.getVida() <= 0) {
				ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Diablo III - You Have Died.jpg");
				ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(gui.getFrameWidth(), gui.getFrameHeight(), java.awt.Image.SCALE_DEFAULT));
				JLabel nuevoFondo = new JLabel();
				nuevoFondo.setSize(gui.getFrameWidth(), gui.getFrameHeight());
				nuevoFondo.setIcon(iconoEscala);
				gui.getPanel().removeAll();
				gui.getPanel().add(personaje.getGrafico());
				gui.getPanel().add(gui.getPuntuacion());
				gui.getPanel().add(gui.getLvl());
				gui.getPanel().add(gui.getNombrePersonaje());
				gui.getPanel().add(gui.getVida());
				gui.getPanel().add(nuevoFondo);
			}
			else {
				gui.getVida().setForeground(new Color(255,0,0));
				gui.getVida().setBackground(new Color(255,0,0));
			}
		}
		else { //Contempla que se agarre un drop que sume vida.
			gui.getVida().setForeground(new Color(255,255,255));
			gui.getVida().setBackground(new Color(255,255,255));
		}
		gui.getVida().setText("Vida: " + personaje.getVida());;
	}
}
