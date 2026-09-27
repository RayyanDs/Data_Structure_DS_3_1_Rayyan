package com.mycompany.dsa_assignment01_75531_rayyan;

class Sorting {
    public static void bubbleSort(Asset[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].price > arr[j + 1].price) {
                    Asset temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void selectionSort(Asset[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].price < arr[min].price) {
                    min = j;
                }
            }
            Asset temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void insertionSort(Asset[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Asset current = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev].price > current.price) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = current;
        }
    }

    public static void mergeSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(Asset[] arr, int low, int mid, int high) {
        Asset[] temp = new Asset[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= high) {
            if (arr[i].price <= arr[j].price) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }

        while (j <= high) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (int x = 0; x < temp.length; x++) {
            arr[low + x] = temp[x];
        }
    }

    public static void quickSort(Asset[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(Asset[] arr, int low, int high) {
        double pivot = arr[high].price;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].price <= pivot) {
                i++;
                Asset temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Asset temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
