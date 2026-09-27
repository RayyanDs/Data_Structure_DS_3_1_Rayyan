package com.mycompany.dsa_assignment01_75531_rayyan;

class Portfolio {
    int[] quantities = new int[10];
    public void add(int index, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid Quantity!");
            return;
        }
        quantities[index] += quantity;
        System.out.println("Quantity Added!");
    }

    public double total(Asset[] assets, int index) {
        // Base Case
        if (index == assets.length) {
            return 0;
        }
        // Recursive Case
        return assets[index].price * quantities[index] + total(assets, index + 1);
    }

    public void display(Asset[] assets, int index) {
        // Base Case
        if (index == assets.length) {
            return;
        }
        if (quantities[index] > 0) {
            System.out.println(assets[index].name + " | Quantity: " + quantities[index] + " | Value: " + assets[index].price * quantities[index]);
        }
        // Recursive Case
        display(assets, index + 1);
    }
}