package PaqueteEnemigos;

import javax.swing.ImageIcon;

public class EnemigoCambia extends Enemigo {
	private boolean cambiado;
	//private int imagenActual;
	
	public EnemigoCambia(int x, int y) {
		super(new ITieneArma(), x, y);
		setGrafico("./bin/ImageIcons/ITAP - Armado.png");
		grafico.setLocation(pos);
		cambiado = false;
	}
	
	//REDEFINIDOS:
	protected void setGrafico(String ruta) {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		ImageIcon iconoOriginal = new ImageIcon(ruta);
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}
	
	public int recibirDaño(int d) {
		vida -= d;
		if (!cambiado && vida <= vidaInicial * 0.2) {
			cambiarInteligencia();
			cambiado = true;
			//imagenActual = 1;
		}
		
		if(vida <= 0)
			return morir();
		return 0;
	}
	
		private void cambiarInteligencia() { //Lo hago público porque aún no sé cómo vamos a hacer para darnos cuenta cuándo ejecutarlo.
			intel = new IKA();
			setGrafico("./bin/ImageIcons/ITAP - Desarmado 1.png");
			moviendo = true;
		}
	
	/*public void mover(int dir) {
		intel.mover(dir, pos);
		switch (dir) {
			case 1:
				pos.setLocation(pos.x, pos.y + velocidad);
				if (pos.y > Ymax * 0.9)
					pos.y = 0;
				
				if (cambiado) { //Debería cambiarlo por un arreglo de imágenes, y tener más imágenes para el movimiento.
					if (imagenActual == 1) {
						setGrafico("./bin/ImageIcons/ITAP - Desarmado 2.png");
						imagenActual = 2;
					}
					else {
						setGrafico("./bin/ImageIcons/ITAP - Desarmado 1.png");
						imagenActual = 1;
					}
				}
				
				break;
			case 2:
				pos.setLocation(pos.x - velocidad, pos.y);
				if (pos.x < 0)
					pos.x = (int) (Xmax * 0.6);
				break;
			case 3:
				pos.setLocation(pos.x + velocidad, pos.y);
				if (pos.x > Xmax * 0.585)
					pos.x = (int) (Xmax * 0.01);
				break;
		}
		grafico.setLocation(pos);
	}*/
}
