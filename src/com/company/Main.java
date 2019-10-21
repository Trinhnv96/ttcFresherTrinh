package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<Bill> listBill = new ArrayList<>();
        int selectExercise;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("\nSelect exercise :");
            System.out.println("\n1.Exercise 1 \n2.Exercise 2 \n3.Exercise 3 \n4.Exercise 4 \n5.Exercise 5 \n0.Stop select");
            selectExercise = sc.nextInt();

            if (selectExercise == 1) {
                int stn = 0, sum = 0;
                main.input(stn, sum);
            }

            if (selectExercise == 2) {
                int n = 0;
                main.inputList(n);
            }

            if (selectExercise == 3) {
                main.addData(listBill);
                main.showListBill(listBill);
                main.sortBill(listBill);
            }

            if (selectExercise == 4) {
                main.addData(listBill);
                main.distinctDate(listBill);
            }

            if (selectExercise == 5) {
                main.addData(listBill);
                main.showListBillMillion(listBill);
            }

            if (selectExercise == 0) System.exit(selectExercise);
        }
    }

    //Bài 1
    public void input(int stn, int sum) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter the natural number n :");
        stn = scanner.nextInt();
        System.out.printf("\nThe sequence of natural numbers is:");
        for (int i = 0; i <= stn; i++) {
            System.out.print(i + " ");
        }
        for (int i = 0; i <= stn; i++) {
            sum += i;
        }
        System.out.print("\nThe sum of n consecutive natural numbers:" + sum);
    }

    //Bài 2
    public void inputList(int n) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter the number of elements in the array :");
            n = scanner.nextInt();
        } while (n < 0);
        List<Integer> listInt = new ArrayList<>();
        System.out.print("\nEnter the elements in the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("\nEnter the elements for the array " + i + ":");
            listInt.add(scanner.nextInt());
        }

        System.out.print("\nThe array just entered is :");
        for (int i = 0; i < listInt.size(); i++) {
            System.out.print(listInt.get(i) + " ");
        }
        System.out.print("\nArray after sort is:");
        Collections.sort(listInt);
        System.out.print(listInt);
    }

    //Bài 3
    public void addData(List<Bill> listBill) {
        listBill.clear();
        listBill.add(new Bill(303, "HD1", 3600000, "2019-08-12"));
        listBill.add(new Bill(112, "HD2", 5000, "2019-09-21"));
        listBill.add(new Bill(105, "HD3", 45000, "2019-01-21"));
        listBill.add(new Bill(132, "HD4", 5000000, "2019-09-21"));
        listBill.add(new Bill(125, "HD5", 45000, "2019-01-21"));
        listBill.add(new Bill(122, "HD6", 1000000, "2019-01-21"));
    }

    public void showListBill(List<Bill> listBill) {
        System.out.print("Original bill list :");
        for (int i = 0; i < listBill.size(); i++) {
            System.out.print("\n" + "Bill " + i + ":");
            System.out.print("\nID: " + listBill.get(i).id + "\nName: " + listBill.get(i).name +
                    "\nMoney: " + listBill.get(i).money + "\nDate: " + listBill.get(i).date);
            System.out.print("\n=======================");
        }
    }

    public void sortBill(List<Bill> listBill) {
        long temp = 0;
        for (int i = 0; i < listBill.size(); i++) {
            for (int j = i + 1; j < listBill.size(); j++) {
                if (listBill.get(i).money > listBill.get(j).money) {
                    temp = listBill.get(i).money;
                    listBill.get(i).money = listBill.get(j).money;
                    listBill.get(j).money = temp;
                }
            }
        }

        System.out.print("\nInvoice after arrangement is :");
        for (int i = 0; i < listBill.size(); i++) {
            System.out.print("\n" + "Bill " + i + ":");
            System.out.print("\nID: " + listBill.get(i).id + "\nName: " + listBill.get(i).name +
                    "\nMoney: " + listBill.get(i).money + "\nDate: " + listBill.get(i).date);
            System.out.print("\n=======================");
        }
    }

    //Bài 4
    public void distinctDate(List<Bill> listBill) {
        System.out.print("\nList after listing duplicates");
        List<String> listDate = new ArrayList<>();
        for (int i = 0; i < listBill.size(); i++) {
            listDate.add(listBill.get(i).date);
        }
        List<String> listDistinctDate = listDate
                .stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(listDistinctDate);
    }

    //Bài 5
    public void showListBillMillion(List<Bill> listBill) {
        for (int i = 0; i < listBill.size(); i++) {
            if (listBill.get(i).money > 1000000) {
                System.out.print("\nID: " + listBill.get(i).id + "\nName: " + listBill.get(i).name +
                        "\nMoney: " + listBill.get(i).money + "\nDate: " + listBill.get(i).date);
                System.out.print("\n=======================");
            }
        }
    }
    //Bài 6
    
}
