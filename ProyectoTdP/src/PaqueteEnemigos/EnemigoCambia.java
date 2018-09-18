package PaqueteEnemigos;

import javax.swing.ImageIcon;

public class EnemigoCambia extends Enemigo {

	public EnemigoCambia(int x, int y) {
		super(new ITieneArma(), x, y);
		setGrafico();
	}
	
	//REDEFINIDO:
	protected void setGrafico() {
		grafico.setIcon(new ImageIcon("./bin/ImageIcons/ITAP - Armado.png"));
		grafico.setSize(75, 75);
		grafico.setLocation(pos);
	}
	
	public void cambiarInteligencia() { //Lo hago p�blico porque a�n no s� c�mo vamos a hacer para darnos cuenta cu�ndo ejecutarlo.
		if (vida < 20)
			intel = new IKA();
	}
}
