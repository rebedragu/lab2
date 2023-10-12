package ex3;

import java.io.*;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introdu sir: ");
        String sir = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder(sir);


        System.out.print("Introdu pozitia unde inseram: ");
        int insertPosition = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introdu sirul pe care il inseram: ");
        String toInsert = scanner.nextLine();


        if (insertPosition >= 0 && insertPosition <= stringBuilder.length())
        {
            stringBuilder.insert(insertPosition, toInsert);
            System.out.println("Sirul dupa inserare: " + stringBuilder.toString());
        } else {
            System.out.println("Nu se poate insera!");
        }

        System.out.print("Introdu poz de unde incepe stergerea: ");
        int deleteStart = scanner.nextInt();

        System.out.print("Introdu nr de caractere pe care le vom sterge: ");
        int deleteLength = scanner.nextInt();

        if (deleteStart >= 0 && deleteLength >= 0 && deleteStart + deleteLength <= stringBuilder.length()) {
            stringBuilder.delete(deleteStart, deleteStart + deleteLength);
        } else {
            System.out.println("Nu se poate sterge!");
        }


        System.out.println("Sirul modificat: " + stringBuilder.toString());

        scanner.close();
    }

    }

