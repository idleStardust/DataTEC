package pilas;

import abs.IComparable;

public class PilaArray
{
	final int MAX = 99;
	IComparable[] _Array;
	int _Frente;
	int _Final;
	
	public PilaArray() 
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
	
	public IComparable top() throws ExcepcionPilaVacia
	{
		if(this.isEmpty())
			throw new ExcepcionPilaVacia();
		else
			return this._Array[this._Frente];
	}
	
	public IComparable pop() throws ExcepcionPilaVacia
	{
		if(this.isEmpty())
			throw new ExcepcionPilaVacia();
		else
		{
			IComparable result = this._Array[this._Final];
			this._Array[this._Final--] = null;
			return result;
		}
	}
	
	public void push(IComparable pDato) throws Exception
	{
		if(this.isFull())
			throw new Exception("Pila Llena");
		else
		{
			this._Array[this._Final++] = pDato;
		}
	}
	
	public void print()
	{
		System.out.print("Pila: {");
		for(int x = 0; x < this._Final;x++)
		{
			this._Array[x].print();
			System.out.print(" ,");
		}
		System.out.println("{ ");
	}
}
