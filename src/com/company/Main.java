package com.company;

import java.util.Scanner;

public class Main {

    public static void sort (int[] x){
        sort(x, 0, x.length - 1);
    }

    private static void sort (int[] x, int start, int end){
        if (start < end) {
            int middle = start + (end - start) / 2; //Found the middle point of array
            sort(x, start, middle); //There sorted first and second halves of array
            sort(x, middle + 1, end);
            merge(x, start, end, middle); //Then merged the sorted halves
        }
    }
    public static void merge (int[] x, int start, int end, int middle){
        //Found sizes of halves of array
        int size1 = middle - start + 1;
        int size2 = end - middle;
        int[] a = new int[size1];
        int[] b = new int [size2];

        //Filled two parts of array
        for(int j = 0; j < size1; j++){
            a[j] = x[start+j];
        }
        for(int j = 0; j < size2; j++){
            b[j] = x[middle+1+j];
        }

        int i = 0, j = 0;
        //Initial index of merged array
        int k = start;

        //Merge array
        while(i < size1 && j < size2){
            if(a[i] <= b[j]){
                x[k] = a[i];
                i++;
            }
            else{
                x[k] = b[j];
                j++;
            }
            k++;
        }

        while(i < size1){ //Copy remaining elements of a[]
            x[k] = a[i];
            i++;
            k++;
        }
        while(j < size2){ //Copy remaining elements of b[]
            x[k] = b[j];
            j++;
            k++;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //n is size of array
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scanner.nextInt(); //Input array
        }
        sort(arr); //Called our method
        for (int i = 0; i < arr.length; i++){ //Output the result
            System.out.print(arr[i] + " ");
        }



    }
}
