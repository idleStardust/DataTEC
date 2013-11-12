package listas;

import types.Integer2;
import abs.IColeccionista;
import abs.IComparable;

public class Lista implements IColeccionista
{
	protected Nodo _Head;
	protected Nodo _Tail;
	protected int _Largo;
	
	public static void main(String[] args) 
	{
		
		
	}
	public Lista()
	{
		this._Head = null;
		this._Tail = null;
		this._Largo = 0;
	}
	
	
	@Override
	public void remove(IColeccionable pDato) 
	{
		
	}
	
	@Override
	public void add(IComparable pDato) 
	{
		
	}
	
	
	
	public void addStart(IComparable pDato)
	{
		if(this._Largo == 0)
			this.addFirst(pDato);
		else
		{
			Nodo tmp = new Nodo(pDato);
			tmp.setIndice(this._Largo);
			tmp.setNext(this._Head);
			this._Head = tmp;
			this._Largo ++;
		}
	}
	
	protected void addFirst(IComparable pDato)
	{
		Nodo tmp = new Nodo(pDato);
		tmp.setIndice(this._Largo);
		this._Head = tmp;
		this._Largo ++;
	}
	
	public void addEnd(IComparable pDato)
	{
		if(this._Largo == 0)
			this.addFirst(pDato);
		Nodo tmp = new Nodo(pDato);
		tmp.setIndice(this._Largo);
		this._Tail.setNext(tmp);
		this._Tail = tmp;
		this._Largo ++;
	}
	
	public IComparable search(int pIndice)
	{
		return this.searchNodo(pIndice).getDato();
	}
	
	}
	
	protected void removeEnd() 
	{
		Nodo tmp = this.searchNodo(this._Largo - 2);
		Nodo erased = tmp.getNext();
		erased.erase();
		tmp.setNext(null);
		this._Largo --;
	}
	
	protected void removeStart()
	{
		Nodo tmp = this._Head;
		this._Head = tmp.getNext();
		tmp.erase();
		this._Largo --;
	}
	
	
	/**
	 * Busca y retorna un Nodo a partir de un indice.
	 * @param pIndice {@link Integer2}
	 * @return {@link Nodo}
	 */
	protected Nodo searchNodo(int pIndice)
	{
		Nodo result = null;
		Nodo tmp = this._Head;
		for(int i = 0; i < this._Largo; i++)
		{
			if( i == pIndice)
			{
				result = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		return result;
	}
	
	/**
	 * Busca un nodo de la lista a partir de un dato.
	 * @param pComparable {@link IColeccionable}
	 * @return {@link Nodo}
	 */
	protected Nodo searchNodo(IComparable pComparable)
	{
		Nodo result = null;
		Nodo tmp = this._Head;
		for(int i = 0; i < this._Largo; i++)
		{
			if( tmp.getDato().equals(pComparable))
			{
				result = tmp;
				break;
			}
			tmp = tmp.getNext();
		}
		return result;
	}
	
	@Override
	public void print()
	{
		System.out.print("[ ");
		Nodo tmp = this._Head;
		for(int x = 0; x < this._Largo; x++)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println("]");
	}
	@Override
	public void remove(IComparable pDato) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int search(IComparable pDato) {
		// TODO Auto-generated method stub
		return 0;
	}
}
