package colas;

import abs.IComparable;

public class BicolaLista extends ColaLista
{

	public BicolaLista()
	{
		super();
	}
	
	public void enqueueStart(IComparable pDato)
	{
		Nodo tmp = new Nodo(pDato);
		if(this.colaVacia())
		{
			this._Final = this._Frente = tmp;
		}
		else
		{
			tmp.setNext(this._Frente);
			this._Frente = tmp;
		}
	}
	
	public void enqueueEnd(IComparable pDato)
	{
		super.enqueue(pDato);
	}
	
	
	public IComparable dequeueStart()
	{
		//TODO
		return null;
	}
	
	public IComparable dequeueEnd()
	{
		return super.dequeue();
	}
}