package ex2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

class Verse {
    private String line;

    public Verse(String line) {
        this.line = line;
    }

    public int wordCount() {
        String[] words = line.split("\\s+");
        return words.length;
    }

    public int vowelCount() {
        int count = 0;
        for (char c : line.toLowerCase().toCharArray()) {
            if ("aeiou".contains(String.valueOf(c))) {
                count++;
            }
        }
        return count;
    }

    public boolean endsWith(String suffix) {
        return line.trim().toLowerCase().endsWith(suffix.toLowerCase());
    }

    public String capitalize() {
        return line.toUpperCase();
    }

    public String toString() {
        return line;
    }
}

public class MainApp {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/ex2/cantec_in.txt");
            File outputFile = new File("src/ex2/cantec_out.txt");
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));


            String line;
            Random random = new Random();

            while ((line = reader.readLine()) != null) {
                Verse verse = new Verse(line);


                writer.write(verse + " (Cuvinte: " + verse.wordCount() + ", Vocale: " + verse.vowelCount() + ")");


                if (verse.endsWith("night")) {
                    writer.write(" *");
                }


                if (random.nextDouble() < 0.1) {
                    writer.write("\n" + verse.capitalize());
                }

                writer.newLine();
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
