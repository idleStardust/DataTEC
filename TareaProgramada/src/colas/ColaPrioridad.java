package colas;

import types.Integer2;
import abs.IComparable;
import abs.IEncolable;

public class ColaPrioridad implements IEncolable
{
	public static void main(String[] args) throws Exception
	{
		ColaPrioridad tmp = new ColaPrioridad();
		tmp.enqueue(new Integer2(1),3);
		tmp.enqueue(new Integer2(4),3);
		tmp.enqueue(new Integer2(5),3);
		tmp.enqueue(new Integer2(6),4);
		tmp.enqueue(new Integer2(10),1);
		tmp.enqueue(new Integer2(21),3);
		tmp.print();
		tmp.dequeue();
		tmp.dequeue();
		tmp.print();
	}
	/**
	 * Nodo frontal de la cola.
	 */
	protected NodoColaPrioridad _Frente;
	
	/**
	 * Nodo Final de la cola.
	 */
	protected NodoColaPrioridad _Final;
	
	@Override
	public IComparable dequeue() throws Exception 
	{
		NodoColaPrioridad tmp = this.buscaPrioridad();
		tmp._Dato.print();
		if(this.isEmpty())
			throw new Exception("Cola vacia");
		
		else if(this._Frente == this._Final)
			this._Final = this._Frente = null;
		
		else
		{
			NodoColaPrioridad pivote = this._Frente; 

			{
				pivote = pivote.getNext();
			}
			pivote.setNext(tmp.getNext());
		}
		
		return tmp.getDato();
	}
	
	private NodoColaPrioridad buscaPrioridad()
	{
		NodoColaPrioridad tmp = this._Frente;
		NodoColaPrioridad result = this._Frente;
		while(tmp != null)
		{
			if(tmp.getPrioridad() > result.getPrioridad())
				result = tmp;
			tmp = tmp.getNext();
		}
		return result;
	}
	
	@Override
	public boolean isEmpty()
	{
		return this._Frente == null;
	}
	
	public void enqueue(IComparable pElemento, int pPrioridad)
	{

		NodoColaPrioridad tmp = new NodoColaPrioridad(pElemento, pPrioridad);
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
	
	@Override
	public void enqueue(IComparable pElemento)
	{

		NodoColaPrioridad tmp = new NodoColaPrioridad(pElemento);
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
	
	@Override
	public void print()
	{
		NodoColaPrioridad tmp = this._Frente;
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