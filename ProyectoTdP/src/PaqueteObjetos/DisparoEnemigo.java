package PaqueteObjetos;

import javax.swing.ImageIcon;

public class DisparoEnemigo extends Disparo {
<<<<<<< HEAD
	
	public DisparoEnemigo(int x, int y) {
		super(x, y);
		grafico.setVisible(true);
		grafico.setSize((int)(Xmax*0.05),(int) (Ymax*0.05));
		grafico.setIcon( new ImageIcon("./bin/ImageIcons/Jugador - Izquierda.png"));
		grafico.setLocation(pos);
	}
	
	public int morir() {
		return 0;
	}
	
	protected void setGrafico() {
		// TODO Auto-generated method stub
		
	}

	public void avanzar() {
		pos.setLocation(pos.x, pos.y +2);
		if(pos.y>Ymax)
			borrable=true;
		grafico.setLocation(pos);
	}

=======
	protected DisparoEnemigo(int x, int y) {
		super(x, y);
	}
	
	//DEBE REDEFINIR A mover().
>>>>>>> 3d9c1112bc17bf89a881453e8bd8f7bd21b7b5ad
}
