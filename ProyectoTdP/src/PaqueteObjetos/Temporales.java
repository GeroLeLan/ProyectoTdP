package PaqueteObjetos;

public abstract class Temporales extends Drop {
	protected Temporales(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int tiempo;
	public int morir() {
		//Creo que podriamos redefinir morir aca y poner que mueren cuando el tiempo se hace 0.
		return 0;
	}
}
