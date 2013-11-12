package colas;

import abs.IComparable;
import abs.IEncolable;

public class ColaArray implements IEncolable
{
		private static final int MAXTAM = 99;
		
		//Apuntadores
		protected int _Head;
		protected int _Tail;
		
		//Arreglo
		protected IComparable[] _ArrayCola;
		
		public ColaArray()
		{
			this._Head = 0;
			this._Tail = MAXTAM - 1;
			this._ArrayCola = new IComparable [MAXTAM];
		}
		
		public int siguiente(int pIndex)
		{
			return (pIndex + 1) % MAXTAM;
		}
		
		@Override
		public void enqueue(IComparable pElemento) throws Exception
		{
			if ( !this.colaLlena() )
			{
				this._Tail = this.siguiente(this._Tail);
				this._ArrayCola[this._Tail] = pElemento;
			}
			else
				throw new Exception("Cola Llena: ");
		}

		@Override
		public IComparable dequeue() throws Exception 
		{
			IComparable tmp = null;
			if ( !this.colaVacia() )
			{
				tmp = this._ArrayCola[this._Head];
				this._Head = this.siguiente(this._Head);
			}
			else
				throw new Exception("Cola vacia: ");
			return tmp;
		}

		@Override
		public boolean colaVacia() 
		{
			return this._Head == this.siguiente(this._Tail);
		}
		
		@Override
		public boolean colaLlena()
		{
			return this._Head == this.siguiente( this.siguiente(this._Tail));
		}
		
		public IComparable top() throws Exception
		{
			if ( !this.colaVacia() )
			{
				return this._ArrayCola[this._Head];
			}
			else
				throw new Exception("Cola vacia: ");
		}
}