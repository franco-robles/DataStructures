package org.franco.linkedList;

public class Nodo <E>{
    public E value;
    public Nodo<E> next;
    public Nodo<E> previous;

    //Constructors
    public Nodo(E value){
        this.value = value;
        next =null;
        previous = null;
    }

}
