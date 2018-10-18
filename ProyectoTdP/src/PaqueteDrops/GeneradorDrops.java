package PaqueteDrops;

import java.util.Random;

import PaqueteJuego.GUI;

public class GeneradorDrops {
	Drop muchos, varios, algunos, limitados, escasos, pocos;
	
	public GeneradorDrops(int x, int y, GUI gui) {
		muchos = new SuperMisil(x, y, gui);
		varios = new SubirVida(x, y, gui);
		algunos = new Congelar(x, y, gui);
		limitados = new Escudo(x, y, gui);
		escasos = new MejoraDisparoDoble(x, y, gui);
		pocos = new MejoraDaño(x, y, gui);
	}
	
	public Drop generarDrop() {
		Random r = new Random();
		int eleccion = r.nextInt(105);
		Drop clon;
		
		if (eleccion < 5)
			clon = pocos.clone();
		else {
			if (eleccion < 15)
				clon = escasos.clone();
			else {
				if (eleccion < 30)
					clon = limitados.clone();
				else {
					if (eleccion < 50)
						clon = algunos.clone();
					else {
						if (eleccion < 75)
							clon = varios.clone();
						else
							clon = muchos.clone();
					}
				}
			}
		}
		
		return clon;
	}
}
