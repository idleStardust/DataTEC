package arboles;

import types.Integer2;
import abs.IComparable;


public class TreeAVL 
{
	private NodoArbolAVL _root;

	public void InsertarDato(IComparable pDato ){
		_root = InsertarDato( pDato, _root );
	}
	
	public static void main(String[] args)
	{
		TreeAVL tmp = new TreeAVL();
		tmp.InsertarDato(new Integer2(9));
		tmp.InsertarDato(new Integer2(6));
		tmp.InsertarDato(new Integer2(8));
		tmp.imprimir();
	}

	/*
	 * x es una instancia de una clase que implementa Comparable
	 */
	private NodoArbolAVL InsertarDato( IComparable pDato, NodoArbolAVL proot )
	{
		if( proot == null )
		{
			proot = new NodoArbolAVL(pDato);
		}
		else if( pDato.menor(proot.getDato())) 
		{
			proot.setHijoIzquierdo(InsertarDato( pDato, proot.getHijoIzquierdo()));
			if( calcularEquilibrio( proot.getHijoIzquierdo() ) - calcularEquilibrio( proot.getHijoDerecho() ) == 2 )
			{
				if( pDato.menor(proot.getHijoIzquierdo().getDato()))
				{
					proot = giroHijoIzquierdo( proot ); /* Caso 1 */
				}
				else
					proot = dobleGiroHijoIzquierdo( proot ); /* Caso 2 */
			}
			else if( pDato.mayor(proot.getDato())) 
			{
				proot.setHijoDerecho(InsertarDato( pDato, proot.getHijoDerecho()));
				if( calcularEquilibrio( proot.getHijoDerecho()) - calcularEquilibrio( proot.getHijoIzquierdo()) == 2 )
				{
					if( pDato.mayor(proot.getHijoDerecho().getDato()))
					{
						proot = giroHijoDerecho( proot ); /* Caso 4 */
					}
					else
					{
						proot = dobleGiroHijoDerecho( proot ); /* Caso 3 */
					}
				}
			}
			else
			{
				//Elemento Duplicado en el Arbol
				proot.setFactor( max( calcularEquilibrio( proot.getHijoIzquierdo()), calcularEquilibrio( proot.getHijoDerecho()) ) + 1);
			}
		}
		return proot;

	}


	private int max( int lhs, int rhs )
	{
		return lhs > rhs ? lhs : rhs;
	}


	private NodoArbolAVL giroHijoIzquierdo( NodoArbolAVL pNodoPadre )
	{
		NodoArbolAVL pNodoHijoIzq = pNodoPadre.getHijoIzquierdo();
		pNodoPadre.setHijoIzquierdo(pNodoHijoIzq.getHijoDerecho());
		pNodoHijoIzq.setHijoDerecho(pNodoPadre);
		pNodoPadre.setFactor(max( calcularEquilibrio(pNodoPadre.getHijoIzquierdo()), calcularEquilibrio(pNodoPadre.getHijoDerecho())) + 1);
		pNodoHijoIzq.setFactor(max( calcularEquilibrio( pNodoHijoIzq.getHijoIzquierdo() ), pNodoPadre.getFactor() ) + 1);
		
		return pNodoHijoIzq;
	}


	private NodoArbolAVL giroHijoDerecho( NodoArbolAVL pNodoPadre )
	{
		NodoArbolAVL pNodoHijoDer = pNodoPadre.getHijoDerecho();
		pNodoPadre.setHijoDerecho(pNodoHijoDer.getHijoIzquierdo());
		pNodoHijoDer.setHijoIzquierdo(pNodoPadre);
		pNodoPadre.setFactor(max( calcularEquilibrio(pNodoPadre.getHijoIzquierdo()), calcularEquilibrio(pNodoPadre.getHijoDerecho()) ) + 1);
		pNodoHijoDer.setFactor(max( calcularEquilibrio( pNodoHijoDer.getHijoDerecho() ), pNodoPadre.getFactor()) + 1);
		
		return pNodoHijoDer;
	}


	private NodoArbolAVL dobleGiroHijoIzquierdo(NodoArbolAVL pNodoRoot)
	{
		pNodoRoot.setHijoIzquierdo(giroHijoDerecho( pNodoRoot.getHijoIzquierdo()));
		return giroHijoIzquierdo( pNodoRoot );
	}


	private NodoArbolAVL dobleGiroHijoDerecho(NodoArbolAVL pNodoRoot)
	{
		pNodoRoot.setHijoDerecho(giroHijoIzquierdo( pNodoRoot.getHijoDerecho()));
		return giroHijoDerecho(pNodoRoot);
	}


