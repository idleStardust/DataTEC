package listas;

import abs.IComparable;

public class Nodo 
{
	protected IComparable _Dato;
	protected Nodo _Next;
	
	protected Nodo(IComparable pDato)
	{
		this._Dato = pDato;
	}
	
	protected IComparable getDato()
	{
		return this._Dato;
	}
	
	protected void setDato(IComparable pDato)
	{
		this._Dato = pDato;
	}
	
	protected void print()
	{
		this._Dato.print();
	}
	
	/**
	 * Obtiene el NodoDoble Posterior al NodoDoble.
	 * @return {@link IComparable}
	 */
	protected Nodo getNext() 
	{
		return this._Next;
	}

	/**
	 * Establece un nuevo NodoDoble posterior.
	 * @param pNext {@link NodoDoble}
	 */
	protected void setNext(Nodo pNext) 
	{
		this._Next = pNext;
	}
}
