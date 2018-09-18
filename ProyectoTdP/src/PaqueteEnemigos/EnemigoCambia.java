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
	
	public void cambiarInteligencia() { //Lo hago público porque aún no sé cómo vamos a hacer para darnos cuenta cuándo ejecutarlo.
		if (vida < 20)
			intel = new IKA();
	}
}
