package PaqueteEnemigos;

import javax.swing.ImageIcon;

public class EnemigoCambia extends Enemigo {

	public EnemigoCambia(int v,int x, int y) {
		super(new ITieneArma(),v, x, y);
		setGrafico();
	}
	
	//REDEFINIDO:
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/ITAP - Armado.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		grafico.setLocation(pos);
	}
	
	public void cambiarInteligencia() { //Lo hago público porque aún no sé cómo vamos a hacer para darnos cuenta cuándo ejecutarlo.
		if (vida < 20)
			intel = new IKA();
	}
}
