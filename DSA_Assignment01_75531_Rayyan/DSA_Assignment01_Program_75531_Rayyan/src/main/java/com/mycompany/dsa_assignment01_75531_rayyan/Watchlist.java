package com.mycompany.dsa_assignment01_75531_rayyan;

class Watchlist {
    class Node {
        Asset data;
        Node next;
        Node(Asset data) {
            this.data = data;
        }
    }
    Node head;
    public void insert(Asset asset) {
        if (head == null) {
            head = new Node(asset);
            System.out.println("Asset Added!");
            return;
        }
        Node temp = head;
        while (true) {
            if (temp.data.id == asset.id) {
                System.out.println("Already in Watchlist!");
                return;
            }
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = new Node(asset);
        System.out.println("Asset Added!");
    }

    public void delete(int id) {
        if (head == null) {
            System.out.println("Watchlist Empty!");
            return;
        }
        if (head.data.id == id) {
            head = head.next;
            System.out.println("Asset Deleted!");
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data.id == id) {
                temp.next = temp.next.next;
                System.out.println("Asset Deleted!");
                return;
            }

            temp = temp.next;
        }

        System.out.println("Asset Not Found!");
    }

    public void search(int id) {

        Node temp = head;

        while (temp != null) {

            if (temp.data.id == id) {
                temp.data.display();
                return;
            }

            temp = temp.next;
        }

        System.out.println("Asset Not Found!");
    }

    public void display() {

        if (head == null) {
            System.out.println("Watchlist Empty!");
            return;
        }

        Node temp = head;

        while (temp != null) {
            temp.data.display();
            temp = temp.next;
        }
    }
}