package piglatin;

public class PigLatinTranslator {
    public static Book translate(Book input) {
        Book translatedBook = new Book();

        // TODO: Add code here to populate translatedBook with a translation of the
        // input book.
        // Curent do-nothing code will return an empty book.
        // Your code will need to call translate(String input) many times.

        return translatedBook;
    }

    public static String translate(String input) {
        System.out.println("  -> translate('" + input + "')");

        String result = "";

        // TODO: translate a string input, store in result.
        // The input to this function could be any English string.
        // It may be made up of many words.
        // This method must call translateWord once for each word in the string.
        result = translateWord(input);

        return result;
    }

    private static String translateWord(String input) {
        System.out.println("  -> translateWord('" + input + "')");

        String result = "";


        
    if (input.length() == 0) return "";

    String first = input.substring(0, 1);
    if (first.equals("a") || first.equals("e") || first.equals("i") || first.equals("y")||first.equals("o") || first.equals("u")||first.equals("A")||
    first.equals("E")||first.equals("I")||first.equals("O")||first.equals("U")||first.equals("Y")) {
        return input + "ay";
    }

    

    else {

        return input.substring(1,input.length()) + input.substring(0,1) + "ay";

    }

    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
