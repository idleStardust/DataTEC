package abs;

public interface IColeccion
{	
	/**
	 * Retorna el valor de verdad sobre si una coleccion no tiene elementos.
	 * @return {@link Boolean}
	 */
	public boolean isEmpty();
	
	
	/**
	 * Eliminar un objeto de la estructura de datos.
	 * @param pDato {@link IComparable}
	 */
	public void remove(IComparable pDato);
	
	
	/**
	 * Agregar un objecto a la estructura de datos.
	 * @param pDato {@link IComparable}
	 */
	public void add(IComparable pDato);
	
	/*
	/**
	 * Busca un objecto en la estructura de datos.
	 * @param pDato {@link IComparable}
	 * 
	public int search(IComparable pDato);
	*/
	
	/** 
	 * Imprime los elementos de la estructura de datos.
	 */
	public void print();
}