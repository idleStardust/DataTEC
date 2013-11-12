package listas;

import abs.IComparable;

public class NodoDoble
{
	protected NodoDoble _Prev;
	protected NodoDoble _Next;
	protected IComparable _Dato;
	
	NodoDoble(IComparable pDato) 
	{
		this._Dato = pDato;
		this._Next = null;
		this._Prev = null;
	}

	
	public NodoDoble getPrev() 
	{
		return _Prev;
	}

	
	public void setPrev(NodoDoble pPrev) 
	{
		this._Prev = pPrev;
	}

	
	public NodoDoble getNext() 
	{
		return _Next;
	}

	
	public void setNext(NodoDoble pNext) 
	{
		this._Next = pNext;
	}

	
	public IComparable getDato() 
	{
		
		return _Dato;
	}

	
	public void setDato(IComparable pDato) 
	{
		this._Dato = pDato;
	}
	
	public void destroy()
	{
		this._Dato = null;
		this._Next = null;
		this._Prev = null;
	}
}
