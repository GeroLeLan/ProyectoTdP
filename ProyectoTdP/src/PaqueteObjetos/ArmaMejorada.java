package PaqueteObjetos;

public class ArmaMejorada extends Arma {

	public ArmaMejorada() {
		super();
		da�o=100;
	}

	@Override

	public Disparo disparar(int x,int y) {
		System.out.println("hola disparo mejorado disparar");
		return new DisparoPersonaje(x,y, da�o);
		 
	}
}
