package PaqueteJuego;

import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import TDAListaDE.*;
import PaqueteEnemigos.*;
import PaqueteObjetos.Disparo;
<<<<<<< HEAD
import PaqueteObjetos.DisparoEnemigo;
=======
//import PaqueteObjetos.DisparoEnemigo;
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
import PaqueteObjetosImplementados.*;

public class Juego {
	private GUI gui;
<<<<<<< HEAD
	private int frecuencia =0;//camabiar en un futuro cercano 
=======
	private int frecuencia = 0; //Determina cada cu�nto dispara un enemigo.
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	private PositionList<Enemigo> listaEnemigos;
	private PositionList<Disparo> listaDisparos;
	private PositionList<Objeto> listaObjetos;
	private Obstaculo[] obstaculos;
	private Personaje personaje;
	@SuppressWarnings("unused")
	private Mapa mapa; //Cambiar� cuando cambie el nivel.
	
	public Juego(int dificultad, GUI g) {
<<<<<<< HEAD
		gui=g;
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		listaDisparos = new ListaDoblementeEnlazada<Disparo>();
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
=======
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
		listaDisparos = new ListaDoblementeEnlazada<Disparo>();
		listaEnemigos = new ListaDoblementeEnlazada<Enemigo>();
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
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
	public PositionList<Disparo> getListaDisp() {
		return listaDisparos;
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
<<<<<<< HEAD
	}
	
	public void moverObjetos() {
		try {
			for (Position<Objeto> obj: listaObjetos.positions()) {
				if (obj.element().getVida() <= 0)
					listaObjetos.remove(obj);
				else {
					obj.element().mover();
					Rectangle rectanguloObj = obj.element().getGrafico().getBounds();
					setearBordes(rectanguloObj);
					for (Position<Objeto> pos : listaObjetos.positions()) {
						if (pos.element() != obj.element()) {
							Rectangle rectanguloPos = pos.element().getGrafico().getBounds();
							setearBordes(rectanguloPos);
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
=======
	}
	
	public void moverObjetos() {
		try {
			for (Position<Objeto> obj: listaObjetos.positions()) {
				if (obj.element().getVida() <= 0)
					listaObjetos.remove(obj);
				else {
					obj.element().mover();
					colisionesEntreObjetos(obj.element());
					actualizarVida();
				}
			}
		}
		catch (InvalidPositionException exc) {
			System.out.println("Problema con la lista.");
			exc.printStackTrace();
		}
	}
	
	public void disparosEnemigos() {
		for (Position<Enemigo> enem : listaEnemigos.positions()) {
			frecuencia++;
			if(frecuencia == 97) {
				Disparo dis = enem.element().disparar();
				if(dis != null) {
					listaDisparos.addLast(dis);
					gui.getPanel().add(dis.getGrafico());
				}
				frecuencia = 0;
			}	
		}
	}

	public void moverDisparos() {
		for (Position<Disparo> dis : listaDisparos.positions()) {
			dis.element().mover();
			colisionesEntreObjetos(dis.element());
			if(dis.element().soyBorrable()) {
				try {
					listaDisparos.remove(dis);
				}
				catch (InvalidPositionException e) {
					e.printStackTrace();
				}
			}
			actualizarVida();
		}
	}
	
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	
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
<<<<<<< HEAD
		public void moverEnemigos() {
		for (Position<Enemigo> enem : listaEnemigos.positions()) {
		enem.element().mover(); //El m�todo mover de los Enemigos est� definido para recibir un entero en la clase Animado. Quiz�s debamos cambiar eso.
		frecuencia++;
		if(frecuencia==97) {
			Disparo dis =enem.element().disparar();
			Disparo dis=new DisparoEnemigo(enem.element().getPos().x,enem.element().getPos().y);
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
		

	private void setearBordes(Rectangle re) {
		re.setBounds(re.x, (int) (re.y * 1.8), (int) (re.getWidth() * 0.8), (int) (re.getHeight() * 0.7));
=======
	
	
	private void colisionesEntreObjetos(Objeto obj) {
		Rectangle rectanguloObj = obj.getGrafico().getBounds();
		setearBordes(rectanguloObj);
		for (Position<Objeto> pos : listaObjetos.positions()) {
			if (pos.element() != obj) {
				Rectangle rectanguloPos = pos.element().getGrafico().getBounds();
				setearBordes(rectanguloPos);
				if (rectanguloObj.intersects(rectanguloPos)) {
					int puntos = gui.getPuntaje() + obj.colisionar(pos.element());
					if (puntos < 0)
						puntos = 0;
					gui.setPuntaje(puntos);
					gui.getPuntuacion().setText("Puntaje: " + puntos);
				}
			}
		}
	}
	private void setearBordes(Rectangle re) {
		re.setBounds(re.x, (int) (re.y * 2), (int) (re.getWidth() * 0.8), (int) (re.getHeight() * 0.7));
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
	}
}
