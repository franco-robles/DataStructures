package org.franco.node;

public class Node<E>{
    public E value;
    public Node<E> next;
    public Node<E> previous;

    //Constructors
    public Node(E value){
        this.value = value;
        next =null;
        previous = null;
    }

}
