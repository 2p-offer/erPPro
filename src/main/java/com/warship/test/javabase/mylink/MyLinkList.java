package com.warship.test.javabase.mylink;

import java.io.Serializable;
import java.util.*;

public class MyLinkList<T> extends AbstractSequentialList<T> implements List<T>, Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private int size;

    Node head;

    Node last;

    T item;

    MyLinkList() {
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    private static class Node<E> {

        Node(Node prev, Node next, E value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }

        Node next;

        Node prev;

        E value;
    }


    public boolean add(T value) {
        Node oldLast = this.last;
        Node currentNode = new Node(this.last, null, value);
        if (oldLast == null) {
            this.head = currentNode;
        } else {
            oldLast.next = currentNode;
        }
        this.last = currentNode;
        this.size++;
        return true;
    }

    public boolean remove(Object value) {
        if (value == null) {
            for (Node node = this.head; node != null; node = node.next) {
                if (node.value == null) {
                    unlink(node);
                    return true;
                }
            }
        }

        for (Node node = this.head; node != null; node = node.next) {
            if (node.value.equals(value)) {
                unlink(node);
                return true;
            }
        }
        return false;
    }

    private void unlink(Node node) {
        Node preNode = node.prev;
        Node nextNode = node.next;
        if (preNode == null) {
            this.head = nextNode;
        } else {
            preNode.next = nextNode;
            node.prev = null;
        }

        if (nextNode == null) {
            this.last = preNode;
        } else {
            nextNode.prev = preNode;
            node.next = null;
        }
        node.value = null;
        this.size--;
    }

    public T getFirst() {
        if (this.head == null) {
            throw new NoSuchElementException();
        }
        MyLinkList.Node<T> tmpHead = this.head;
        return tmpHead.value;
    }

    public T getLast() {
        if (this.last == null) {
            throw new NoSuchElementException();
        }
        MyLinkList.Node<T> tmpLast = this.last;
        return tmpLast.value;
    }

    public static void main(String[] args) {
//        List<String> list = new LinkedList<>();
//        list.add("123");
//        list.add(null);
//        list.add("222");
//        System.out.println(list);
//        list.remove("222");
//        System.out.println(list);
//        List<String> myList = new MyLinkList<>();
//        myList.add("123");
//        myList.add("222");
//        myList.add(null);
//        myList.add("333");

        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());
    }
}