	private int calcularEquilibrio(NodoArbolAVL pNodo)
	{
		return pNodo == null ? -1 : pNodo.getFactor();
	}

	public void imprimir()
	{
		imprimir(this._root);
	}

	private void imprimir(NodoArbolAVL pNodo){
		if ( pNodo != null ){
			imprimir(pNodo.getHijoDerecho());
			System.out.println("[");
			pNodo.print();
			System.out.println("]");
			imprimir(pNodo.getHijoIzquierdo());
		}
	}

	public void imprimirXaltura(){
		imprimirXaltura ( _root );
	}

	/*
	 * Imprime cada nodo linea por linea. Recorriendo el arbol desde
	 * el Nodo más a la derecha hasta el nodo más a la izquierda,
	 * y dejando una identacion de varios espacios en blanco segun su
	 * altura en el arbol
	 */
	 private void imprimirXaltura(NodoArbolAVL pNodo){
		 if ( pNodo != null ){
			 imprimirXaltura(pNodo.getHijoDerecho());
			 System.out.println( replicate(" ",calcularEquilibrio(_root) - calcularEquilibrio(pNodo)) +"[");
			 pNodo.print();
			 System.out.println("]");
			 imprimirXaltura(pNodo.getHijoIzquierdo());
		 }
	 }

	 /*
	  * Metodo estatico auxiliar que dada una cadena a y un enterto cnt
	  * replica o concatena esa cadena a, cnt veces
	  */
	 private String replicate (String a, int cnt){
		 String x = new String("");

		 for ( int i = 0; i < cnt; i++ )
			 x = x + a;
		 return x;
	 }

	 /*
	  * Obtiene la altura del arbol AVL
	  */
	 public int calcularAltura(){
		 return calcularAltura(_root);
	 }

	 private int calcularAltura(NodoArbolAVL actual ){
		 if (actual == null)
			 return -1;
		 else
			 return 1 + Math.max(calcularAltura(actual.getHijoIzquierdo()), calcularAltura(actual.getHijoDerecho()));
	 }

	 // Imprime el arbol por niveles. Comienza por la raiz.
	 public void imprimirPorNiveles(){
		 imprimirPorNiveles(_root);
	 }

	 // Imprime el arbol por niveles.
	 private void imprimirPorNiveles(NodoArbolAVL nodo){
		 // Mediante la altura calcula el total de nodos posibles del árbol
		 // Y crea una array cola con ese tamaño
		 int max = 0;
		 int nivel = calcularAltura();

		 for ( ; nivel >= 0; nivel--)
			 max += Math.pow(2, nivel);
		 max++; // Suma 1 para no utilizar la posicion 0 del array

		 NodoArbolAVL cola[] = new NodoArbolAVL[ max ];

		 // Carga en la pos 1 el nodo raiz
		 cola[1] = nodo;
		 int x = 1;

		 // Carga los demas elementos del arbol,
		 // Carga null en izq y der si el nodo es null
		 // i aumenta de a 2 por q carga en izq y der los hijos
		 // x aumenta 1, que son los nodos raiz - padre
		 for (int i = 2; i < max; i += 2, x++){
			 if (cola[x] == null){
				 cola[i] = null;
				 cola[i + 1] = null;
			 }
			 else{
				 cola[i] = cola[x].getHijoIzquierdo();
				 cola[i + 1] = cola[x].getHijoDerecho();
			 }
		 }
		 nivel = 0;
		 int cont = 0; // contador para cada nivel
		 int cantidad = 1; // cantidad de nodos por nivel
		 int ultimaPosicion = 1; // ultimaPosicion del nodo en la cola de cada nivel

		 // Cuando i es = a 2^nivel hay cambio de nivel
		 // 2 ^ 0 = 1 que es el nodo raiz
		 for (int i = 1; i < max; i++){
			 if(i == Math.pow(2, nivel)){
				 // Nodo raiz tiene nivel 1, por eso (nivel + 1)
				 System.out.print("\n Nivel " + (nivel) + ": ");
				 nivel++;
			 }
			 if( cola[i] != null ){
				 System.out.print("[");
				 cola[i].print();
				 System.out.println("]");
				 cont++;
			 }
			 if(ultimaPosicion == i && cantidad == Math.pow(2, --nivel)){
				 if(cantidad == 1)
					 System.out.print(" Cantidad de nodos: " + cont + " (raiz)");
				 else
					 System.out.print(" Cantidad de nodos: " + cont);
				 cont = 0;
				 cantidad *= 2;
				 ultimaPosicion += (int)Math.pow(2, ++nivel);
			 }
		 }
	 }
}

