package org.franco.linkedList;


public class LinkedList <E> {
    //attributes
    private Nodo<E> first;
    private Nodo<E> last;
    private Long size;

    //constructor
    public LinkedList(){
         size =0L;
         last = null;
         first = null;
    }

    //methods

    public boolean isEmpty(){
        return (size==0);
        //return true if the list have no elements and false in othercase
    }

    /**
     *     Insertion on a Doubly Linked List
     *        * Insertion at the beginning
     *        * Insertion in-between nodes
     *        * Insertion at the End
      */

    //Insertion at the End
    public void addEnd(E value){
        //"end" is where the X is  a->b->c->d->X
        Nodo<E> nodo = new Nodo<E>(value);
        nodo.previous = last;
        if(last==null){
            first = nodo;
        }else {
            last.next = nodo;
        }
        last = nodo;
        size++;
    }

    //Insertion at the beginning
    public void addFront(E value){
        //"beginning" is where the X is  X->b->c->d->
        Nodo<E> nodo = new Nodo<E>(value);
        nodo.next = first;
        if(first==null){
            last = nodo;
        }else {
            first.previous = nodo;
        }
        first = nodo;
        size++;
    }

    //Insertion in-between nodes
    //the prevNode has to exist on the list: i need check this
    //Falta comprobar que el nodo exita eso es O(n) con n=size
    public void addAfter(Nodo<E> prevNodo, E value){
         if(prevNodo ==null) {
            System.out.println("error: node cannot be null");
            return;
        }
        Nodo<E> newNode = new Nodo<E>(value);
        newNode.next = prevNodo.next;
        newNode.previous = prevNodo;
        prevNodo.next = newNode;
        if(newNode.next!=null) {
            (newNode.next).previous = newNode;
        }else {
            last = newNode;
        }
        size++;
    }


    //return the same list without the first element
    //the first element is eliminted
    public LinkedList<E> end(){
        if(first == null){// esto tendria qe cambiarlo por un log de "list is empty"
            return this;
        }else if(first == last){
            first = null;
            last = null;
            size--;
            return this;
        }
        first =  first.next;
        first.previous = null ;
        size--;
        return this;
    }

   /** return the same list without the last element */
    //the last element is eliminted
    //need almost two elements
    public LinkedList<E> beginning(){
        if(first == null){// esto tendria qe cambiarlo por un log de "list is empty"
            System.out.println("error: list is empty");
            return this;
        }else if(first == last){
            first = null;
            last = null;
            size--;
            return this;
        }
        last = last.previous;
        last.next = null;
        size--;
        return this;
    }
    /** delete the node */
    //Falta comprobar que el nodo exita eso es O(n) con n=size
    public void deleteNode(Nodo<E> node){
        if (node == null || first==null) {
            System.out.println("error: node cannot be null or list is empty");
            return;
        }
        if (node == first) {
            first = node.next;
        }
        if (node == last){last = node;}
        if (node.next!=null){//is not the last
            node.previous.next = node.next;
        }
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        size--;
    }

    /** get first value */
    public E firstValue(){
      return (first!=null)?this.first.value:null;
    }

    /** get last value */
    public E lastValue(){
        return (first!=null)?this.last.value:null;
    }
    /** get first node */
    public Nodo<E> firstNodo(){
        return (first!=null)?this.first:null;
    }
    /** get last node */
    public Nodo<E> lastNodo(){
        return (first!=null)?this.last:null;
    }
    /** return size of list*/
    public Long size(){
        return size;
    }

    /** print the doubly linked list: starting for "node"  */
    public void printlist(Nodo<E> node) {
        Nodo<E> aux = node;
        while(aux!=null){
            System.out.print(aux.value+"-> ");
            aux = aux.next;
        }
        System.out.println();
    }
    /** print all element in the list */
    public void printAll() {
        Nodo<E> aux = first;
        while(aux!=null){
            System.out.print(aux.value+"-> ");
            aux = aux.next;
        }
        System.out.println();
    }


}
