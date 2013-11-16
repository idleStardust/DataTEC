package listas;

import abs.IComparable;

/**
 * 	Lista Doblemente Enlazada en la que el Tail apunta al Head.
 * 	@author ArturoMora
 *
 */
public class ListaDobleCircular extends ListaDoble
{
	public ListaDobleCircular()
	{
		super();
		
	}
	
	@Override
	public void addEnd(IComparable pDato)
	{
		super.addEnd(pDato);
		this.funcionCircular();
	}
	
	@Override
	public void removeHead()
	{
		super.removeHead();
		this.funcionCircular();
	}
	@Override
	public void removeTail()
	{
		super.removeTail();
		this.funcionCircular();
	}
	
	/**
	 * Enlaza el Head con el Tail de la Lista Circular en ambos sentidos.
	 */
	private void funcionCircular()
	{
		this._Tail.setNext(this._Head);
		this._Head.setPrev(this._Tail);
	}
}
