package pilas;

import abs.IComparable;

public class NodoPila 
{

	IComparable _Dato;
	NodoPila _Siguiente;
	
	public NodoPila(IComparable pDato) 
	{
		this._Dato = pDato;
		this._Siguiente = null;
	}
	
	public IComparable getDato()
	{
		return this._Dato;
	}
	
	public NodoPila getNext()
	{
		return this._Siguiente;
	}
	
	public void setNext(NodoPila pNodo)
	{
		this._Siguiente = pNodo;
	}
}