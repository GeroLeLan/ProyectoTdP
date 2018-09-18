package PaqueteObjetos;

public abstract class Temporales extends Drop {
	protected Temporales(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int tiempo;
	public void morir() {
		//creo que podriamos redefinir morir aca y poner que mueren cuando el tiempo se hace 0
	}
}
