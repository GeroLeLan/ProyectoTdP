package PaqueteJuego;

import PaqueteEnemigos.*;
import PaqueteObjetosImplementados.*;
import TDAListaDE.Position;

public class Mapa {
	private final int Xmax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private final int Ymax =java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	private int dificultad;
	private final int maxEnemigos = 20;
	private final int posXObstaculo1 =  (int) (Xmax*0.08), posXObstaculo2 = (int) (Xmax*0.256), posXObstaculo3 = (int) (Xmax*0.43), posYObstaculo = (int) (Ymax*0.5);
	protected final int posXJugador = (int) (Xmax*0.275), posYJugador = (int) (Ymax*0.73);
	private Terna[][] matrizPosiciones;
	private Juego juego;
	private final int vel=5; 
	
	/* A LOOK INSIDE MY HEAD:
	 * A ver. Hay una matriz que determina si una posici�n de las iniciales est� o no ocupada, y cu�les son sus valores x,y en el frame.
	 * 
	 * Primero determino la cantidad de cada tipo de enemigo en una forma pseudo-aleatoria, dependiendo de la dificultad con la que se est� tratando.
	 * Despu�s, creo todos los enemigos armados (los fijos y los que pierden el arma) en posiciones aleatorias de esa matriz,
	 * asegur�ndome de que no se cree m�s de un enemigo por posici�n.
	 * Por �ltimo, lleno los lugares vac�os con los kamikazes, poniendo primero a los Buscadores, luego a los Mezcla y finalmente a los Aleatorios
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
		int x, y;
		matrizPosiciones = new Terna[4][5];
		for (int i = 0; i < 4; i++) {
			y = (i + 1) * (int) (Ymax*0.07);
			for (int j = 0; j < 5; j++) {
				x = ((j + 1) * (int) (Xmax*0.095));
				if (i % 2 == 0)
					matrizPosiciones[i][j] = new Terna(x - 40, y);
				else
					matrizPosiciones[i][j] = new Terna(x, y);
			}
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
			} while (cantArmados < 10); //Habr� entre 10 y 14 enemigos armados.
			
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
			} while (cantArmados < 7); //Habr� entre 7 y 11 enemigos armados.
			
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
			} while (matrizPosiciones[x][y].getOcupado()); //Deja de buscar cuando encuentra una posici�n vac�a.
			matrizPosiciones[x][y].setOcupado(true);
			Enemigo enem = new Enemigo(new ITieneArma(),vel, matrizPosiciones[x][y].getPosX(), matrizPosiciones[x][y].getPosY());
			Position<Enemigo> pos = juego.agregarEnemigo(enem);
			enem.setPosEnListaJuego(pos);
		}
		
		for (int i = 0; i < cantAP; i++) {
			do {
				x = new java.util.Random().nextInt(4);
				y = new java.util.Random().nextInt(5);
			} while (matrizPosiciones[x][y].getOcupado()); //Deja de buscar cuando encuentra una posici�n vac�a.
			matrizPosiciones[x][y].setOcupado(true);
			EnemigoCambia enem = new EnemigoCambia(vel, matrizPosiciones[x][y].getPosX(), matrizPosiciones[x][y].getPosY());
			Position<Enemigo> pos = juego.agregarEnemigo(enem);
			enem.setPosEnListaJuego(pos);
		} //Dado que a lo sumo habr� 14 enemigos armados, el proceso de b�squeda de una posici�n no tardar� demasiado.
		
		
		int cont = 0; boolean quedan = true;
		for (int i = 0; i < 4 && quedan; i++) { //Crear Kamikazes.
			for (int j = 0; j < 5 && quedan; j++) {
				if (!matrizPosiciones[i][j].getOcupado()) {
					matrizPosiciones[i][j].setOcupado(true); //No es realmente necesario (la posici�n (i,j) no se evaluar� m�s), pero por una cuesti�n de prolijidad lo seteo en true.
					cont++;
					
					Enemigo enem;
					
					if (cont <= cantKB)
						enem = new Enemigo(new IKB(),vel, matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
					else {
						if (cont <= cantKB + cantKM)
							enem = new Enemigo(new IKM(),vel, matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
						else
							enem = new Enemigo(new IKA(),vel, matrizPosiciones[i][j].getPosX(), matrizPosiciones[i][j].getPosY());
					}
					
					Position<Enemigo> pos = juego.agregarEnemigo(enem);
					enem.setPosEnListaJuego(pos);
					
					if (cont == cantKB + cantKM + cantKA)
						quedan = false;
				}
			}
		}
		
	}
	
	
	private void crearBarricadas() {
		if (dificultad < 2) {
			DestruiblePorTodos dest1 = new DestruiblePorTodos(posXObstaculo1, posYObstaculo);
			BarricadaEnemigos barr2 = new BarricadaEnemigos(posXObstaculo2, posYObstaculo);
			DestruiblePorTodos dest3 = new DestruiblePorTodos(posXObstaculo3, posYObstaculo);
			
			juego.agregarObstaculo(0, dest1);
			juego.agregarObstaculo(1, barr2);
			juego.agregarObstaculo(2, dest3);
		}
		else {
			BarricadaEnemigos barr1 = new BarricadaEnemigos(posXObstaculo1, posYObstaculo);
			BarricadaEnemigos barr2 = new BarricadaEnemigos(posXObstaculo2, posYObstaculo);
			BarricadaEnemigos barr3 = new BarricadaEnemigos(posXObstaculo3, posYObstaculo);
			
			juego.agregarObstaculo(0, barr1);
			juego.agregarObstaculo(1, barr2);
			juego.agregarObstaculo(2, barr3);
		}
	}
	
	private void crearJugador() {
		Jugador jugador = new Jugador(7, posXJugador, posYJugador);
		juego.setJugador(jugador);
	}
}
