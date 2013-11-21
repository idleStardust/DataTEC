package admin;

import java.util.Random;

import types.Integer2;
import abs.IColeccion;
import arboles.TreeAVL;

public class CAdmin
{
	Random Aleatorio = new Random();
	
	public static void main(String[] args)
	{
		CAdmin administrator = new CAdmin();
		TreeAVL avl = new TreeAVL();
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		avl.insert(4);
		avl.insert(5);
		avl.insert(6);
		avl.insert(7);
		avl.insert(8);
		avl.insert(9);
		avl.insert(10);
		//Conteo
		long tiempoInicial =  System.nanoTime();
		
		
		//Finalizacion
		long tiempoFinal =  System.nanoTime();
		
		//Tiempo
		System.out.println(tiempoFinal - tiempoInicial);
	}
	
	public void generarRandom(int pNumeroRandom, IColeccion pTDA)
	{
		for(int x =0; x < pNumeroRandom; x++)
			pTDA.add(new Integer2(Aleatorio.nextInt(x)));
	} 
	
	public int[] generarRandomArray(int pNum)
	{
		int[] result = new int[pNum];
		for(int i = 0; i < pNum; i++)
			result[i] = Aleatorio.nextInt();
		return result;
	}
	
	public void print(int[] pArray)
	{
		System.out.print("[ ");
		for(int x = 0; x < pArray.length; x++)
			System.out.print(pArray[x] + ", ");
		System.out.println(" ]");
	}
}
