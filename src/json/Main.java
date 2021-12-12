package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger log = Logger.getLogger(Main.class.toString());
    static String JSON_TEXT = """
            {
              "books": [
                 {
                    "name": "The Call of the Wild",
                    "pages": 150,
                    "author": "Jack London"
                 },
                 {
                    "name": "Sonnets",
                    "pages": null,
                    "author": "William Shakespeare"
                 }
              ]
            }
            """;

    public static void main(String[] args) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Library library = gson.fromJson(JSON_TEXT, Library.class);
            for (Book books: library.getBooks()) {
                books.validate();
                System.out.println(books);
            }
        } catch (IllegalArgumentException iae){
            log.log(Level.SEVERE, "Format error: {0}", iae.getMessage());
        }
    }
}
