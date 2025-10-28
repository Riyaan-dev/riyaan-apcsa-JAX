package piglatin;

import java.io.*;
import java.net.*;
import java.util.*;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<>();

    Book() {}

    String getTitle() { return title; }
    void setTitle(String title) { this.title = title; }
    String getLine(int i) { return text.get(i); }
    int getLineCount() { return text.size(); }
    void appendLine(String line) { text.add(line); }

    // Read entire book from URL
    public void readFromUrl(String title, String url) {
        this.title = title;
        try {
            URL bookUrl = new URL(url);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(bookUrl.openStream(), "UTF-8")
            );
            String line;
            while ((line = reader.readLine()) != null) {
                text.add(line);
            }
            reader.close();
            System.out.println("✅ Successfully read book from URL.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // Write book to file
    void writeToFile(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            for (String line : text) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("✅ Successfully wrote book to " + name);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
