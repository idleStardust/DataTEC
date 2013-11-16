package colas;

import abs.IComparable;
import abs.IEncolable;
public class ColaArray implements IEncolable
{
	final int MAX = 99;
	IComparable[] _Array;
	int _Frente;
	int _Final;
	
	public ColaArray()  
	{
		this._Array = new IComparable[MAX];
		this._Final = 0;
		this._Frente = 0;
	}
	
	public boolean isEmpty()
	{
		return(this._Final == this._Frente);
	}
	
	public boolean isFull()
	{
		return(this._Final == MAX - 1);
	}
	
	public void print()
	{
		System.out.print("Cola: }");
		for(int x = 0; x < this._Final;x++)
		{
			this._Array[x].print();
			System.out.print(" ,");
		}
		System.out.println("} ");
	}

	@Override
	public IComparable dequeue() throws Exception
	{
		if(this.isEmpty())
			throw new Exception("Cola Vacia");
		else
		{
			IComparable result = this._Array[0];
			this._Array[0] = null;
			for(int i = 0; i < this._Final; i++)
				this._Array[i] = this._Array[i + 1];
			this._Final--;
			return result;
		}
	}

	@Override
	public void enqueue(IComparable pElemento) throws Exception
	{
		if(this.isFull())
			throw new Exception("Cola Llena");
		else
		{
			this._Array[this._Final++] = pElemento;
		}
	}
}