package listas;

import abs.IComparable;

public class NodoLista extends Nodo
{
	protected int _Indice;
	
	NodoLista(IComparable pDato)
	{
		super(pDato);
		this._Hijo = (NodoLista) this._Hijo;
	}
	
	protected void setNext(NodoLista pNodo)
	{
		this._Hijo = pNodo;
	}
	
	protected NodoLista getNext()
	{
		return (NodoLista) this._Hijo;
	}
	
	protected void erase()
	{
		this._Dato = null;
		this._Hijo = null;
	}

	public int getIndice() 
	{
		return this._Indice;
	}

	public void setIndice(int _Indice) 
	{
		this._Indice = _Indice;
	}
}
