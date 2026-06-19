package lr8;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.*;

public class JsonExample {

    static final String FILE_PATH = "library.json";

    // Создание JSON файла
    @SuppressWarnings("unchecked")
    static void createJson() throws Exception {
        JSONObject root = new JSONObject();
        JSONArray books = new JSONArray();

        String[][] data = {
                {"Java Programming",   "John Doe",    "2015"},
                {"Python Programming", "Jane Smith",  "2018"},
                {"Ruby Programming",   "Bob Johnson", "2016"}
        };

        for (String[] b : data) {
            JSONObject book = new JSONObject();
            book.put("title",  b[0]);
            book.put("author", b[1]);
            book.put("year",   b[2]);
            books.add(book);
        }
        root.put("books", books);

        try (FileWriter fw = new FileWriter(FILE_PATH)) {
            fw.write(root.toJSONString());
        }
        System.out.println("JSON создан: " + FILE_PATH);
    }

    // Чтение JSON файла
    static void readJson() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject root = (JSONObject) parser.parse(new FileReader(FILE_PATH));

        JSONArray books = (JSONArray) root.get("books");
        for (Object obj : books) {
            JSONObject book = (JSONObject) obj;
            System.out.println("Название: " + book.get("title"));
            System.out.println("Автор:    " + book.get("author"));
            System.out.println("Год:      " + book.get("year"));
            System.out.println("---");
        }
    }

    public static void main(String[] args) throws Exception {
        createJson();
        readJson();
    }
}