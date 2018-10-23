package PaqueteJuego;

import java.awt.Color;
import java.io.*;
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
		if (listaObjetos.size() == 1) //La lista de Objetos sólo contiene al Personaje.
			ganar();
		else
			actualizarVida();
	}
	
		
		private void ganar() {
			cambiarFondo("./bin/ImageIcons/You Win.jpg");
			try {
				BufferedReader br;
				FileReader fr = new FileReader("./bin/High Scores.txt");
				br = new BufferedReader(fr);
				String cadena;
				int lineaCambio = -1;
				String[] puntuaciones = new String[5];
				
				for (int i = 0; i < 5; i++) {
					cadena = br.readLine();
					puntuaciones[i] = cadena;
					if (lineaCambio == -1) {
						int j = 2;
						while (cadena.charAt(j - 1) != ' ')
							j++;
						String valorCad = cadena.substring(j);
						int valor = Integer.parseInt(valorCad);
						if (valor < gui.getPuntaje())
							lineaCambio = i;
					}
				}
				br.close();
				
				if (lineaCambio >= 0)
					actualizarTablaHighScores(lineaCambio, puntuaciones);
				
			}
			catch(IOException exc) {
				System.out.println("Error al leer el archivo de High Scores.");
				exc.printStackTrace();
			}
			pararThreads();
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
				ImageIcon iconoOriginal = new ImageIcon(ruta);
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
			
			private void actualizarTablaHighScores(int lineaCambio, String[] archivoViejo) {
				try {
					File logFile = new File("./bin/High Scores.txt");
					BufferedWriter bw;
					FileWriter fw = new FileWriter(logFile);
					bw = new BufferedWriter(fw);
					for (int i = 0; i < lineaCambio; i++) {
						bw.write(archivoViejo[i]);
						bw.newLine();
					}
					
					bw.write(gui.getNombrePersonaje().getText() + " " + gui.getPuntaje());
					
					for (int j = lineaCambio + 1; j < 5; j++) {
						bw.newLine();
						bw.write(archivoViejo[j - 1]);
					}
					
					bw.close();
				}
				catch(IOException exc) {
					System.out.println("Error al sobreescribir el archivo de High Scores.");
					exc.printStackTrace();
				}
			}
			
			@SuppressWarnings("deprecation")
			private void pararThreads() {
				gui.getTDisparo().stop();
				gui.getTiempo().stop();
			}
}
