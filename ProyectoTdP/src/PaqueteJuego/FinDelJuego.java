package PaqueteJuego;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import PaqueteGenericos.Objeto;
import PaquetePersonajes.Personaje;
import TDAListaDE.PositionList;

class FinDelJuego {
	private GUI gui;
	private Personaje personaje;
	
	public FinDelJuego(GUI g, Personaje per) {
		gui = g;
		personaje = per;
	}
	
	public void chequearVictoria(PositionList<Objeto> listaObjetos) {
		if (listaObjetos.size() == 1) { //La lista de Objetos sólo contiene al Personaje.
			cambiarFondo("./bin/ImageIcons/You Win - Agradecimientos.jpeg");
			new Ganador(gui);
			pararThreads();
		}
		else
			actualizarVida();
	}
		
		private void actualizarVida() {
			gui.getVida().setText("Vida: " + personaje.getVida());
			if (personaje.getVida() <= 30) {
				if (personaje.getVida() <= 0) { //Perder el Juego.
					cambiarFondo("./bin/ImageIcons/Diablo III - You Have Died.jpg");
					pararThreads();
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
		}
		
		
		private void cambiarFondo(String ruta) {
			JLabel nuevoFondo = new JLabel();
			ImageIcon iconoOriginal = new ImageIcon(ruta);
			ImageIcon iconoEscala = new ImageIcon(iconoOriginal.getImage().getScaledInstance(gui.getFrameWidth(), gui.getFrameHeight(), java.awt.Image.SCALE_DEFAULT));
			nuevoFondo.setSize(gui.getFrameWidth(), gui.getFrameHeight());
			nuevoFondo.setIcon(iconoEscala);
			
			gui.getPanel().removeAll();
			gui.setearFondoYPanel(nuevoFondo);
			gui.getPanel().add(personaje.getGrafico());
			gui.getPanel().add(gui.getPuntuacion());
			gui.getPanel().add(gui.getLvl());
			gui.getPanel().add(gui.getNombrePersonaje());
			gui.getPanel().add(gui.getVida());
		}
		
		@SuppressWarnings("deprecation")
		private void pararThreads() {
			gui.getTDisparo().stop();
			gui.getTiempo().stop();
		}
}
