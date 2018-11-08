package PaqueteEnemigos;

public class MementoInteligencia {
	Inteligencia intel;
	public MementoInteligencia(Inteligencia in) {
		intel = in;
	}
	public Inteligencia getIntel() {
		return intel;
	}
}
