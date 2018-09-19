package PaqueteJuego;

import PaqueteEnemigos.*;
import PaqueteObjetosImplementados.*;
import TDAListaDE.Position;

public class Mapa {
	private final int Xmax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int Ymax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private int dificultad;
	private final int maxEnemigos = 20;
	//private final int posXObstaculo1 = 150, posXObstaculo2 = 600, posYObstaculo = 450; (esto se ve vien solo en la de chiara )
	private final int posXObstaculo1 =  (int) (Xmax*0.07), posXObstaculo2 = (int) (Xmax*0.35), posYObstaculo = (int) (Ymax*0.5);
	protected final int posXJugador = (int) (Xmax*0.5), posYJugador = (int) (Ymax*0.73);
	private Terna[][] matrizPosiciones;
	private Juego juego;
	
	/* A LOOK INSIDE MY HEAD:
	 * A ver. Hay una matriz que determina si una posición de las iniciales está o no ocupada, y cuáles son sus valores x,y en el frame.
	 * 
	 * Primero determino la cantidad de cada tipo de enemigo en una forma pseudo-aleatoria, dependiendo de la dificultad con la que se esté tratando.
	 * Después, creo todos los enemigos armados (los fijos y los que pierden el arma) en posiciones aleatorias de esa matriz,
	 * asegurándome de que no se cree más de un enemigo por posición.
	 * Por último, lleno los lugares vacíos con los kamikazes, poniendo primero a los Buscadores, luego a los Mezcla y finalmente a los Aleatorios
	 * para que los buscadores tengan que hacer un mayor recorrido.
	 */
	
	
	private class Terna {
		private boolean ocupado;
		private int posX, posY;
		
		//Constructor:
		public Terna(int x, int y) {
			ocupado = false;
			posX = x;
			posY = y;
		}
		
		
		//Comandos y Consultas:
		public void setOcupado(boolean o) {
			ocupado = o;
		}
		public boolean getOcupado() {
			return ocupado;
		}
		
		public int getPosX() {
			return posX;
		}
		public int getPosY() {
			return posY;
		}
	}
	
