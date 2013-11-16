package listas;

import abs.IComparable;

/**
 * Un NodoDoble es una abstraccion que contiene un dato y referencias hacias otros nodos
 * que por definicion tambien contienen datos.
 * @author ArturoMora
 *
 */
public class NodoDoble
{
	/**
	 * Nodo previo al Nodo.
	 */
	protected NodoDoble _Prev;
	
	/**
	 * Nodo posterior al Nodo.
	 */
	protected NodoDoble _Next;
	
	/**
	 * Dato que almacena el Nodo.
	 */
	protected IComparable _Dato;
	
	/**
	 * Establece un dato para el Nodo y las referencias a otros nodos como nulas.
	 * @param pDato
	 */
	protected NodoDoble(IComparable pDato) 
	{
		this._Dato = pDato;
		this._Next = null;
		this._Prev = null;
	}

	/**
	 * Obtiene el NodoDoble Previo.
	 * @return {@link NodoDoble}
	 */
	public NodoDoble getPrev() 
	{
		return _Prev;
	}

	
	/**
	 * Establece un nuevo NodoDoble Previo.
	 * @param pPrev {@link NodoDoble}
	 */
	public void setPrev(NodoDoble pPrev) 
	{
		this._Prev = pPrev;
	}
	
	/**
	 * Obtiene el NodoDoble Posterior al NodoDoble.
	 * @return {@link IComparable}
	 */
	public NodoDoble getNext() 
	{
		return this._Next;
	}

	/**
	 * Establece un nuevo NodoDoble posterior.
	 * @param pNext {@link NodoDoble}
	 */
	public void setNext(NodoDoble pNext) 
	{
		this._Next = pNext;
	}

	/**
	 * Obtiene la referencia al Dato contenido.
	 * @return {@link IComparable}
	 */
	public IComparable getDato() 
	{
		
		return _Dato;
	}

	/**
	 * Establece un nuevo dato que contendra el NodoDoble.
	 * @param pDato {@link IComparable}
	 */
	public void setDato(IComparable pDato) 
	{
		this._Dato = pDato;
	}
	
	/**
	 * Destruye las referencias del NodoDoble.
	 */
	public void destroy()
	{
		this._Dato = null;
		this._Next = null;
		this._Prev = null;
	}
	
	/**
	 * Muestra en consola la informacion que almacena el NodoDoble.
	 */
	public void print()
	{
		this._Dato.print();
	}
}
