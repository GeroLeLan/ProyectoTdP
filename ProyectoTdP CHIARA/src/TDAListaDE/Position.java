package TDAListaDE;

public interface Position<E> {
	// Retorna el valor del elemento ubicado en la posición. Lanza una excepción si la posición corresponde a un nodo dummy.
	public E element();
}
