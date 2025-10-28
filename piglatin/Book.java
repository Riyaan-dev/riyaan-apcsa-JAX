package piglatin;

import java.io.*;
import java.net.*;
import java.util.*;

public class Book {
    private String title;
    private ArrayList<String> text = new ArrayList<String>();

    Book() {
    }

    public void printlines(int start, int length) {
        System.out.println("Lines " + start + " to " + (start + length) + " of book: " + title);
        for (int i = start; i < start + length; i++) {
            if (i < text.size()) {
                System.out.println(i + ": " + text.get(i));
            } else {
                System.out.println(i + ": line not in book.");
            }
        }
    }

    String getTitle() {
        return title;
    }

    void setTitle(String title) {
        this.title = title;
    }

    String getLine(int lineNumber) {
        return text.get(lineNumber);
    }

    int getLineCount() {
        return text.size();
    }

    void appendLine(String line) {
        text.add(line);
    }

    public void readFromString(String title, String string) {
        this.title = title;
        Scanner input = new Scanner(string);
        while (input.hasNextLine()) {
            text.add(input.nextLine());
        }
        input.close();
    }

    public void readFromUrl(String title, String url) {
        this.title = title;
        try {
            URL bookUrl = URI.create(url).toURL();
            Scanner input = new Scanner(bookUrl.openStream());
            while (input.hasNextLine()) {
                text.add(input.nextLine());
            }
            input.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void writeToFile(String name) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name))) {
            for (String line : text) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
