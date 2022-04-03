package com.dz;

public class Two {

    public static void main(String[] args) {

        // 2) Создайте двумерный массив, в котором найдите минимальный элемент среди всех элементов массива.
        // Важно учесть, что нахождение минимального массива должен производиться при помощи циклов. Массив:
        int[][] x = { {20, 34, 2}, {9, 12, 18}, {3, 4, 5} };

        int min=999;
        for (int i=0; i<x.length; i++){
            for(int j=0; j<x[i].length; j++){
                if(x[i][j]<min){
                    min=x[i][j];
                }
            }
        }
        System.out.println(min); // 2

    }

}
