package PaqueteObjetos;

public abstract class Animado extends Objeto{
	protected int fuerzaK;//es el daño que produce al chocar con algo (yo propongo cambiarlo a fuerzaI o fuerza solo (gero))
	protected abstract void movimiento () ;//no se si deberia ser protected 
}
