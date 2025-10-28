package piglatin;

public class App {
    public static void main(String[] args) {
        //  Load the book from URL
        Book input = new Book();
        input.readFromUrl("Hamlet", "https://gutenberg.pglaf.org/cache/epub/1513/pg1513.txt");


        //  Translate the entire book
        Book translated = PigLatinTranslator.translate(input);

        //  Write the translated book to test.txt
        translated.writeToFile("test.txt");
                //  Load the book from URL
        Book gatsbyInput = new Book();
        gatsbyInput.readFromUrl("The Great Gatsby", "https://www.gutenberg.org/cache/epub/64317/pg64317.txt");

        
        

        //  Translate the entire book
        Book gatsbyTranslatedBook = PigLatinTranslator.translate(gatsbyInput);

        //  Write the translated book to test.txt
        gatsbyTranslatedBook.writeToFile("gatsbyPigLatin.txt");
        TestSuite.run();
    }
}
