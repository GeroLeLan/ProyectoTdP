package PaqueteDrops;

<<<<<<< HEAD:ProyectoTdP/src/PaqueteObjetos/Congelar.java
import PaqueteEnemigos.Enemigo;
import PaqueteJuego.GUI;
import PaqueteObjetosImplementados.Personaje;
import TDAListaDE.Position;
=======

import PaquetePersonajes.Personaje;
import javax.swing.ImageIcon;
import PaqueteJuego.GUI;
>>>>>>> 1c09ce1f2121ab38be223e0bfdfd160a2389b17e:ProyectoTdP/src/PaqueteDrops/Congelar.java

public class Congelar extends Temporales{
	public Congelar(int x, int y, GUI gui) {
		super(x, y, gui);
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/turtleCongelar.gif"));
	}

	public int morir() {
		grafico.setVisible(false);
		borrable = true;
		return 0;
	}
	
	public void mejorar(Personaje personaje) {
<<<<<<< HEAD:ProyectoTdP/src/PaqueteObjetos/Congelar.java
		for (Position<Enemigo> en : gui.getListaEnemigos().positions()) {
			en.element().frenar(3000);
		}
			
			}

		
=======
			gui.getTiempo().wait(3000);
	}

	public Drop clone() {
		return new Congelar(pos.x, pos.y, gui);
>>>>>>> 1c09ce1f2121ab38be223e0bfdfd160a2389b17e:ProyectoTdP/src/PaqueteDrops/Congelar.java
	}
	
