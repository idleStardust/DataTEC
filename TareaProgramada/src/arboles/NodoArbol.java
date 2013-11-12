package arboles;

import abs.IComparable;

public class NodoArbol
{
	IComparable _Dato;
	NodoArbol _HijoDer;
	NodoArbol _HijoIzq;
	
	public NodoArbol(IComparable pDato)
	{
		this._Dato = pDato;
	}
}
