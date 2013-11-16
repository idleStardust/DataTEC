package colas;

import abs.IComparable;

public class BicolaArray extends ColaArray
{
	public BicolaArray()
	{
		super();
	}
	
	public void enqueueEnd(IComparable pElemento) throws Exception
	{
		super.enqueue(pElemento);
	}
	
	public void enqueueStart(IComparable pElemento) throws Exception
	{
		if(this.isFull())
			throw new Exception("Bicola Llena");
		else
		{
			this._Final++;
			for(int x = this._Final; x >= 1; x--)
				this._Array[x] = this._Array[x-1];
			this._Array[0] = pElemento;
		}
	}
	
	public IComparable dequeueStart() throws Exception
	{
		return super.dequeue();
	}
	
	public IComparable dequeueEnd()
	{
		IComparable result = this._Array[this._Final];
		this._Array[this._Final--] = null;
		return result;
	}
	
	public void print()
	{
		System.out.print("Bicola: }");
		for(int x = 0; x < this._Final;x++)
		{
			this._Array[x].print();
			System.out.print(" ,");
		}
		System.out.println("{ ");
	}
}
