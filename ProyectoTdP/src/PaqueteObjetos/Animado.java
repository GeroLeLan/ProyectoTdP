package PaqueteObjetos;

import PaqueteObjetosImplementados.Objeto;

public abstract class Animado extends Objeto{
	protected Animado(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	protected int fuerzaK;//es el daño que produce al chocar con algo (yo propongo cambiarlo a fuerzaI o fuerza solo (gero))
	protected abstract void movimiento () ;//no se si deberia ser protected 
}
