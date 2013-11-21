package colas;

import abs.IComparable;

public class NodoColaPrioridad
{
	IComparable _Dato;
	NodoColaPrioridad _Next;
	int _Prioridad;
	
	public NodoColaPrioridad(IComparable pDato, int pPrioridad) 
	{
		this._Dato = pDato;
		this._Next = null;
		this._Prioridad = pPrioridad;
	}
	
	public NodoColaPrioridad(IComparable pDato) 
	{
		this(pDato, (int) (Math.random()*6 + 1));
	}
	
	public IComparable getDato()
	{
		return this._Dato;
	}
	
	public NodoColaPrioridad getNext()
	{
		return this._Next;
	}
	
	public void setNext(NodoColaPrioridad pNodo)
	{
		this._Next = pNodo;
	}
	
	public int getPrioridad()
	{
		return this._Prioridad;
	}
	
	public void setPrioridad(int pIndex)
	{
		this._Prioridad = pIndex;
	}
}
