// Clase NodosLista
class NodosLista {
 // datos amigables para que la Clase Lista Tenga un acceso directo
     int datos;
     NodosLista siguiente;

//Construtor  Crea un nodo del tipo Object
 NodosLista (int  valor)
  {  datos =valor;
     siguiente = null;  //siguiente con valor de nulo
  }

// Constructor Crea un nodo del Tipo Object y al siguiente nodo de la lista
NodosLista (int valor, NodosLista signodo)
{   datos = valor;
    siguiente = signodo; //siguiente se refiere al siguiente nodo
}

//Retorna el dato que se encuentra en este nodo
int getint() {return datos; }

//Retorna el siguiente nodo
NodosLista getnext() {return siguiente; }

}
//Final de la Clase NodosLista


//Definición de la Clase Lista
public class ListaSimple {
  public NodosLista PrimerNodo;
  public NodosLista UltimoNodo;
  String Nombre;

//Constructor construye una lista vacia con un nombre s

//Retorna True si Lista Vacía
 public boolean VaciaLista () {return PrimerNodo == null;}

// Imprime el contenido de la lista
 public void Imprimir()
 { if (VaciaLista())
   {
     System.out.println( "vacia" +Nombre);
   }
  else
  {
	  System.out.print( "La  " +  Nombre  +"  es:  ");
      NodosLista Actual = PrimerNodo;

     while (Actual != null){
      System.out.print (Actual.datos+" ");
      Actual=Actual.siguiente;
     }
     System.out.println();
     System.out.println();
   }
 }

 public ListaSimple (String s)
{ Nombre = s;
  PrimerNodo = UltimoNodo =null;
}

//Constructor construye una lista vacia con un nombre de List
public ListaSimple(){ this ("Lista");}

//Inserta un Elemento al Frente de la Lista
//Si esta vacía PrimerNodo y UltimoNodo se refieren al nuevo nodo. Si no PrimerNodo se refiere al nuevo nodo.

public void InsertaInicio (int ElemInser)
{ if (VaciaLista())
   PrimerNodo = UltimoNodo = new NodosLista (ElemInser);
  else
   PrimerNodo = new NodosLista (ElemInser, PrimerNodo);
}


//Inserta al Final de la Lista
//Si la lista se encuentra vacía, el PrimerNodo y el UltimoNodo se refieren al nuevo nodo. Si no, la variable de siguiente de UltimoNodo se refiere al nuevo nodo.
public void InsertaFinal(int ElemInser)
{ if ( VaciaLista())
     PrimerNodo = UltimoNodo = new NodosLista (ElemInser);
  else
     UltimoNodo=UltimoNodo.siguiente =new NodosLista (ElemInser);
}



//Borradores de la lista
//Eliminar al Inicio
//Debe tomar en cuenta si la lista se encuentra vacía y producir una excepción, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  primernodo será igual a PrimerNodo.siguiente

public void EliminaInicio()
{

if  ( VaciaLista()) System.out.println ("No hay elementos");//throw new ExceptionListException (Nombre);
// Restablecer  las referencias de PrimerNodo y UltimoNodo
if (PrimerNodo.equals (UltimoNodo))
  PrimerNodo = UltimoNodo = null;
else
   PrimerNodo = PrimerNodo.siguiente;

}

//Eliminar al Final
//Debe tomar en cuenta si la lista se encuentra vacía y producir una excepción, en caso contrario si PrimerNodo y UltimoNodo referencian al mismo nodo, ambos deben ser null y sino  ultimonodo en el campo siguiente será nulo
public void EliminaFinal () 
{
if  ( VaciaLista())
  System.out.println ("No hay elementos");//throw new ExceptionListException (Nombre);

//Restablecer  las referencias de PrimerNodo y UltimoNodo
if (PrimerNodo.equals (UltimoNodo))
  PrimerNodo = UltimoNodo = null;
else
{ NodosLista Actual =PrimerNodo;
  while (Actual.siguiente != UltimoNodo)
      Actual = Actual.siguiente;

  UltimoNodo =Actual;
  Actual.siguiente = null;
}
}



//Elimina un Elemento en una posición dada, para el uso por prioridades. 
//Si esta vacía PrimerNodo y UltimoNodo se refieren al nuevo nodo.
//Si no PrimerNodo se refiere al nuevo nodo.

public  void EliminaMedio (int Posicion)
{
	if  ( VaciaLista())
		System.out.println( "Nada");

  else
 {
	 
	 NodosLista Aux =null;
   NodosLista Actual = PrimerNodo;
   int i =1;
   while (( i != Posicion) & (Actual.siguiente != null))
   { i++;
     Aux =Actual;
     Actual =Actual.siguiente;
   }
   if( i ==Posicion)
	 {
	   if (Aux == null)
	   {
      Actual = PrimerNodo;
     
      PrimerNodo = PrimerNodo.siguiente;
     }
     else
     
       Aux.siguiente = Actual.siguiente;
	 
	 }
 }
}
//Metodo Operacion 
void Operacion()
{
	NodosLista aux= PrimerNodo;
	while (aux!=null)
		{if (aux.datos%2==0)
			{aux.datos=aux.datos*3;
			aux=aux.siguiente;
			}
		else
			{aux.datos=aux.datos+2;
			aux=aux.siguiente;
			}
		}
}


};


class Prueba
{
 public static void main (String [] args)
 		{
 		
	 		ListaSimple L1 = new ListaSimple();

	 		L1.InsertaInicio(14);
	 		L1.Imprimir();
                        L1.InsertaFinal(25);
                        L1.Imprimir();
                        L1.InsertaFinal(35);
                        L1.Imprimir();
                        L1.EliminaInicio();
                        L1.Imprimir();
                        L1.Imprimir();
			System.out.println("Primer Nodo: "+L1.PrimerNodo.datos);
                        L1.Imprimir();
                      

 		}
	
}