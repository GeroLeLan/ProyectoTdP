package PaqueteJuego;

import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.Disparo;
import PaqueteObjetosImplementados.Objeto;
import PaqueteObjetosImplementados.Obstaculo;
import PaqueteObjetosImplementados.Personaje;
import TDAListaDE.EmptyListException;
import TDAListaDE.InvalidPositionException;

public class AccionTeclado extends KeyAdapter {
	private GUI gui;
	private Juego juego;
	private Personaje personaje;
	
	public AccionTeclado(GUI g, Juego j) {
		super();
		gui = g;
		personaje = gui.getPersonaje();
		juego = j;
	}
	
	public void keyPressed(KeyEvent arg0) {
		int direccion = arg0.getKeyCode();
		if (personaje.getVida() > 0)
			personaje.mover(direccion);
	}
	
	public void keyReleased(KeyEvent arg0) {
		int comando = arg0.getKeyCode();
		if (personaje.getVida() > 0) {
			if (comando == KeyEvent.VK_LEFT || comando == KeyEvent.VK_RIGHT || comando == KeyEvent.VK_A || comando == KeyEvent.VK_D)
					acomodarJugador();
			if (comando == KeyEvent.VK_K && !gui.getListaEnemigos().isEmpty())
					dañarEnemigo();
			if (comando == KeyEvent.VK_C)
					dañarObstaculo();
			if (comando == KeyEvent.VK_SPACE)
				personajeDispara();
		}
	}
	
	
	private Image escalarImagen(ImageIcon original, Objeto o) {
		return original.getImage().getScaledInstance(gui.grafico(o).getWidth(), gui.grafico(o).getHeight(), java.awt.Image.SCALE_DEFAULT);
	}
	
	private void acomodarJugador() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Estándar.png");
		ImageIcon iconoEscala = new ImageIcon(escalarImagen(iconoOriginal, personaje));
		gui.grafico(personaje).setIcon(iconoEscala);
	}
	
	private void dañarEnemigo() {
		try {
			Enemigo e = gui.getListaEnemigos().first().element();
			gui.setPuntaje(gui.getPuntaje() + e.recibirDaño(100));
			if (e.getVida() <= 0) {
				gui.getPanel().add(gui.grafico(e));
				gui.getListaEnemigos().remove(gui.getListaEnemigos().first());
				gui.getPuntuacion().setText("Puntaje: " + gui.getPuntaje());
			}
		}
		catch (EmptyListException | InvalidPositionException exc) {
			System.out.println(exc.getMessage() + "\n");
			exc.printStackTrace();
		}
	}
	
	private void dañarObstaculo() {
		Obstaculo o = juego.getObstaculo(0);
		if (o.getVida() <= 0) {
			o = juego.getObstaculo(1);
			if (o.getVida() <= 0) {
				o = juego.getObstaculo(2);
			}
		}		
		if (o.getVida() > 0) {
			gui.setPuntaje(gui.getPuntaje() + o.recibirDisparo(new Disparo(0,0)));
			gui.getPuntuacion().setText("Puntaje: " + gui.getPuntaje());
		}
	}
	
	private void personajeDispara() {
		Disparo dis = personaje.disparar();
		juego.getListaDisp().addLast(dis);
		gui.getPanel().add(dis.getGrafico());
	}
	
}
