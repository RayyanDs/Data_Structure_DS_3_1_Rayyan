package com.mycompany.dsa_assignment01_75531_rayyan;

class Searching {
    public static int linearSearch(Asset[] assets, int id) {
        for (int i = 0; i < assets.length; i++) {
            if (assets[i].id == id) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Asset[] assets, int id) {
        int low = 0;
        int high = assets.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            System.out.println("Low: " + low + " High: " + high + " Mid: " + mid);
            if (assets[mid].id == id) {
                return mid;
            } else if (assets[mid].id < id) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
