package abs;

public interface IEncolable
{
	/**
	 * Verifica si la cola tiene elementos.
	 * @return {@link Boolean}
	 */
	public boolean isEmpty();
	
	/**
	 * Elimina el elemento que est� al frente de la cola  y lo retorna. 
	 * @return {@link IComparable}
	 * @throws Exception
	 */
	public IComparable dequeue() throws Exception;
	
	/**
	 * 
	 * @param pElemento
	 * @throws Exception
	 */
	public void enqueue(IComparable pElemento) throws Exception;
	
	
	/**
	 * Imprime en consola todos los elementos en la cola.
	 */
	public void print();
}