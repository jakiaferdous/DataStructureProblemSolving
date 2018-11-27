package com.company.linkedList_Implementation.singlyLinkedList;

public class SinglyLinkedList {


    Node head;
    int count = 0;

    public boolean isEmpty() {
        return head == null;
    }

    public void insertNodeFirst(int data) {
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            count++;
        } else {
            node.next = head;
            head = node;
            count++;
        }
    }

    public void insertNodeLast(int data) {

        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            count++;
        } else {
            Node tmp = head;
            while (tmp.next != null) {
                tmp = tmp.next;

            }
            tmp.next = node;
            node.next = null;
            count++;
        }
    }

    public void insertAtIndex(int data, int index) {

        if (index > count) {
            System.out.println("index number is bigger than the size of the linkedlist.");
            return;
        }
        Node node = new Node(data);
        if (isEmpty()) {
            head = node;
            count++;
        } else {
            if (index == 0) {
                node.next = head;
                head = node;
                count++;
            } else {
                Node tmp = head;
                int i = 0;
                while (i < index - 1) {
                    tmp = tmp.next;
                    i++;
                }
                Node postPointer = tmp.next;
                tmp.next = node;
                node.next = postPointer;
                count++;
            }

        }
    }

    public void totalNodes() {
        System.out.println("Total nodes: " + count);
    }

    public void printData() {

        if (isEmpty()) {
            System.out.println("List is Emplt");
        } else {
            Node tmp = head;
            System.out.println(tmp.data);
            while (tmp.next != null) {
                tmp = tmp.next;
                System.out.println(tmp.data);
            }
        }
    }

    public void removeFirstNode() {

        if (isEmpty()) {
            System.out.println("Empty");
        } else {
            head = head.next;
            count--;
        }

    }

    public void removeLastNode() {
        if (isEmpty()) {
            System.out.println("Empty");
        } else {

            Node preNode = head;
            Node lastNode = preNode.next;
            while (lastNode.next != null) {
                preNode = preNode.next;
                lastNode = lastNode.next;
            }
            preNode.next = null;
            count--;
        }
    }

    public void removeAtIndex(int index) {
        if (isEmpty()) {
            System.out.println("Empty.");
            return;
        } else if (index > count) {
            System.out.println("index number is bigger than the size of the linkedlist.");
            return;
        } else {
            Node preNode = head;
            Node postNode = preNode.next;
            for (int i = 0; i < index - 1; i++) {
                preNode = preNode.next;
                postNode = postNode.next;
            }
            preNode.next = postNode.next;
            count--;
        }


    }

    public boolean isDataExists(int data) {

        if (isEmpty()) {
            System.out.println("List is empty.");
        } else {
            Node tmp = head;

            while (tmp.next != null) {
                if (tmp.data == data) {
                    return true;
                }
                tmp = tmp.next;
            }
            if (tmp.data == data) {
                return true;
            }
        }
        return false;
    }

    //soting a list

    public static void reverseList(Node head) {

        Node curr = head;
        Node pre = null;

        while (curr != null) {
            Node post = curr.next;
            pre = curr;
            curr = curr.next;
            post.next = pre;

        }

    }

    public void reverseIterative() {

        Node curr = head;
        Node pre = null;
        Node post = null;

        while (curr != null) {

            post = curr.next;
            curr.next = pre;
            pre = curr;
            curr = post;
        }
        head = pre;
    }

    public void reverseIterative1() {
        Node currNode = head;
        Node nextNode = null;
        Node prevNode = null;

        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;

    }

    //compare two linked list.
    public boolean compareLists(Node head1, Node head2) {

        if (head1 == null && head2 == null) {
            return true;
        } else {
            while (head1 != null && head2 != null) {

                if (head1.data != head2.data) {
                    return false;
                }
                head1 = head1.next;
                head2 = head2.next;
            }
            if (head1 == null && head2 == null) {
                return true;
            }
        }
        return false;

    }

    //merge two sorted array.
    public static Node mergeLists(Node head1, Node head2) {


        if (head1.next == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        } else {
            Node head = null;
            Node dummy = new Node(0);
            head = dummy;
            while (head1 != null && head2 != null) {

                if (head1.data < head2.data) {
                    dummy.next = head1;
                    head1 = head1.next;
                    dummy = dummy.next;
                } else {
                    dummy.next = head2;
                    head2 = head2.next;
                    dummy = dummy.next;
                }
            }
            if (head1 != null) {
                dummy.next = head1;
            }
            if (head2 != null) {
                dummy.next = head2;
            }

            return head.next;
        }

    }






}







