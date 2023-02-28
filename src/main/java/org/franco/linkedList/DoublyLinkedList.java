package org.franco.linkedList;


import org.franco.node.Node;

public class DoublyLinkedList<E> {
    //attributes
    private Node<E> first;
    private Node<E> last;
    private Long size;

    //constructor
    public DoublyLinkedList(){
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
        Node<E> node = new Node<E>(value);
        node.previous = last;
        if(last==null){
            first = node;
        }else {
            last.next = node;
        }
        last = node;
        size++;
    }

    //Insertion at the beginning
    public void addFront(E value){
        //"beginning" is where the X is  X->b->c->d->
        Node<E> node = new Node<E>(value);
        node.next = first;
        if(first==null){
            last = node;
        }else {
            first.previous = node;
        }
        first = node;
        size++;
    }

    /**  Insertion in-between nodes
     */
    //the prevNode has to exist on the list: i need check this
    public void addAfter(Node<E> prevNode, E value){
         if(prevNode ==null) {
            System.out.println("error: node cannot be null");
            return;
        }
        if(this.isPresent(prevNode)){
            Node<E> newNode = new Node<E>(value);
            newNode.next = prevNode.next;
            newNode.previous = prevNode;
            prevNode.next = newNode;
            if (newNode.next != null) {
                (newNode.next).previous = newNode;
            } else {
                last = newNode;
            }
            size++;
        }
    }


    //return the same list without the first element
    //the first element is eliminted
    public DoublyLinkedList<E> end(){
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
    public DoublyLinkedList<E> beginning(){
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
    public void deleteNode(Node<E> node){
        if (node == null || first==null) {
            System.out.println("error: node cannot be null or list is empty");
            return;
        }
        if(this.isPresent(node)){
            if (node == first) {
                first = node.next;
            }
            if (node == last) {
                last = node.previous;
            }

            if (node.next != null) {//is not the last
                node.previous.next = node.next;
            }
            if (node.previous != null) {
                node.previous.next = node.next;
            }
            size--;
        }
    }

    /** return true if node is present in the list, false otherwase : Complexity O(n)*/
    public boolean isPresent(Node<E> node){
        Node<E> aux= first;
        boolean found = false;
        while(!found && aux!=null ){
            if (aux == node) {
                found = true;
            }else {
                aux = aux.next;
            }
        }
        return found;
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
    public Node<E> firstNode(){
        return (first!=null)?this.first:null;
    }
    /** get last node */
    public Node<E> lastNode(){
        return (first!=null)?this.last:null;
    }
    /** return size of list*/
    public Long size(){
        return size;
    }

    /** print the doubly linked list: starting for "node"  */
    public void printlist(Node<E> node) {
        Node<E> aux = node;
        while(aux!=null){
            System.out.print(aux.value+"-> ");
            aux = aux.next;
        }
        System.out.println();
    }
    /** print all element in the list */
    public void printAll() {
        Node<E> aux = first;
        while(aux!=null){
            System.out.print(aux.value+"-> ");
            aux = aux.next;
        }
        System.out.println();
    }

}
