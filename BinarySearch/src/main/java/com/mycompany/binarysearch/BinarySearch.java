/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.binarysearch;
import java.util.Scanner;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class BinarySearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target, int l, int r) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target > arr[mid]) {
                return binarySearch(arr, target, mid + 1, r);
            } else {
                return binarySearch(arr, target, l, mid - 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] linearArray = {45, 12, 78, 34, 23, 89, 56};
        int[] binaryArray = {12, 23, 34, 45, 56, 78, 89}; 

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a value to search: ");
        int target = sc.nextInt();

        int linearResult = linearSearch(linearArray, target);
        int binaryResult = binarySearch(binaryArray, target, 0, binaryArray.length - 1);

        System.out.println("Target value: " + target);
        if (linearResult != -1) {
            System.out.println("Linear Search is found at index " + linearResult);
        } else {
            System.out.println("Linear Search is not found");
        }

        if (binaryResult != -1) {
            System.out.println("Binary Search is found at index " + binaryResult);
        } else {
            System.out.println("Binary Search is not found");
        }
    }
}
