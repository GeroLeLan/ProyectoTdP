package PaqueteEnemigos;

import javax.swing.ImageIcon;

import PaqueteObjetosImplementados.Animado;
import TDAListaDE.Position;

public class Enemigo extends Animado {
	protected Inteligencia intel;
	protected Position<Enemigo> posEnListaJuego; //Guarda su posición en la lista de enemigos del juego.
	
	public Enemigo (Inteligencia i, int velocidad, int x, int y) {
		super(velocidad, x, y);
		intel = i;
		setGrafico();
	}
	
	public void setPosEnListaJuego(Position<Enemigo> posJ) {
		posEnListaJuego = posJ;
	}
	
	protected void setGrafico() {
		grafico.setSize((int)(Xmax*0.05),(int)(Ymax*0.1));
		grafico.setIcon(new ImageIcon(escalarGrafico(intel.getIcono())));
		grafico.setLocation(pos);
	}
	
	

	protected int morir() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/Animación - Muerte de Enemigo.gif");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
		return intel.getPuntosKill();
	}

	@Override
	public void colisionar() {
		// TODO Auto-generated method stub
		
		
			//DARLE LA POSIBILIDAD AL PROCESADOR DE HACER MAS DE UNA COSA AL MISMO TIEMPO: PROCESOS CONCURRENTES.
			//PARALELISMO: EJECUCION SIMULTANEA DE VARIOS PROCESADORES.
	}
	
	public void mover(int dir){
		switch (dir) {
			case 1:
				pos.setLocation(pos.x, pos.y + velocidad);
				if (pos.y > Ymax * 0.9)
					pos.y = 0;
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
	}

	
		
}

	

	

	
	
	