	/** Con una dificultad del primer nivel (menor o igual que 1) se crean ciertos enemigos.
	 *  Con una del segundo nivel (mayor o igual que 2) se crean otros enemigos.
	 */
	public Mapa (int dif, Juego ju) {
		dificultad = dif;
		juego = ju;
		matrizPosiciones = new Terna[4][5];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++)
				if (i % 2 == 0)
					matrizPosiciones[i][j] = new Terna(((j + 1) * (int) (Xmax*0.1)) - 40, (i + 1) * (int) (Ymax*0.075));
				else
					matrizPosiciones[i][j] = new Terna(((j + 1) * (int) (Xmax*0.1)) + 0, (i + 1) * (int) (Ymax*0.075));
		}
		crearEnemigos();
		crearBarricadas();
		crearJugador();
	}
	
	private void crearEnemigos() {
		int cantArmados, cantAP, cantKA, cantKB, cantKM, x = 0, y = 0;
		
		if (dificultad < 2) {
			do {
				cantArmados = new java.util.Random().nextInt(15);
			} while (cantArmados < 10); //Habrá entre 10 y 14 enemigos armados.
			
			if (cantArmados == 10)
				cantAP = 3;
			else
				cantAP = (cantArmados == 14) ? 6 : 4;
			
			cantKB = 2;
			
			if (cantArmados < 12) {
				cantKA = 5;
				cantKM = maxEnemigos - (cantArmados + cantKA + cantKB);
			}
			else {
				if (cantArmados < 14) {
					cantKA = 4;
					cantKM = maxEnemigos - (cantArmados + cantKA + cantKB);
				}
				else { //cantArmados == 14
					cantKA = 3;
					cantKM = 1;
				}
			}
			
		}
		else {
			do {
				cantArmados = new java.util.Random().nextInt(12);
			} while (cantArmados < 7); //Habrá entre 7 y 11 enemigos armados.
			
			if (cantArmados == 7)
				cantAP = 3;
			else
				cantAP = (cantArmados == 11) ? 6 : 4;
			
			cantKB = 4;
			
			if (cantArmados < 9) {
				cantKA = 5;
				cantKM = maxEnemigos - (cantArmados + cantKA + cantKB);
			}
			else {
				if (cantArmados < 14) {
					cantKA = 4;
					cantKM = maxEnemigos - (cantArmados + cantKA + cantKB);
				}
				else { //cantArmados == 11
					cantKA = 3;
					cantKM = 2;
				}
			}
		}
		
		for (int i = 0; i < cantArmados - cantAP; i++) {
			do {
				x = new java.util.Random().nextInt(4);
				y = new java.util.Random().nextInt(5);
			} while (matrizPosiciones[x][y].getOcupado()); //Deja de buscar cuando encuentra una posición vacía.
			matrizPosiciones[x][y].setOcupado(true);
			Enemigo enem = new Enemigo(new ITieneArma(), matrizPosiciones[x][y].getPosX(), matrizPosiciones[x][y].getPosY());
			Position<Enemigo> pos = juego.agregarEnemigo(enem);
			enem.setPosEnJuego(pos);
		}
		
		for (int i = 0; i < cantAP; i++) {
			do {
				x = new java.util.Random().nextInt(4);
				y = new java.util.Random().nextInt(5);
			} while (matrizPosiciones[x][y].getOcupado()); //Deja de buscar cuando encuentra una posición vacía.
			matrizPosiciones[x][y].setOcupado(true);
			EnemigoCambia enem = new EnemigoCambia(matrizPosiciones[x][y].getPosX(), matrizPosiciones[x][y].getPosY());
			Position<Enemigo> pos = juego.agregarEnemigo(enem);
			enem.setPosEnJuego(pos);
		} //Dado que a lo sumo habrá 14 enemigos armados, el proceso de búsqueda de una posición no tardará demasiado.
		
		
		int cont = 0; boolean quedan = true;
		for (int i = 0; i < 4 && quedan; i++) { //Crear Kamikazes.
			for (int j = 0; j < 5 && quedan; j++) {
				if (!matrizPosiciones[i][j].getOcupado()) {
					matrizPosiciones[i][j].setOcupado(true); //No es realmente necesario (la posición (i,j) no se evaluará más), pero por una cuestión de prolijidad lo seteo en true.
					cont++;
					
					Enemigo enem;
					
					if (cont <= cantKB)
						enem = new Enemigo(new IKB(), matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
					else {
						if (cont <= cantKB + cantKM)
							enem = new Enemigo(new IKM(), matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
						else
							enem = new Enemigo(new IKA(), matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
					}
					
					Position<Enemigo> pos = juego.agregarEnemigo(enem);
					enem.setPosEnJuego(pos);
					
					if (cont == cantKB + cantKM + cantKA)
						quedan = false;
				}
			}
		}
		
	}
	
	
	private void crearBarricadas() {
		if (dificultad < 2) {
			DestruiblePorTodos dest1 = new DestruiblePorTodos(posXObstaculo1, posYObstaculo);
			DestruiblePorTodos dest2 = new DestruiblePorTodos(posXObstaculo2, posYObstaculo);
			
			juego.agregarObstaculo(0, dest1);
			juego.agregarObstaculo(1, dest2);
		}
		else {
			BarricadaEnemigos barr1 = new BarricadaEnemigos(posXObstaculo1, posYObstaculo);
			BarricadaEnemigos barr2 = new BarricadaEnemigos(posXObstaculo2, posYObstaculo);
			
			juego.agregarObstaculo(0, barr1);
			juego.agregarObstaculo(1, barr2);
		}
	}
	
	private void crearJugador() {
		Jugador jugador = new Jugador(7, posXJugador, posYJugador);
		juego.setJugador(jugador);
	}
}
