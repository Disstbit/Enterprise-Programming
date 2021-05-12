package com.company;

import java.math.BigInteger;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        //Задание 1
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество чисел");
        String input = "123456789";
        int n = 0;
        n = scan.nextInt();
        int arr[];
        arr = new int[n];
        System.out.println("Введите " + n  + " числа");
        for (int i = 0; i < n; i++ ){
            arr[i] = scan.nextInt();
        }
        for (int i: arr){
            boolean result = input.matches(".*"+i+".*");
            if(result){
                System.out.println(i);
            }
        }

        //Задание 2
        System.out.println("Введите число которое хотите перевести");
        BigInteger number = scan.nextBigInteger();
        System.out.println("Введите систему счисления");
        int osn = scan.nextInt();
        String s = number.toString(osn);
        System.out.println(s);

        //Задание 3
        double [][] mat4 = {
                {1.0,1.0,-1.0,-1.0},
                {2.0,1.0,2.0,3.0},
                {3.0,4.0,5.0,6.0},
                {5.0,7.0,8.0,9.0}
        };

        class Determin {
            private double summ;

            public Determin(double[][] matrix) {
                getReduction(matrix, 1);
            }


            public void getValue() {
                System.out.printf("%.2f", this.summ);
                System.out.println("");

            }


            private void getReduction(double [][] subMinor, double elemParentMinor) {
                if (subMinor.length > 1){
                    double [][] tmpMinor = new double[subMinor.length - 1][subMinor[0].length - 1];
                    for (int c = 0; c < subMinor[0].length; c++) {
                        for (int i = 1; i < subMinor.length; i++) {
                            for (int j = 0; j < subMinor[0].length; j++) {
                                if (j < c)
                                    tmpMinor[i - 1][j] = subMinor[i][j];
                                else if (j > c)
                                    tmpMinor[i - 1][j - 1] = subMinor[i][j];
                            }
                        }
                        double paramForSub = Math.pow(-1,c+2)*subMinor[0][c]*elemParentMinor;
                        getReduction(tmpMinor, paramForSub);
                    }
                }
                else
                    this.summ += elemParentMinor * subMinor[0][0];
            }

        }
        System.out.println("Определитель равен:");
        Determin dd = new Determin(mat4);
        dd.getValue();
    }
}
