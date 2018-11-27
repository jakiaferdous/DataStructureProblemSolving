package com.company.linkedList_Implementation.doublyLinkedList;

public class Node {

    int data;
    public Node pre;
    public Node next;

    Node(int data, Node pre, Node next) {
        this.data = data;
        this.pre = pre;
        this.next = next;
    }
}

