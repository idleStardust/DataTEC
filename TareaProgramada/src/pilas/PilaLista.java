package pilas;

import abs.IComparable;

public class PilaLista
{
	NodoPila _Frente;
	NodoPila _Final;

	public PilaLista() 
	{
		this._Final = null;
		this._Frente = null;
	}
	
	public IComparable pop() throws ExcepcionPilaVacia
	{
		NodoPila tmp = this._Frente;
		NodoPila fuerapila = this._Final;
		
		if (this.isEmpty())
			throw new ExcepcionPilaVacia();
			
		else if(fuerapila == this._Frente)
			this._Final = this._Frente = null;

		else
		{
			while( tmp.getNext() != fuerapila ) 						
				tmp = tmp.getNext();
			this._Final = tmp;
			tmp.setNext(null);
		}
		return fuerapila.getDato();
	}
	
	public void push(IComparable pDato)
	{
		NodoPila tmp = new NodoPila(pDato);
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
	
	
	public boolean isEmpty()
	{
		return this._Frente == null;
	}
	public IComparable top() throws ExcepcionPilaVacia
	{
		if (this.isEmpty())
			throw new ExcepcionPilaVacia();
		else
			return this._Final.getDato();
	}
	
	public void print()
	{
		NodoPila tmp = this._Frente;
		System.out.print("Pila: { ");
		while(tmp != null)
		{
			tmp.getDato().print();
			System.out.print(", ");
			tmp = tmp.getNext();
		}
		System.out.println("{ ");
	}
}
