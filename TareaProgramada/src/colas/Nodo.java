package colas;

import abs.IComparable;

public class Nodo 
{

	IComparable _Dato;
	Nodo _Siguiente;
	
	public Nodo(IComparable pDato) 
	{
		this._Dato = pDato;
		this._Siguiente = null;
	}
	
	public IComparable getDato()
	{
		return this._Dato;
	}
	
	public Nodo getNext()
	{
		return this._Siguiente;
	}
	
	public void setNext(Nodo pNodo)
	{
		this._Siguiente = pNodo;
	}
}