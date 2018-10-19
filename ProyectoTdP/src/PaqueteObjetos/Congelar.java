package PaqueteObjetos;

import javax.swing.ImageIcon;

import PaqueteEnemigos.Enemigo;
import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;
import TDAListaDE.Position;

public class Congelar extends Temporales{

	public Congelar(int x, int y,GUI gui) {
		super(x, y,gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleCongelar.gif"));
		setGrafico();
		
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	@Override
	public void mejorar(Personaje personaje) {
		for (Position<Enemigo> en : gui.getListaEnemigos().positions()) {
			en.element().frenar(3000);
		}
			
			}

		
	}
	
