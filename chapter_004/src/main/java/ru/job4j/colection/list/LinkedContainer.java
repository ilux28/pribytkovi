package ru.job4j.colection.list;


public class LinkedContainer {
    private static class Node<E> {
        Node<E> prev;
        Node<E> next;
        E value;
        Node(Node prev, Node next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
        public void add(Node node) {

            Node header = new Node(prev, prev, value);

            Node newNode = new Node(header, next, "0");

        }
    }

}
