package arboles;

import abs.IComparable;

public class NodoArbolAVL
{
	
	/**
	 * Dato que contiene el Nodo.
	 */
	private IComparable _Dato;
	
	
	/**
	 * Descendiente Hijo Derecho del Nodo.
	 */
	private NodoArbolAVL _HijoDer;
	
	
	/**
	 * Descendiente Hijo Izquierdo del Nodo.
	 */
	private NodoArbolAVL _HijoIzq;
	
	
	/**
	 * Ancestro directo del Nodo.
	 */
	private NodoArbolAVL _Padre;
	
	
	/**
	 * Factor utilizado en los equilibrios del arbol AVl.
	 */
	private int _FactorEquilibro;

	
	NodoArbolAVL(IComparable pDato) 
	{
		this._Dato = pDato;
		this._HijoDer = null;
		this._HijoIzq = null;
		this._Padre = null;
	}

	/**
	 * Establece un nuevo ancestro para el Nodo.
	 * @param pNodo
	 */
	protected void setPadre(NodoArbolAVL pNodo)
	{
		this._Padre = pNodo;
	}
	
	/**
	 * Retorna el Nodo hijo izquierdo del Nodo.
	 * @return {@link NodoArbolAVL}
	 */
	protected NodoArbolAVL getPadre()
	{
		return this._Padre;
	}
	
	/**
	 * Establece el Nodo hijo derecho del Nodo.
	 * @return {@link NodoArbolAVL}
	 */
	protected void setHijoDerecho(NodoArbolAVL pNodo)
	{
		this._HijoDer = pNodo;
	}
	
	/**
	 * Retorna el Nodo hijo derecho del Nodo.
	 * @return {@link NodoArbolAVL}
	 */
	protected NodoArbolAVL getHijoDerecho()
	{
		return this._HijoDer;
	}
	
	/**
	 * Establece un nuevo hijo izquierdo para el Nodo.
	 * @param pNodo
	 */
	protected void setHijoIzquierdo(NodoArbolAVL pNodo)
	{
		this._HijoIzq = pNodo;
	}
	
	/**
	 * Retorna el Nodo hijo izquierdo del Nodo.
	 * @return {@link NodoArbolAVL}
	 */
	protected NodoArbolAVL getHijoIzquierdo()
	{
		return this._HijoIzq;
	}
	
	/**
	 * Retorna el dato que contiene el Nodo.
	 * @return {@link IComparable}
	 */
	protected IComparable getDato()
	{
		return this._Dato;
	}
	
	/**
	 * Retorna el valor de verdad sobre si el nodo actua como una hoja.
	 * @return {@link Boolean}
	 */
	public boolean isHoja()
	{
		return (this._HijoDer == null) && (this._HijoIzq == null);
	}
	
	/**
	 * Retorna el valor de verdad sobre si el nodo contiene un hijo derecho.
	 * @return {@link Boolean}
	 */
	public boolean tieneHijoDerecho()
	{
		return (this._HijoDer != null);
	}

	/**
	 * Retorna el valor de verdad sobre si el nodo contiene un hijo izquierdo.
	 * @return {@link Boolean}
	 */
	public boolean tieneHijoIzquierdo()
	{
		return _HijoIzq != null;
	}

	/**
	 * Retorna el valor de verdad sobre si el Nodo actua como una raiz.
	 * @return {@link Boolean}
	 */
	public boolean isRaiz()
	{
		return this._Padre == null;
	}
	
	/**
	 * Imprime el Dato almacenado por el Nodo.
	 */
	public void print()
	{
		this._Dato.print();
	}
	
	/**
	 * Obtiene el numero factor de balanceo que almacena el Nodo.
	 * @return {@link Integer}
	 */
	public int getFactor()
	{
		return this._FactorEquilibro;
	}

	/**
	 * Establece un nuevo factor de equilibro para el Nodo.
	 * @param pFactorDeEquilibrio {@link Integer}
	 */
	public void setFactor(int pFactorDeEquilibrio)
	{
		this._FactorEquilibro = pFactorDeEquilibrio;
	}
}