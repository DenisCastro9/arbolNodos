
public class Parcial2 {

	
	class Nodo
	{
		int info;
		Nodo izq, der;
	}
	
	Nodo raiz;
	
	public void insertar(int x)
	{
		Nodo nuevo = new Nodo();
		nuevo.info = x;
		if(raiz == null)
		{
			raiz = nuevo;
		}
		else
		{
			Nodo atras = null;
			Nodo reco = raiz;
			while(reco != null)
			{
				atras = reco;
				if(x < reco.info)
				{
					reco = reco.izq;
				}
				else
				{
					reco = reco.der;
				}
			}
			if(x < atras.info)
			{
				atras.izq = nuevo;
			}
			else
			{
				atras.der = nuevo;
			}
		}
	}
	
	private void imprimirEntreOrden(Nodo reco)
	{
		if(reco != null)
		{
			imprimirEntreOrden(reco.izq);
			System.out.println(reco.info + " - ");
			imprimirEntreOrden(reco.der);
		}
	}
	
	public void imprimirEntreOrden()
	{
		imprimirEntreOrden(raiz);
	}
	
	//Me saltaba un error en el parametro que recibia el boolean
	/*public boolean existe(int x)
	{
		Nodo reco = raiz;
		while(reco != null)
		{
			if(x == reco.info)
			{
				return true;
			}
			else
			{
				while(reco != null)
				{
					if(x == reco.info)
					{
						return true;
					}
					else
					{
						reco = reco.izq;
					}
				}
				reco = raiz;
				while(reco != null)
					if(x == reco.info)
					{
						return true;
					}
					else
					{
						reco = reco.izq;
					}
			}
			return false;
		}
	}*/
	
	public void MostrarMayorSubIzq()
	{
		if(raiz == null)
		{
			System.out.println("EL arbol esta vacio");
		}
		else
		{
			if(raiz.izq == null)
			{
				System.out.println("El subArbol izquierdo esta vacio");
			}
			else
			{
				Nodo reco = raiz.izq;
				while(reco.der != null)
				{
					reco = reco.der;
				}
				System.out.println("El mayor valor del subArbol izquierdo es: " + reco.info);
			}
		}
	}
	
	private void mostrarNodosHojas(Nodo reco)
	{
		if(reco != null)
		{
			mostrarNodosHojas(reco.izq);
			mostrarNodosHojas(reco.der);
			if(reco.der == null && reco.izq == null)
			{
				nodosHojas++;
				System.out.println("Cantidad de Nodos hojas: " + nodosHojas);
				System.out.println(reco.info + " - ");
			}
		}
	}
	
	int nodosHojas;
	public void mostrarNodosHojas()
	{
		mostrarNodosHojas(raiz.izq);
	}
	
	public void borrarMayor()
	{
		if(raiz != null)
		{
			if(raiz.der == null)
			{
				raiz = raiz.izq;
			}
			else
			{
				Nodo reco = raiz.der;
				Nodo atras = raiz;
				while(reco.der != null)
				{
					atras = reco;
					reco = reco.der;
				}
				atras.der = reco.izq;
			}
		}
	}
	
	private void mayorCantidadNodosIzq(Nodo reco)
	{
		if(reco != null)
		{
			mayorCantidadNodosIzq(reco.izq);
			mayorCantidadNodosIzq(reco.der);
			izquierdo++;
		}
	}
	
	private void mayorCantidadNodosDer(Nodo reco)
	{
		if(reco != null)
		{
			mayorCantidadNodosDer(reco.izq);
			mayorCantidadNodosDer(reco.der);
			derecho++;
		}
	}
	
	int izquierdo, derecho;
	public void mayorCantidadNodos()
	{
		izquierdo = 1;
		derecho = 1;
		mayorCantidadNodosIzq(raiz.izq);
		mayorCantidadNodosDer(raiz.der);
		if(izquierdo > derecho)
		{
			System.out.println("El subArbol izquierdo tiene mas cantidad de Nodos");
		}
		else
		{
			System.out.println("El subArbol derecho tiene mas cantidad de Nodos");
		}
	}
	
	public static void main(String[] args) {
		Parcial2 arbol = new Parcial2();
		arbol.insertar(10);
		arbol.insertar(20);
		arbol.insertar(6);
		arbol.insertar(4);
		arbol.insertar(30);
		arbol.insertar(24);
		arbol.imprimirEntreOrden();
		arbol.MostrarMayorSubIzq();
		arbol.mostrarNodosHojas();
		arbol.borrarMayor();
		arbol.mayorCantidadNodos();
	}

}
