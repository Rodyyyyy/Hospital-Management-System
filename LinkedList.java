package com.example;

public class LinkedList<type> {
    int size;
    Node<type> head;

    public LinkedList() {
        this.size = 0;
    }

    public void insert(Node<type> node, int position) {
        if (position < 1 || position > size + 1) { 
            System.out.println("Invalid position. Enter a position between 1 and " + (size + 1));
            return;
        }

        if (position == 1 || head == null) {
            insertFirst(node);
        } else if (position == size + 1) {
            insertLast(node);
        } else {
            Node<type> temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
            }

            Node<type> newNode = new Node<type>(node.data); 
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    }

    public void insertFirst(Node<type> node) {
        Node<type> newNode = new Node<>(node.data); 
        newNode.next = head; 
        head = newNode; 
        size++;
    }

    public void insertLast(Node<type> node) {
        if (head == null) {
            insertFirst(node); 
        } else {
            Node<type> temp = head;
            while (temp.next != null) { 
                temp = temp.next;
            }
            Node<type> newNode = new Node<>(node.data); 
            temp.next = newNode;
            size++;
        }
    }
    

    public Node<type> delete(int position) {
        if (position < 1 || position > size) {
            System.out.println("Invalid position. Enter a position between 1 and " + size);
            return null;
        }

        if (position == 1) {
            return deleteStart();
        }
        if (position == size) {
            return deleteLast();
        }

        Node<type> temp = head;
        for (int i = 1; i < position - 1; i++) {
            temp = temp.next;
        }

        Node<type> deletedNode = temp.next;
        temp.next = temp.next.next; 
        size--;
        return deletedNode;
    }

    public Node<type> deleteStart() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return null;
        }

        Node<type> deletedNode = head;
        head = head.next; 
        size--;
        return deletedNode;
    }

    public Node<type> deleteLast() {
        if (head == null) {
            System.out.println("Linked list is empty.");
            return null;
        }
        if (head.next == null) { 
            return deleteStart();
        }

        Node<type> temp = head;
        while (temp.next.next != null) { 
            temp = temp.next;
        }

        Node<type> deletedNode = temp.next;
        temp.next = null; 
        size--;
        return deletedNode;
    }

    public Node<type> search(type data) { 
        Node<type> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                return temp;
            }
            temp = temp.next;
        }
        return null; 
    }

    public type getValue(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<type> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data; 
    }
    public void printList() {
        Node<type> temp = head;
        while (temp != null) {
            System.out.println(temp.data); 
            temp = temp.next;
        }
    }
}
