package piglatin;

import java.util.Scanner;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle() + " (translated)");

        boolean shouldTranslate = false;

        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);

            // Works for any Gutenberg ebook
            if (line.contains("START OF THE PROJECT GUTENBERG")) {
                shouldTranslate = true;
                continue;
            } else if (line.contains("END OF THE PROJECT GUTENBERG")) {
                shouldTranslate = false;
                continue;
            }

            if (shouldTranslate) {
                String translatedLine = translate(line);
                translatedBook.appendLine(translatedLine);
            }
        }

        return translatedBook;
    }

    public static String translate(String input) {
        
        System.out.println("  -> translate('" + input + "')");

        Scanner scan = new Scanner(input);
        String result = "";

        while (scan.hasNext()) {

            String word = scan.next();
            if (!result.isEmpty()) {
                result += " ";
            }
            result += translateWord(word);

        }

        scan.close();

        return result;
    }

    private static String translateWord(String input) {

        System.out.println("  -> translateWord('" + input + "')");

        if (input.length() == 0) return "";
        if (input.trim().length() == 0) return "";

        if (input.indexOf(" ") != -1) {

            String result = "";
            int start = 0;
            while (start < input.length()) {


                int space = input.indexOf(" ", start);
                if (space == -1) space = input.length();
                String word = input.substring(start, space);
                result = result + translateWord(word);
                if (space < input.length()) result = result + " ";
                start = space + 1;
            }
            return result;
        }

        String end = "";
        String last = input.substring(input.length() - 1);

        if (!Character.isLetter(last.charAt(0))) {
            end = last;
            input = input.substring(0, input.length() - 1);
        }
         if(input.length() == 0){
            return end;
         }

        String vowels = "aeiouAEIOU";
        String first = input.substring(0, 1);
        boolean stringIsCapitalized = Character.isUpperCase(input.charAt(0));

        if (vowels.contains(first)) {

            return input + "ay" + end;


        }

        int i = 0;



        while (i < input.length() && !vowels.contains(input.substring(i, i + 1))) {


            i++;
        }



        if (i == input.length()) {


            return input + "ay" + end;
        }

        String start = input.substring(0, i);



        start = start.substring(0, 1).toLowerCase() + start.substring(1);

        String rest = input.substring(i);

        if (stringIsCapitalized && rest.length() > 0) {


            rest = rest.substring(0, 1).toUpperCase() + rest.substring(1);
        }

        String result = rest + start + "ay";


        return result + end;
    }
}
