package abs;

public interface IEncolable
{
	/**
	 * Verifica si la cola tiene elementos.
	 * @return {@link Boolean}
	 */
	public boolean colaVacia();
	
	/**
	 * Elimina el elemento que está al frente de la cola  y lo retorna. 
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
	 * Retorna el frente de la cola.
	 * @return {@link IComparable
	 * @throws Exception
	 */
	public IComparable top() throws Exception;
}