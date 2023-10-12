package ex4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.*;

    class Persoana {
        private String name;
        private String cnp;

        public Persoana(String name, String cnp) {
            this.name = name;
            this.cnp = cnp;
        }

        public String getName() {
            return name;
        }

        public String getCnp() {
            return cnp;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCnp(String cnp) {
            this.cnp = cnp;
        }

        public int getAge() {
            int birthYear = Integer.parseInt(cnp.substring(1, 3));
            int birthMonth = Integer.parseInt(cnp.substring(3, 5));
            int birthDay = Integer.parseInt(cnp.substring(5, 7));

            LocalDate currentDate = LocalDate.now();

            int age = currentDate.getYear() - (birthYear + 1900);
            if (currentDate.getMonthValue() < birthMonth || (currentDate.getMonthValue() == birthMonth && currentDate.getDayOfMonth() < birthDay)) {
                age--;
            }

            return age;
        }

        public boolean isValidCnp() {
            if (cnp.length() != 13) {
                return false;
            }
            for (char digit : cnp.toCharArray()) {
                if (!Character.isDigit(digit)) {
                    return false;
                }
            }

            int firstDigit = Integer.parseInt(cnp.substring(0, 1));
            int birthYear = Integer.parseInt(cnp.substring(1, 3));

            // Check if the CNP is valid based on sex, birth year, and century
            if (!((firstDigit == 1 && birthYear >= 0 && birthYear <= 99) ||
                    (firstDigit == 2 && birthYear >= 0 && birthYear <= 99) ||
                    (firstDigit == 3 && birthYear >= 0 && birthYear <= 99) ||
                    (firstDigit == 4 && birthYear >= 0 && birthYear <= 99) ||
                    (firstDigit == 5 && birthYear >= 0 && birthYear <= 99) ||
                    (firstDigit == 6 && birthYear >= 0 && birthYear <= 99) ||
                    (firstDigit >= 7 && firstDigit <= 9))) {
                return false;
            }

            // You should implement CNP check digit validation here.
            return true;
        }
    }


    public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of people (n)
        System.out.print("Enter the number of people: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Persoana[] people = new Persoana[n];

        // Read and validate CNP for each person
        for (int i = 0; i < n; i++) {
            System.out.println("Persoana " + (i + 1) + ":");
            System.out.print("Enter name: ");
            String name = scanner.nextLine();
            String cnp;
            boolean isValidCnp;

            do {
                System.out.print("Enter CNP (13 digits): ");
                cnp = scanner.nextLine();
                Persoana tempPerson = new Persoana(name, cnp);
                isValidCnp = tempPerson.isValidCnp();

                if (!isValidCnp) {
                    System.out.println("Invalid CNP. Please enter a valid 13-digit CNP.");
                }
            } while (!isValidCnp);

            people[i] = new Persoana(name, cnp);
        }

        // Display information for each person
        System.out.println("\nName\t\tCNP\t\tAge");
        for (Persoana person : people) {
            System.out.println(person.getName() + "\t" + person.getCnp() + "\t" + person.getAge());
        }

        scanner.close();
    }
}
