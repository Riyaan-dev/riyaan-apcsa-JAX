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

        if (input == null) {
            return null;
        }
        else if (input.length() == 0) {
            return "";
        }

        else if (input.trim().length() == 0) {
            return input;
        }

        else if (input.contains(" ")) {
            String[] words = input.split(" ");
            String result = "";
            for (String word : words) {
                result += translateWord(word) + " ";
            }
            return result.trim();
        }
        else if (!Character.isLetter(input.charAt(0))) {
            return input;
        }

        else if (!Character.isLetter(input.charAt(input.length() - 1))) {
            char lastChar = input.charAt(input.length() - 1);
            String wordWithoutLastChar = input.substring(0, input.length() - 1);
            return translateWord(wordWithoutLastChar) + lastChar;
        }

        else if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            return input + "ay";
        }

        public static boolean isVowel(char c) {
            char lowerC = Character.toLowerCase(c);
            return lowerC == 'a' || lowerC == 'e' || lowerC == 'i' || lowerC == 'o' || lowerC == 'u';
        }

        if (isVowel(input.charAt(0))) {
            return input + "way";
        }
        else {
            int firstVowelIndex = -1;
            for (int i = 0; i < input.length(); i++) {
                if (isVowel(input.charAt(i))) {
                    firstVowelIndex = i;
                    break;
                }
            }
            if (firstVowelIndex == -1) {
                return input + "ay";
            } else {
                String consonantCluster = input.substring(0, firstVowelIndex);
                String restOfWord = input.substring(firstVowelIndex);
                return restOfWord + consonantCluster + "ay";
            }
        }
        return result;

        String result = input;

    if (input.length() == 0) {
        return input;
    }

    else if (input.length() == 1) {
        return input + "ay";
    }



        // TODO: Replace this code to correctly translate a single word.
        // Start here first!
        // This is the first place to work.
        result = input; // delete this line

        return result;
    }

    // Add additonal private methods here.
    // For example, I had one like this:
    // private static String capitalizeFirstLetter(String input)

}
