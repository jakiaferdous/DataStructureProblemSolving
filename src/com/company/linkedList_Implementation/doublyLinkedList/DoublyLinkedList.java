package com.company.linkedList_Implementation.doublyLinkedList;

public class DoublyLinkedList {




    Node head;
    Node tail;
    int size;

    DoublyLinkedList() {
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmply() {
        return size == 0;
    }

    public void addFirst(int data) {

        if (isEmply()) {
            Node node = new Node(data, null, null);
            head = node;
            tail = node;
        } else {
            Node node = new Node(data, null, head);
            head.pre = node;
            head = node;
            if (tail == null) {
                tail = node;
            }
        }
        size++;

    }

    public void addLast(int data) {
        if (tail == null) {
            Node node = new Node(data, null, null);
            tail = node;
            head = node;
        } else {
            Node node = new Node(data, tail, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void insurtAtIndex(int data, int position) {

        if (position == 0) {
            addFirst(data);
            size++;
        } else if (position == size + 1) {
            addLast(data);
        } else if (position > size + 1) {
            return;
        } else {
            Node tmp = head;
            Node post = tmp.next;

            int i = 0;
            while (i < position - 1) {
                tmp = tmp.next;
                post = tmp.next;
                i++;
            }
            Node node = new Node(data, tmp, tmp.next);
            post.pre = node;
            tmp.next = node;
            if (node.next == null) {
                tail = node;
            }
        }

    }

    public void removeFirst() {

        if (isEmply()) {
            throw new NullPointerException();
        } else if (head.next == null) {
            head = null;
            tail = null;
            size --;

        } else {
            head = head.next;
            head.pre = null;
            size --;
        }
    }

    public void removeLast() {
        if (isEmply()) {
            throw new NullPointerException();
        } else if (head.next == null) {
            head = null;
            tail = null;
            size--;

        } else {
            tail = tail.pre;
            tail.next = null;
            size --;
        }

    }

    public void removeAtIndex(int index) {

        if (isEmply()) {
            throw new NullPointerException();
        } else if (index == 0) {
            removeFirst();
        } else if (index  == size -1) {
            removeLast();
        }else if(index == 1){
            Node tmp = head.next.next;
            head.next = tmp;
            tmp.pre = tmp.pre.pre;
            size --;
        }else if (index  == size || index> size ) {
            return;
        } else if(index < size -1) {
            int count = 0;
            Node tmp = head;
            while (count < index -1) {
                tmp = tmp.next;
                count++;
            }
            tmp.next = tmp.next.next;
            tmp.pre = tmp.pre.pre;
            size --;
        }

    }

    public void reverseIterative() {

        if(head == null){
            return;
        }
        if(head.next == null){
            return;
        }

        Node tmp = null;
        Node curr = head;
        while (curr != null){
            tmp = curr.pre;
            curr.pre = curr.next;
            curr.next = tmp;
            curr = curr.pre;
        }

        tail = head;
        head = tmp.pre;

    }


    public void iterateBackward() {

        System.out.println("iterating backword..");
        Node tmp = tail;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.pre;
        }
    }

    public void printData() {
        if (isEmply()) {
            return;
        } else {
            Node tmp = head;
            while (tmp != null) {
                System.out.print(tmp.data + " ");
                tmp = tmp.next;
            }
        }
    }

    public void printSize() {
        System.out.println("Size :" + size);
    }


    public void sortedInsert( int data) {

        Node node = new Node(data,null,null);

        //list is empty
        if(isEmply()){
            head = node;
            tail = node;
            size++;
        }

        //insert infront of list
        if(data <= head.data){
            node.next = head;
            head.pre = node;
            head = node;
            size++;
        }

        //Walk list with 2 pointers
        Node tmp2 = head;
        Node tmp = null;

        while(tmp2.data <= data && tmp2 != null){
            tmp = tmp2;
            tmp2 = tmp2.next;
        }
        // insert at the end of the list.
        if( tmp2 == null){
            tmp.next = node;
            node.pre = tmp;
            size++;
        }else {
            tmp.next = node;
            tmp2.pre = node;
            node.pre = tmp;
            node.next = tmp2;
            size++;
        }




    }

}

