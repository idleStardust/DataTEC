package colas;

import abs.IComparable;
import abs.IEncolable;

/**
 * 
 *  LIFO (Last In First Out)
 * @author ArturoMora
 *
 */
public class ColaLista implements IEncolable
{
	/**
	 * Nodo frontal de la cola.
	 */
	protected NodoCola _Frente;
	
	/**
	 * Nodo Final de la cola.
	 */
	protected NodoCola _Final;
	
	
	@Override
	public IComparable dequeue() throws Exception 
	{
		NodoCola tmp = this._Frente;
		if(this.isEmpty())
			throw new Exception("Cola vacia");
		
		else if(tmp == this._Final)
			this._Final = this._Frente = null;
		
		else
			this._Frente = tmp.getNext();
		
		return tmp.getDato();
	}

	@Override
	public boolean isEmpty()
	{
		return this._Frente == null;
	}

	@Override
	public void enqueue(IComparable pElemento)
	{

		NodoCola tmp = new NodoCola(pElemento);
		if(this.isEmpty())
		{
			this._Final = this._Frente = tmp;
		}
		else
		{
			this._Final.setNext(tmp);
			this._Final = tmp;
		}
	}
	
	public void print()
	{
		NodoCola tmp = this._Frente;
		System.out.print("Cola: } ");
		while(tmp != null)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println("} ");
	}
}