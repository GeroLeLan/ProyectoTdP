package PaqueteEnemigos;

public class Memento {
	Inteligencia intel;
	Enemigo enem;
	public Memento(Inteligencia in) {
		intel=in;
	}
	public Inteligencia getIntel() {
		return intel;
	}
}
