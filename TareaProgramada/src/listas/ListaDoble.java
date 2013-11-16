package listas;

import abs.IComparable;
/**
 * 		Un tipo de lista enlazada más sofisticado es la lista doblemente enlazada
 *  o lista enlazadas de dos vías. Cada nodo tiene dos enlaces: uno apunta al
 *  nodo anterior, o apunta al valor NULL si es el primer nodo; y otro que 
 *  apunta al nodo siguiente, o apunta al valor NULL si es el último nodo.
 * 	@author ArturoMora
 *
 */
public class ListaDoble
{
	/**
	 * Cantidad de nodos de la lista.
	 */
	protected int _Largo;
	
	/**
	 * Nodo cabezera de la lista.
	 */
	protected NodoDoble _Head;
	
	/**
	 * Nodo cola de la lista.
	 */
	protected NodoDoble _Tail;
	
	/**
	 * Inicializa la cabeza y la cola de la lista como nulos.
	 */
	public ListaDoble()
	{
		this._Head =  null;
		this._Tail = null;
		this._Largo = 0;
	}
	
	
	/**
	 * Retorna el valor de verdad sobre si la lista esta vacia.
	 * @return {@link Boolean}
	 */
	public boolean isEmpty()
	{
		return this._Largo == 0;
	}

	/**
	 * Elimina a partir de un dato un nodo de la lista.
	 * @throws ExcepcionIndice 
	 */
	
	public void remove(IComparable pDato) throws ExcepcionIndice
	{
		NodoDoble tmp = this._Head;
		for(int x = 0; x < this._Largo; x++)
		{
			if( tmp.getDato().igual(pDato) )
			{
				this.remove(x);
				break;
			}
			//Iterar el siguiente elemento
			tmp = tmp.getNext();
		}
	}
	
	//Eliminar un elemento a traves de un indice
	public void remove(int pIndice) throws ExcepcionIndice
	{
		//Verificacion del indice
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
	
	protected void removeLast()
	{
		this._Head.destroy();
		this._Head = this._Tail = null;
		this._Largo --;
	}
	
	/**
	 * Remueve el Nodo Tail de la lista.
	 */
	protected void removeTail()
	{
		NodoDoble tmp = this._Tail;
		tmp.getPrev().setNext(null);
		this._Tail = tmp.getPrev();
		tmp.destroy();
		this._Largo --;
	}
	
	/**
	 * Elimina el head de la lista.
	 */
	protected void removeHead()
	{
		NodoDoble tmp = this._Head;
		tmp.getNext().setPrev(null);
		this._Head = tmp.getNext();
		tmp.destroy();
		this._Largo --;
	}
	
	/**
	 * Agregar un dato al final de la lista doble.
	 * @param pDato {@link IComparable}
	 */
	public void add(IComparable pDato)
	{
		//Verifica si la lista esta vacia
		if( this.isEmpty() )
			this.addFirst(pDato);
		//Caso Corriente
		else
			this.addEnd(pDato);
	}
	
	/**
	 * Agregar un elemento en una determinada posicion de la lista.
	 * @param pDato {@link IComparable}
	 * @param pIndice {@link Integer}
	 * @throws Exception
	 */
	public void add(IComparable pDato, int pIndice)	 throws ExcepcionIndice
	{
		//Verificaciones
		if(pIndice >= 0 && pIndice <= this._Largo )
		{
			//Caso en que el nuevo dato sera la cabeza
			if(pIndice == 0)
				this.addStart(pDato);
			
			//Caso en el que el nuevo dato sera la cola
			else if(pIndice == this._Largo)
				this.addEnd(pDato);
			
			//Caso corriente
			else
			{
				//Pivote
				NodoDoble tmp = this._Head.getNext();
				//Iterar hasta encontrar el indice
				for(int x = 1; x != pIndice; x++)
					tmp = tmp.getNext();
				
				//Dato a Insertar
				NodoDoble nuevo = new NodoDoble(pDato);
				
				//Referencias del nuevo nodo
				nuevo.setNext(tmp);
				nuevo.setPrev(tmp.getPrev());
				
				//Referencias cambiadas
				nuevo.getPrev().setNext(nuevo);
				tmp.setPrev(nuevo);
				
				//Aumentar el largo
				this._Largo ++;
			}
		}
		
		else
			throw new ExcepcionIndice();
	}
	
	/**
	 * Agregar un dato al final de la lista doble.
	 * @param pDato
	 */
	protected void addEnd(IComparable pDato)
	{
		NodoDoble tmp = new NodoDoble(pDato);
		this._Tail.setNext(tmp);
		tmp.setPrev(this._Tail);
		this._Tail = tmp;
		this._Largo ++;
	}
	
	/**
	 * Insertar un dato al inicio de la lista doble.
	 * @param pDato {@link IComparable}
	 */
	public void addStart(IComparable pDato)
	{
		if( this.isEmpty() )
			this.addFirst(pDato);
		else
		{
			NodoDoble tmp = new NodoDoble(pDato);
			this._Head.setPrev(tmp);
			tmp.setNext(this._Head);
			this._Head = tmp;
			this._Largo ++;
		}
	}
	
	/**
	 * Su funcion esta en agregar un dato a una lista vacia.
	 * @param pDato
	 */
	protected void addFirst(IComparable pDato)
	{
		this._Head = this._Tail = new NodoDoble(pDato);
		this._Largo ++;
	}
	
	/**
	 * Imprime todos los elementos de la lista.
	 */
	public void print()
	{
		NodoDoble tmp = this._Head;
		System.out.print("[ ");
		for(int x = 0; x < this._Largo; x++)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println(" ]");
	}
	
	/**
	 * Retorna el largo de una lista.
	 * @return {@link Integer}
	 */
	public int size()
	{
		return this._Largo;
	}
	
	/**
	 * Determina mediante un valor booleano si un elemento se encuentra presente en
	 * la lista.
	 * @param pDato {@link IComparable}
	 * @return {@link Boolean}
	 */
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
	
	/**
	 * 
	 * @param pIndice {@link Integer}
	 * @return DatoBuscado {@link IComparable}
	 * @throws ExcepcionIndice
	 */
	public IComparable search(int pIndice) throws ExcepcionIndice
	{
		if(pIndice >= 0 && pIndice < this._Largo)
		{
			NodoDoble tmp = this._Head;
			for(int x = 0; x < pIndice; x ++ )
				tmp = tmp.getNext();
			return tmp.getDato();
		}
		else
			throw new ExcepcionIndice();
	}
	
	/**
	 * Inserta un dato en orden dentro de una lista, hasta encontrar un elemento mayor.
	 * @param pDato
	 * @throws ExcepcionIndice 
	 */
	public void addOrd(IComparable pDato) throws ExcepcionIndice
	{
		if(this.isEmpty())
			this.addFirst(pDato);
		else
		{
			NodoDoble pivote = this._Head;
			for(int x = 0; x <= this._Largo + 1; x++)
			{
				if(pivote == this._Tail.getNext())
				{
					this.addEnd(pDato);
					break;
				}
				else if(pDato.menor(pivote.getDato()))
				{
					this.add(pDato, x);
					break;
				}
					pivote = pivote.getNext();
			}
		}
	}
}