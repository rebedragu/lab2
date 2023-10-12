package ex1;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {

            File file = new File("src/ex1/judete_in.txt");
            Scanner scanner = new Scanner(file);
            ArrayList<String> countiesList = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String county = scanner.nextLine();
                countiesList.add(county);
            }
            scanner.close();


            String[] countiesArray = countiesList.toArray(new String[0]);
            Arrays.sort(countiesArray);

            Scanner keyboard = new Scanner(System.in);
            System.out.print("Introdu judet: ");
            String searchCounty = keyboard.nextLine();


            int position = Arrays.binarySearch(countiesArray, searchCounty);


            if (position >= 0) {
                System.out.println("Judetul a fost gasit: " + (position + 1));
            } else {
                System.out.println("Judetul nu a fost gasit.");
            }

            keyboard.close();
        } catch (FileNotFoundException e) {
            System.out.println("Fisierul nu exista: " + e.getMessage());
        }

    }
}