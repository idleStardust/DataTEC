package listas;

import abs.IColeccion;
import abs.IComparable;

public class ListaDoble implements IColeccion
{
	protected int _Largo;
	protected NodoDoble _Head;
	protected NodoDoble _Tail;
	
	public ListaDoble()
	{
		this._Head =  null;
		this._Tail = null;
		this._Largo = 0;
	}
	
	@Override
	public boolean isEmpty()
	{
		return this._Largo == 0;
	}

	@Override
	public void remove(IComparable pDato)
	{
		NodoDoble tmp = this._Head;
		for(int x = 0; x < this._Largo; x++)
		{
			if( tmp.getDato().igual(pDato) )
			{
				if(this._Largo == 1)
					this.removeLast();
				else if( x == 0)
					this.removeHead();
				else if( x == this._Largo - 1)
					this.removeTail();
				else
				{
					tmp.getNext().setPrev(tmp.getPrev());
					tmp.getPrev().setNext(tmp.getNext());
					tmp.destroy();
				}
				break;
			}
			tmp = tmp.getNext();
		}
	}
	
	public void remove(int pIndice) throws ExcepcionIndice
	{
		if(pIndice >= 0 && pIndice < this._Largo)
		{
			if(this._Largo == 1)
				this.removeLast();
			else if(pIndice == 0)
				this.removeHead();
			else if(pIndice == this._Largo - 1 )
				this.removeTail();
			else
			{
				NodoDoble tmp = this._Head.getNext();
				for(int x = 1; x < pIndice; x ++ )
					tmp = tmp.getNext();
				
				tmp.getPrev().setNext(tmp.getNext());
				tmp.getNext().setPrev(tmp.getPrev());
				tmp.destroy();
				this._Largo --;
			}
		}
		else
			throw new ExcepcionIndice();
	}
	
	private void removeLast()
	{
		this._Head.destroy();
		this._Head = this._Tail = null;
		this._Largo --;
	}
	
	private void removeTail()
	{
		NodoDoble tmp = this._Tail;
		tmp.getPrev().setNext(null);
		this._Tail = tmp.getPrev();
		tmp.destroy();
		this._Largo --;
	}
	
	private void removeHead()
	{
		NodoDoble tmp = this._Head;
		tmp.getNext().setPrev(null);
		this._Head = tmp.getNext();
		tmp.destroy();
		this._Largo --;
	}
	@Override
	public void add(IComparable pDato)
	{
		if( this.isEmpty() )
			this.addFirst(pDato);
		else
			this.addEnd(pDato);
	}
	
	/**
	 * 
	 * @param pDato
	 * @param pIndice
	 * @throws Exception
	 */
	public void add(IComparable pDato, int pIndice)	 throws ExcepcionIndice
	{
		if(pIndice > 0 && pIndice < this._Largo )
		{
			if(pIndice == 0)
				this.addStart(pDato);
			
			else if(pIndice == this._Largo - 1)
				this.addEnd(pDato);
			
			else
			{
				NodoDoble tmp = this._Head.getNext();
				NodoDoble nuevo = new NodoDoble(pDato);
				for(int x = 1; x != pIndice; x++)
					tmp = tmp.getNext();
				nuevo.setNext(tmp.getNext());
				tmp.getNext().setPrev(nuevo);
				
				nuevo.setPrev(tmp);
				tmp.setNext(nuevo);
				
				this._Largo ++;
			}
		}
		
		else
			throw new ExcepcionIndice();
	}
	
	private void addEnd(IComparable pDato)
	{
		NodoDoble tmp = new NodoDoble(pDato);
		this._Tail.setNext(tmp);
		tmp.setPrev(this._Tail);
		this._Tail = tmp;
		this._Largo ++;
	}
	
	public void addStart(IComparable pDato)
	{
		if( this.isEmpty() )
			this.addFirst(pDato);
		else
		{
			NodoDoble tmp = new NodoDoble(pDato);
			this._Head.setNext(tmp);
			tmp.setPrev(this._Head);
			this._Head = tmp;
			this._Largo ++;
		}
	}
	
	private void addFirst(IComparable pDato)
	{
		this._Head = this._Tail = new NodoDoble(pDato);
		this._Largo ++;
	}
	
	@Override
	public void print()
	{
		NodoDoble tmp = this._Head;
		System.out.print("[ ");
		while(tmp != null)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println(" ]");
	}
	
	public int size()
	{
		return this._Largo;
	}
	
	public boolean pertenece(IComparable pDato)
	{
		NodoDoble tmp = this._Head;
		boolean result = false;
		for(int x = 0; x < this._Largo; x++)
		{
			if(tmp.getDato().igual(pDato))
			{
				result = true;
				break;
			}
			tmp = tmp.getNext();
		}
		return result;
	}
}