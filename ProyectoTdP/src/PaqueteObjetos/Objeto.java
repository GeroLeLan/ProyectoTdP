package PaqueteObjetos;

public abstract class Objeto {
	protected int vida;
	protected int x;
	protected int y;
	public abstract void morir();
	public abstract void colisionar();
}
