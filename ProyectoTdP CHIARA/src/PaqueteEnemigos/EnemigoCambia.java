package PaqueteEnemigos;

import javax.swing.ImageIcon;

public class EnemigoCambia extends Enemigo {

	public EnemigoCambia(int x, int y) {
		super(new ITieneArma(), x, y);
		setGrafico();
	}
	
	//REDEFINIDO:
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("C:\\Users\\nacho\\Documents\\Nacho - Universidad\\Nacho - Universidad 2018\\Segundo Cuatrimestre\\Tecnolog�a de Programaci�n\\Proyecto\\ProyectoTdP - Chiaravalle, Schimpfle y Le Lan Toussaint\\ProyectoTdP\\src\\ImageIcons\\ITAP.png"));
	}
	
	public void cambiarInteligencia() { //Lo hago p�blico porque a�n no s� c�mo vamos a hacer para darnos cuenta cu�ndo ejecutarlo.
		if (vida < 20)
			intel = new IKA();
	}
}
