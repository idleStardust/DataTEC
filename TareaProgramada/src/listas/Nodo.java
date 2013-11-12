package listas;

import abs.IComparable;

public class Nodo 
{
	protected IComparable _Dato;
	protected Nodo _Hijo;
	
	public Nodo(IComparable pDato)
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
}
