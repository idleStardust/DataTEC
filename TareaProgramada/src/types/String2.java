package types;

import abs.IComparable;

public class String2 implements IComparable
{
	String _Dato;
	
	public String2(String pDato) 
	{
		this._Dato = pDato;
	}

	@Override
	public boolean menor(IComparable pComparable) 
	{
		String2 tmp = (String2) pComparable;

		return(this._Dato.length() < tmp.getDato().length());
	}

	@Override
	public boolean mayor(IComparable pComparable) 
	{
		String2 tmp = (String2) pComparable;
		return(this._Dato.length() > tmp.getDato().length());
	}

	@Override
	public boolean igual(IComparable pComparable) 
	{
		String2 tmp = (String2) pComparable;
		return (this._Dato.equalsIgnoreCase(tmp.getDato()));
	}
	
	@Override
	public boolean diferente(IComparable pComparable) 
	{
		String2 tmp = (String2) pComparable;
		return !(this._Dato.equalsIgnoreCase(tmp.getDato()));
	}
	
	public String getDato()
	{
		return this._Dato;
	}
	
	@Override
	public void print() 
	{
		System.out.print(this._Dato);
	}
}
