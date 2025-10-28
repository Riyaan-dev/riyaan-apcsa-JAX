package piglatin;

public class PigLatinTranslator {

    public static Book translate(Book input) {
        Book translatedBook = new Book();
        translatedBook.setTitle(input.getTitle() + " (translated)");

        for (int i = 0; i < input.getLineCount(); i++) {
            String line = input.getLine(i);
            String translatedLine = translate(line);
            translatedBook.appendLine(translatedLine);
        }

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");
        return translateWord(input);
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

        String vowels = "aeiouAEIOU";
        String first = input.substring(0, 1);
        Boolean stringIsCapitalized = Character.isUpperCase(input.charAt(0));

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

        String pattern = input;
        String result = rest + start + "ay";

        /*String fixed = "";
        for (int j = 0; j < result.length(); j++) {
            if (j < pattern.length()) {
                char c = result.charAt(j);
                char p = pattern.charAt(j);
                if (Character.isUpperCase(p)) fixed += Character.toUpperCase(c);
                else fixed += Character.toLowerCase(c);
            } else {
                fixed += result.charAt(j);
            }
        }*/

        return result + end;
    }
}
