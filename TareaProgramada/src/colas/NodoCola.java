package colas;

import abs.IComparable;

public class NodoCola 
{

	IComparable _Dato;
	NodoCola _Siguiente;
	
	public NodoCola(IComparable pDato) 
	{
		this._Dato = pDato;
		this._Siguiente = null;
	}
	
	public IComparable getDato()
	{
		return this._Dato;
	}
	
	public NodoCola getNext()
	{
		return this._Siguiente;
	}
	
	public void setNext(NodoCola pNodo)
	{
		this._Siguiente = pNodo;
	}
}