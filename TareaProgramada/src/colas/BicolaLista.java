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
		NodoCola tmp = new NodoCola(pDato);
		if(this.isEmpty())
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
	
	
	public IComparable dequeueStart() throws Exception
	{
		return super.dequeue();
	}
	
	public IComparable dequeueEnd() throws Exception
	{
		//Nodo Final sera desencolado
		NodoCola tmp = this._Frente;
		NodoCola desencolado = this._Final;
		
		//Bicola Vacia
		if(this.isEmpty())
			throw new Exception("Cola vacia");
				
		//Bicola con un elemento
		else if(desencolado == this._Frente)
			this._Final = this._Frente = null;
		
		//Bicola: Caso Corriente
		else
		{
			while( tmp.getNext() != desencolado ) 
				tmp = tmp.getNext();
			this._Final = tmp;
			tmp.setNext(null);
		}
		return desencolado.getDato();
	}
	
	@Override
	public void print()
	{
		NodoCola tmp = this._Frente;
		System.out.print("} ");
		while(tmp != null)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println("{ ");
	}
}