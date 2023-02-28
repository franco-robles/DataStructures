package org.franco;

import org.franco.linkedList.DoublyLinkedList;
import org.franco.node.Node;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> lista= new DoublyLinkedList<>();

        lista.addEnd(1);
        lista.addEnd(2);
        lista.addEnd(3);
        lista.addEnd(4);
        lista.addEnd(5);
        lista.deleteNode(lista.firstNode().next.next);
        lista.beginning();
        lista.addAfter(lista.firstNode().next, 9);
        lista.addEnd(7);
        lista.addFront(4);
        lista.end();

        System.out.println(lista.isPresent(lista.firstNode().next));
        Node<Integer> noso = new Node<>(2);
        System.out.println(lista.isPresent(noso));
        Node<Integer> node = lista.firstNode();
        while(node !=null){
            System.out.print(node.value+"->next: ");
            node = node.next;
        }

        System.out.println("");
        Node<Integer> nodeLast = lista.lastNode();
        while(nodeLast !=null){
            System.out.print(nodeLast.value+"->prev: ");
            nodeLast = nodeLast.previous;
        }

    }
}