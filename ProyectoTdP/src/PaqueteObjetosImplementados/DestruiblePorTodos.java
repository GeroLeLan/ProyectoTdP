package PaqueteObjetosImplementados;

import javax.swing.ImageIcon;

<<<<<<< HEAD
import PaqueteObjetos.Disparo;
=======
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
import PaqueteObjetos.DisparoEnemigo;

public class DestruiblePorTodos extends Obstaculo {

	public DestruiblePorTodos(int x, int y) {
		super(x, y);
		setGrafico();
		puntosKill = 40;
	}
	
	protected void setGrafico() {
		ImageIcon iconoOriginal = new ImageIcon("./bin/ImageIcons/DESTRUIBLE.png");
		ImageIcon iconoEscala = new ImageIcon(escalarGrafico(iconoOriginal));
		grafico.setIcon(iconoEscala);
	}
<<<<<<< HEAD

	public int recibirDaño(int d, Disparo disp) {
		vida -= d;
		if (vida <= 0)
			return morir();
		return 0;
	}
	
	public int recibirDisparo(DisparoEnemigo dispEnem) {
		vida -= dispEnem.getDaño();
		if (vida <= 0)
			return morir();
=======
	
	public int recibirDisparo(DisparoEnemigo dispEnem) {
		dispEnem.morir();
		vida -= dispEnem.getDaño();
		if (vida <= 0)
			morir(); //Si un enemigo destruye al Obstáculo, no se suman puntos.
>>>>>>> dd3bba543e7ea215949fc855fc96016e284f2929
		return 0;
	}
	
}
