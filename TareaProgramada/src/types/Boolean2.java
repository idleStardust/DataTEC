package types;

import abs.IComparable;

public class Boolean2 implements IComparable
{
	boolean _Dato;
	
	public Boolean2(boolean pDato) 
	{
		this._Dato = pDato;
	}

	/**
	 * 
	 */
	@Override
	public boolean menor(IComparable pComparable) 
	{
		Boolean2 tmp = (Boolean2) pComparable;
		return(this._Dato || tmp.getDato());
	}

	/**
	 * 
	 */
	@Override
	public boolean mayor(IComparable pComparable) 
	{
		Boolean2 tmp = (Boolean2) pComparable;
		return(this._Dato && tmp.getDato());
	}

	@Override
	public boolean igual(IComparable pComparable) 
	{
		Boolean2 tmp = (Boolean2) pComparable;
		return (this._Dato  ==  tmp.getDato());
	}
	
	@Override
	public boolean diferente(IComparable pComparable) 
	{
		Boolean2 tmp = (Boolean2) pComparable;
		return (this._Dato  !=  tmp.getDato());
	}
	
	public boolean getDato()
	{
		return this._Dato;
	}

	@Override
	public void print() 
	{
		boolean tmp = (boolean) this._Dato;
		System.out.print(tmp);
	}	
}
