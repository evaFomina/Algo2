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
        }  else {
            ultimNodo = nuevo;
        } 
        nuevo.sig = primero;
        nuevo.ant = null;
        primero = nuevo;
        longitud ++;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
            ultimNodo = nuevo;
        } else {
            ultimNodo.sig = nuevo;
            nuevo.ant = ultimNodo;
            ultimNodo = nuevo;
            /*Nodo actual = primero;
            while (actual.sig != null) {
                actual = actual.sig;
            }
            actual.sig = nuevo;    
            nuevo.ant = actual;*/
            
        }
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
            actual.ant = null;
        } else {
            prev.sig = actual.sig;
            if (actual.sig != null) {
                actual.sig.ant = prev;
            }
        }
        longitud --;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        for (int j = 0; j < indice; j++) {
            actual = actual.sig;
            
        }
        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<T>();
        Nodo<T> actual = this.primero;
        for (int j = 0; j < longitud; j ++) {
            nuevaLista.agregarAtras(actual.valor);
            actual = actual.sig;
        } 
        return nuevaLista;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo<T> actual = lista.primero;
        for(int j = 0; j < lista.longitud; j++){
            this.agregarAtras(actual.valor);
            actual = actual.sig;
        }
    }
    
    @Override
    public String toString() {
        String res = "";
        res = res + "[";
        Nodo<T> actual = primero;
        for(int j = 0; j<longitud-1; j++){
            res = res + actual.valor + ", ";
            actual = actual.sig;
        }
        res = res + ultimNodo.valor + "]";
        return res;

    }

    private class ListaIterador implements Iterador<T> {
    	Nodo<T> indice;
        
        public ListaIterador(){
            this.indice = null;
        }

        public boolean haySiguiente() {
            if(indice == null){
                return primero != null;
            } else {
                return indice.sig!=null;
            }
        }
        
        public boolean hayAnterior() {
	        return indice != null;
            
        }

        public T siguiente() {
            if(indice == null){
               indice = primero;
               return indice.valor; 
            } else {
                indice = indice.sig;
                return indice.valor;
            }
        }
        

        public T anterior() {
                 Nodo<T> i = indice;
                 indice = indice.ant;
                 return i.valor;
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
