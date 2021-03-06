package ru.job4j.colection.tree;

import java.util.*;

public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;
    private Node<E> root;

    public Node(E value) {
        this.value = value;
    }
    public void add(Node<E> child) {
        this.children.add(child);
    }
    public List<Node<E>> leaves() {
        return this.children;
    }
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;
    }
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }

        } return rsl;
    }
}
