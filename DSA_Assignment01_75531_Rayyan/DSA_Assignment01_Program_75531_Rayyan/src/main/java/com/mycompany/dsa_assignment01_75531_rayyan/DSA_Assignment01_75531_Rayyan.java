
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.dsa_assignment01_75531_rayyan;

import java.util.Scanner;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class DSA_Assignment01_75531_Rayyan {

    static Scanner sc = new Scanner(System.in);

    static Asset[] assets = {
        new Asset(101, "Apple", "Stock", 190, 1.5),
        new Asset(102, "Bitcoin", "Crypto", 65000, -2.1),
        new Asset(103, "Gold", "Commodity", 2300, 0.8),
        new Asset(104, "Microsoft", "Stock", 420, 1.2),
        new Asset(105, "Ethereum", "Crypto", 3400, -0.5),
        new Asset(106, "Silver", "Commodity", 29, 0.3),
        new Asset(107, "Tesla", "Stock", 175, -1.7),
        new Asset(108, "Google", "Stock", 170, 0.9),
        new Asset(109, "Amazon", "Stock", 185, 1.1),
        new Asset(110, "Oil", "Commodity", 80, -0.4)
    };
    static Watchlist watchlist = new Watchlist();
    static Portfolio portfolio = new Portfolio();
    static Stack stack = new Stack();
    static Queue queue = new Queue();
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        int choice;
        do {
            System.out.println("\n******** FINTECH TRADING MANAGEMENT SYSTEM ********");
            System.out.println("1. Manage Market Assets");
            System.out.println("2. Search Asset");
            System.out.println("3. Sort Market Assets");
            System.out.println("4. Manage Watchlist");
            System.out.println("5. Calculate Portfolio Value");
            System.out.println("6. Manage Transactions");
            System.out.println("7. Manage Trading Orders");
            System.out.println("0. Exit");
            choice = input("Enter your choice: ");
            switch (choice) {
                case 1:
                    manageAssets();
                    break;
                case 2:
                    searchAsset();
                    break;
                case 3:
                    sortAssets();
                    break;
                case 4:
                    manageWatchlist();
                    break;
                case 5:
                    managePortfolio();
                    break;
                case 6:
                    manageTransactions();
                    break;
                case 7:
                    manageOrders();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }

    public static int input(String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            System.out.println("Enter a number!");
            sc.next();
            System.out.print(message);
        }
        return sc.nextInt();
    }

    // market assets

    public static void manageAssets() {
        int choice;
        do {
            System.out.println("\n******** MARKET ASSETS ********");
            System.out.println("1. Display All Assets");
            System.out.println("2. Average Price");
            System.out.println("3. Highest Price");
            System.out.println("4. Lowest Price");
            System.out.println("0. Back");

            choice = input("Enter your choice: ");
            switch (choice) {
                case 1:
                    for (int i = 0; i < assets.length; i++) {
                        assets[i].display();
                    }
                    break;

                case 2:
                    double sum = 0;
                    for (int i = 0; i < assets.length; i++) {
                        sum += assets[i].price;
                    }
                    System.out.println("Average Price: " + sum / assets.length);
                    break;

                case 3:
                    Asset highest = assets[0];
                    for (int i = 1; i < assets.length; i++) {
                        if (assets[i].price > highest.price) {
                            highest = assets[i];
                        }
                    }
                    System.out.println("Highest Priced Asset:");
                    highest.display();
                    break;
                case 4:
                    Asset lowest = assets[0];
                    for (int i = 1; i < assets.length; i++) {
                        if (assets[i].price < lowest.price) {
                            lowest = assets[i];
                        }
                    }
                    System.out.println("Lowest Priced Asset:");
                    lowest.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);
    }

    // SEARCHING 

    public static void searchAsset() {
        int choice;
        do {
            System.out.println("\n******** SEARCH ********");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("0. Back");
            choice = input("Enter your choice: ");
            if (choice == 1 || choice == 2) {
                int id = input("Enter Asset ID: ");
                int index;
                if (choice == 1) {
                    index = Searching.linearSearch(assets, id);
                } else {
                    index = Searching.binarySearch(assets, id);
                }
                if (index == -1) {
                    System.out.println("Asset Not Found!");
                } else {
                    System.out.println("Asset Found:");
                    assets[index].display();
                }
            } else if (choice != 0) {
                System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }

    // this is my soritng 

    public static void sortAssets() {
        int choice;
        do {
            System.out.println("\n******** SORTING BY PRICE ********");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("0. Back");
            
            choice= input("Enter your choice: ");
            if (choice >= 1 && choice <= 5) {
                Asset[] arr = assets.clone();
                switch (choice) {
                    case 1:
                        Sorting.bubbleSort(arr);
                        break;
                    case 2:
                        Sorting.selectionSort(arr);
                        break;
                    case 3:
                        Sorting.insertionSort(arr);
                        break;
                    case 4:
                        Sorting.mergeSort(arr, 0, arr.length - 1);
                        break;
                    case 5:
                        Sorting.quickSort(arr, 0, arr.length - 1);
                        break;
                }
                System.out.println("\nSorted Assets:");
                for (int i = 0; i < arr.length; i++) {
                    arr[i].display();
                }
            } else if (choice != 0) {
                System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }

    // this is my linked list 

    public static void manageWatchlist() {

        int choice;

        do {
            System.out.println("\n******** WATCHLIST ********");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Search");
            System.out.println("4. Display");
            System.out.println("0. Back");

            choice = input("Enter your choice: ");
            switch (choice) {
                case 1:
                    int id = input("Enter Asset ID: ");
                    int index = Searching.linearSearch(assets, id);
                    if (index == -1) {
                        System.out.println("Asset Not Found!");
                    } else {
                        watchlist.insert(assets[index]);
                    }
                    break;
                case 2:
                    watchlist.delete(input("Enter Asset ID: "));
                    break;
                case 3:
                    watchlist.search(input("Enter Asset ID: "));
                    break;
                case 4:
                    watchlist.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }

    // this is recursion

    public static void managePortfolio() {
        int choice;
        do {
            System.out.println("\n******** PORTFOLIO ********");
            System.out.println("1. Add Asset Quantity");
            System.out.println("2. Calculate Total Value");
            System.out.println("3. Display Portfolio");
            System.out.println("0. Back");

            choice = input("Enter your choice: ");
            switch (choice) {
                case 1:
                    int id = input("Enter Asset ID: ");
                    int index = Searching.linearSearch(assets, id);
                    if (index == -1) {
                        System.out.println("Asset Not Found!");
                    } else {
                        int qty = input("Enter Quantity: ");
                        portfolio.add(index, qty);
                    }
                    break;
                case 2:
                    System.out.println("Total Portfolio Value: " + portfolio.total(assets, 0));
                    break;
                case 3:
                    portfolio.display(assets, 0);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }

    // STACK

    public static void manageTransactions() {
        int choice;
        do {
            System.out.println("\n******** TRANSACTIONS (STACK) ********");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Back");

            choice = input("Enter your choice: ");
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Transaction: ");
                    stack.push(sc.nextLine());
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }

    //  QUEUE

    public static void manageOrders() {
        int choice;
        do {
            System.out.println("\n******** TRADING ORDERS (QUEUE) ********");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("0. Back");

            choice = input("Enter your choice: ");
            switch (choice) {
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Trading Order: ");
                    queue.enqueue(sc.nextLine());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.peek();
                    break;
                case 4:
                    queue.display();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (choice != 0);
    }
}