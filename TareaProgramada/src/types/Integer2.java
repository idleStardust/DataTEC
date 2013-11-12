package types;

import abs.IComparable;

public class Integer2 implements IComparable
{
	int _Dato;
	
	public Integer2(int pDato) 
	{
		this._Dato = pDato;
	}

	@Override
	public boolean menor(IComparable pComparable) 
	{
		Integer2 tmp = (Integer2) pComparable;
		return(this._Dato < tmp.getDato());
	}

	@Override
	public boolean mayor(IComparable pComparable) 
	{
		Integer2 tmp = (Integer2) pComparable;
		return(this._Dato > tmp.getDato());
	}

	@Override
	public boolean igual(IComparable pComparable) 
	{
		Integer2 tmp = (Integer2) pComparable;
		return (this._Dato == tmp.getDato());
	}
	
	public int getDato()
	{
		return this._Dato;
	}

	@Override
	public void print() 
	{
		int tmp = (int) this._Dato;
		System.out.print(tmp);
	}
}
