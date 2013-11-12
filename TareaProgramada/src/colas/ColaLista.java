package colas;

import abs.IComparable;
import abs.IEncolable;

/**
 * 
 *  FIFO (First In First Out)
 * @author LuisArturo
 *
 */
public class ColaLista implements IEncolable
{
	protected Nodo _Frente;
	protected Nodo _Final;
	
	
	@Override
	public IComparable dequeue() 
	{
		Nodo tmp = this._Frente;
		if(tmp == this._Final)
			this._Final = this._Frente = null;
		else
			this._Frente = tmp.getNext();
		return tmp.getDato();
	}

	@Override
	public boolean colaVacia()
	{
		return this._Frente == null;
	}

	@Override
	public void enqueue(IComparable pElemento)
	{

		Nodo tmp = new Nodo(pElemento);
		if(this.colaVacia())
		{
			this._Final = this._Frente = tmp;
		}
		else
		{
			this._Final.setNext(tmp);
			this._Final = tmp;
		}
	}

	@Override
	public IComparable top() throws Exception 
	{
		if( !this.colaVacia())
			return this._Frente.getDato();
		else
			throw new Exception("Cola vacia");
	}
	
	public void print()
	{
		Nodo tmp = this._Frente;
		System.out.print("] ");
		while(tmp != null)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println("] ");
	}
}