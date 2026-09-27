package com.mycompany.dsa_assignment01_75531_rayyan;

class Asset {
    int id;
    String name, type;
    double price, change;
    Asset(int id, String name, String type, double price, double change) {
        this.id=id;
        this.name=name;
        this.type=type;
        this.price=price;
        this.change=change;
    }
    void display() {
        System.out.println(id + " | " + name + " | " + type + " | " + price + " | " + change + "%");
    }
}
