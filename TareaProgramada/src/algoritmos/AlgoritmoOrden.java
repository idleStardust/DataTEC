package algoritmos;

public class AlgoritmoOrden
{
	/**
	 * Algoritmo caracterizado por el uso de la selección de un elemento llamado pivote.
	 * Se colocan los elementos menores al pivote en un arreglo y 
	 * los que son mayores que son mayores que el pivote van en otro arreglo.
	 * Quicksort puede ser implementado usando solo el arreglo inicial en lugar de crear nuevos arreglos. 
	 * @metodo Particion
	 * @mejor_caso O(n log n)
	 * @caso_promedio O(n log n)
	 * @peor_caso O(n^2)
	 * @memoria O(log n)
	 * @param pArreglo
	 */
	public static void quicksort(int pArreglo[])
	{
		if (pArreglo == null || pArreglo.length==0)
			return ;
		AlgoritmoOrden.quicksort(pArreglo, 0, pArreglo.length - 1);
	}

	private static void quicksort(int[] pArreglo, int primero, int ultimo)
	{
		int i = primero; 
		int j = ultimo;
		int pivote = pArreglo[ (primero + ultimo)/2 ];

		do {

			while (pArreglo[i] < pivote) i++;
			while (pArreglo[j] > pivote) j--;
			if (i <= j)
			{
				AlgoritmoOrden.swap(pArreglo, i, j);
				i++;
				j--;
			}
		}	while (i <= j);
		if (primero < j)
			AlgoritmoOrden.quicksort(pArreglo, primero, j); // mismo proceso con sublista izqda
		if (i < ultimo)
			AlgoritmoOrden.quicksort(pArreglo, i, ultimo); // mismo proceso con sublista drcha
	}

	private static void swap(int[] pArreglo, int pIndice1, int pIndice2)
	{
		//Guarda temporalmente la primera posicion del interambio
		int tmp = pArreglo[pIndice1];
		//Intercambio
		pArreglo[pIndice1] = pArreglo[pIndice2];
		pArreglo[pIndice2] = tmp;
	}

	public static void print(int[] pArray)
	{
		System.out.print("[ ");
		for(int i = 0; i < pArray.length; i++)
		{
			System.out.print(pArray[i] + ", ");
		}
		System.out.println("]");
	}

	public static void insertionsort (int [] a)
	{
		int j;
		int valorinsertado;
		for (int i = 1; i < a.length; i++)
		{
			//Indice para recorrer el arreglo
			j = i;
			//Valor a ser agregado
			valorinsertado = a[i];
			//Recorre los elementos anteriores al valor agregado
			while (j > 0 && valorinsertado < a[j-1])
			{
				//Desplaza los elementos para darle espacio al valor agregado
				a[j] = a[j-1];
				j--;
			}
			a[j] = valorinsertado;
		}
	}

	public static void selectionsort(int[] pArreglo)
	{
		int  i, j; 
		int largoarreglo, indiceMenor;
		largoarreglo = pArreglo.length;
		for (i = 0; i < largoarreglo-1; i++)
		{
			//Busca el indice con el elemento menor
			indiceMenor = i;
			for (j = i+1; j < largoarreglo; j++)
				if (pArreglo[j] < pArreglo[indiceMenor])
					indiceMenor = j;

			// Situa el elemento mas pequeño en la posicion a[i]
			if (i != indiceMenor)
				swap(pArreglo, i, indiceMenor);
		}
	}

	public static void bubblesort(int[] pArreglo)
	{
		boolean cambiado = true;
		int ultimosordenados = 0;

		while(cambiado)
		{
			cambiado = false;
			ultimosordenados ++;
			for(int x=0; x < pArreglo.length - ultimosordenados;x++)
			{
				if( pArreglo[x] > pArreglo[x+1])
				{
					AlgoritmoOrden.swap( pArreglo, x , x+1);
					cambiado = true;
				}
			}	
		}
	}

	public static void mergesort(int []pArray)
	{ 
		int i = 1; 
		for(i = 1; i < pArray.length;i*=2)
		{ 
			for(int j = 0;j < pArray.length; j += i)
			{
				int p = i >> 1;
				AlgoritmoOrden.merge(pArray,j,j+p-1,j+p,j+p+p-1); 
			} 
		}
		AlgoritmoOrden.merge(pArray,0,i/2 - 1,i/2,pArray.length); 
	} 



	private static void merge(int [] n,int a,int b,int c,int d)
	{ 
		d = Math.min(d,n.length-1);    
		int mer [] = new int[d-a + 1]; 
		int idx = 0; 
		int or = a; 

		while( idx < mer.length) 
		{
			if((a>b ? false : ( c > d? true : n[a] <= n[c]))) 
				mer[idx++] = n[a++];         
			else 
				mer[idx++] = n[c++];
		}

		for(int i = 0; i < mer.length; i++)
			n[or + i] = mer[i];
	}
}