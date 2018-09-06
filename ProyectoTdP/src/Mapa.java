
public abstract class Mapa {
	Objeto [][] Matriz;
	public Mapa(int alto ,int largo) {
		Matriz=new Objeto[alto][largo];
	}
	public abstract Enemigo[] crearEnemigos();
}
