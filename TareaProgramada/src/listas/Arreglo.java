package listas;

import abs.IColeccion;
import abs.IComparable;

public class Arreglo implements IColeccion
{
	IComparable[] _Dato;
	
	/**
	 * Inicializa el arreglo que contiene el objeto.
	 * @param pLargo {@link Integer}
	 */
	public Arreglo(int pLargo) 
	{
		this._Dato = new IComparable[pLargo];
	}

	/**
	 * @see IColeccionista
	 */
	@Override
	public void remove(IComparable pDato) 
	{
		int index = this.search(pDato);
		this.remove(index);
	}
	
	/**
	 * Elimina un arreglo 
	 * @param pIndex {@link Integer}
	 */
	public void remove(int pIndex)
	{

		int largo = this._Dato.length;
		
		//Verificaciones
		if(pIndex >= 0 && pIndex < largo)
		{
			//Nuevo arreglo temporal
			IComparable[] tmp = new IComparable[largo - 1];
			
			for(int x =  0; x < this._Dato.length; x++)
			{
				//Indice buscado igual al indice que maneja el for
				if(x == pIndex)
				{
					//Salta el dato borrado y agrega los restantes
					for(int y = x + 1; y < this._Dato.length; y++)
					{
						tmp[x] = this._Dato[y];
						x++;
					}
					this._Dato = tmp;
					break ;
				}
				
				//Copia datos arreglo viejo
				tmp[x] = this._Dato[x];
			}
		}
	}
	
	
	/**
	 * @see IColeccionista
	 */
	@Override
	public void add(IComparable pDato) 
	{
		//Largo Arreglo Viejo
		int tmplargo = this._Dato.length;
		
		//Nuevo Arreglo
		IComparable[] tmp = new IComparable[ tmplargo + 1 ];
		
		//Copiar Datos Viejo Arreglo
		for(int x = 0; x < tmplargo; x++)
			tmp[x] = this._Dato[x];
		
		//Agregar nuevo dato
		tmp[this._Dato.length] = pDato;
		
		//Reemplazar viejo Dato
		this._Dato = tmp;
	}
	
	/**
	 * Establece un valor para determinada posicion de un arreglo
	 * @param pDato {@link IComparable}
	 * @param pIndice {@link Integer}
	 */
	public void setValor(IComparable pDato, int pIndice)
	{
		//Verificaciones
		if(pIndice < this._Dato.length)
			this._Dato[pIndice] = pDato;
		else
			System.out.println("Error 404: Posicion no valida");
	}
	
	/**
	 * Soporta Indices no permitidos en el arreglo
	 * @param pIndice {@link Integer}
	 * @return {@link IComparable}
	 */
	public IComparable getValor(int pIndice)
	{
		IComparable result = null;
		
		//Verificaciones
		if(pIndice < this._Dato.length)
			result = this._Dato[pIndice];
		else
			System.out.println("Error 404: Posicion no valida");
		return result;
	}
	
	
	/**
	 * @see IColeccionista
	 */
	@Override
	public void print() 
	{
		System.out.print("[");
		{
			for(int x = 0; x < this._Dato.length; x++)
			{
				System.out.print(this._Dato[x]);
				System.out.print(", ");
			}
		}
		System.out.println("]");
	}

	
	/**
	 * 6 Nov
	 * Uso del Icomparable
	 * Index -1 en caso de no encontrarse
	 * Correccion Arreglos Incompletos
	 * Busca a partir de un Dato el indice del nodo que contiene el dato.
	 * @see IColeccionista
	 * @return {@link Integer}
	 */
	public int search(IComparable pDato) 
	{
		//Index por defecto
		int index = -1;
		
		//Iterara hasta encontrar el indice del dato brindado.
		for(int x = 0; x < this._Dato.length; x++)
		{
			IComparable tmp = this._Dato[x];
			if(tmp == null)
				continue;
			else if( tmp.igual(pDato))
			{
				index = x;
				break;
			}
		}
		return index;
	}
	
	/**
	 * Intercambia el valor de dos elementos del arreglo.
	 * @param pIndice1 {@link Integer}
	 * @param pIndice2 {@link Integer}
	 */
	public void intercambiarValor(int pIndice1, int pIndice2)
	{
		//Almacena un dato temporalmente
		IComparable tmpdato = this._Dato[pIndice1];
		
		//Burbuja
		this._Dato[pIndice1] = this._Dato[pIndice2];
		this._Dato[pIndice2] = tmpdato;
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}
}