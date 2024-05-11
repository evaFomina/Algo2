package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo<T> primero;
    private Nodo<T> ultimNodo;
    private int longitud;


    private class Nodo<T> {  //constructor de la clase 
        T valor;
        Nodo<T> sig;
        Nodo<T> ant;
        

        public Nodo(T v){  //constructor del nodo
            valor = v;
            ant = null;
            sig = null;
        }

    }

    public ListaEnlazada() {   //constructor de la lista nueva tiene todo null/0
       primero = null;
       ultimNodo = null;
       longitud = 0; 
    }

    public int longitud() {
        return longitud;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if(primero != null) {
            primero.ant = nuevo; 
        }    
        nuevo.sig = primero;
        nuevo.ant = null;
        primero = nuevo;
        longitud ++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero != null){
            ultimNodo.sig = nuevo;
        } 
        nuevo.ant = ultimNodo; 
        ultimNodo = nuevo;
        nuevo.sig = null;    
        longitud ++;
    }

    public T obtener(int i) {
        T res;
        Nodo<T> actual = primero;
        for (int j=0; j < i; j++) {
            actual = actual.sig;
        }
        res = actual.valor;
        return res;
    }

    public void eliminar(int i) {
        Nodo actual = primero;
        Nodo prev = primero;
        for (int j = 0; j < i; j++) {
            prev = actual;
            actual = actual.sig;
        }
        if (i == 0) {
            primero = actual.sig;
        } else {
            prev.sig = actual.sig;
        }
        longitud --;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int j = 0; j < indice; j++) {
            primero = actual;
            actual = actual.sig;
            
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<T>();
        nuevaLista.longitud = longitud;
        nuevaLista.primero = new Nodo<T>(primero.valor);
        return nuevaLista; 

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        throw new UnsupportedOperationException("No implementada aun");
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
