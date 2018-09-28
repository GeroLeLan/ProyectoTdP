package PaqueteJuego;

import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

import PaqueteEnemigos.Enemigo;
import PaqueteObjetos.Personaje;
import PaqueteObjetosImplementados.Objeto;
import TDAListaDE.EmptyListException;
import TDAListaDE.InvalidPositionException;

public class AccionTeclado extends KeyAdapter {
	private GUI gui;
	private Personaje personaje;
	
	public AccionTeclado(GUI g) {
		super();
		gui = g;
		personaje = gui.getPersonaje();
	}
	
	public void keyPressed(KeyEvent arg0) {
		int direction = arg0.getKeyCode();
		
		if (direction == KeyEvent.VK_LEFT || direction == KeyEvent.VK_A) {
			ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png");
			ImageIcon iconoEscala = new ImageIcon(escalarImagen(iconoOriginal, personaje));
			gui.grafico(personaje).setIcon(iconoEscala);
			if (posicion(personaje).x - 5 > 0)
				posicion(personaje).x -= personaje.getVel();
		}
		if (direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_D) {
			ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Derecha.png");
			ImageIcon iconoEscala = new ImageIcon(escalarImagen(iconoOriginal, personaje));
			gui.grafico(personaje).setIcon(iconoEscala);
			if (posicion(personaje).x < gui.getFrameWidth() * 0.9)
				posicion(personaje).x += personaje.getVel();
		}
		
		gui.grafico(personaje).setLocation(posicion(personaje));
	}
	
	public void keyReleased(KeyEvent arg0) {
		int direction = arg0.getKeyCode();
		
		if (direction == KeyEvent.VK_LEFT || direction == KeyEvent.VK_RIGHT || direction == KeyEvent.VK_A || direction == KeyEvent.VK_D) {
			ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Jugador - Est�ndar.png");
			ImageIcon iconoEscala = new ImageIcon(escalarImagen(iconoOriginal, personaje));
			gui.grafico(personaje).setIcon(iconoEscala);
		}
		
		if (direction == KeyEvent.VK_K && !gui.getListaEnemigos().isEmpty()) {
			try {
				Enemigo e = gui.getListaEnemigos().first().element();
				gui.setPuntaje(gui.getPuntaje() + e.recibirDa�o(1000000));
				gui.getPanel().add(gui.grafico(e));
				gui.getListaEnemigos().remove(gui.getListaEnemigos().first());
				gui.getPuntuacion().setText("Puntaje: " + gui.getPuntaje());
			}
			catch (EmptyListException | InvalidPositionException exc) {
				System.out.println(exc.getMessage() + "\n");
				exc.printStackTrace();
			}
		}
		
			
	}
	
	
	private Image escalarImagen(ImageIcon original, Objeto o) {
		return original.getImage().getScaledInstance(gui.grafico(o).getWidth(), gui.grafico(o).getHeight(), java.awt.Image.SCALE_DEFAULT);
	}
	private Point posicion(Objeto o) {
		return o.getPos();
	}
}
