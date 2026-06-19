//package lr8;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//import java.io.*;
//
//public class HtmlTask {
//
//    static final String URL      = "https://itlearn.ru/first-steps";
//    static final String OUT_FILE = "links.txt";
//    static final int    RETRIES  = 3;
//
//    public static void main(String[] args) {
//        Document doc = null;
//
//        // Попытки переподключения
//        for (int attempt = 1; attempt <= RETRIES; attempt++) {
//            try {
//                System.out.println("Подключение, попытка " + attempt + "...");
//                doc = Jsoup.connect(URL).timeout(10_000).get();
//                System.out.println("Успешно подключились.");
//                break;
//            } catch (IOException e) {
//                System.out.println("Ошибка: " + e.getMessage());
//                if (attempt == RETRIES) {
//                    System.out.println("Не удалось подключиться после " + RETRIES + " попыток.");
//                    return;
//                }
//            }
//        }
//
//        // Запись ссылок в файл
//        Elements links = doc.select("a[href]");
//        try (PrintWriter pw = new PrintWriter(new FileWriter(OUT_FILE))) {
//            for (Element link : links) {
//                String href = link.attr("abs:href");
//                pw.println(href);
//                System.out.println(href);
//            }
//            System.out.println("Ссылки сохранены в: " + OUT_FILE);
//        } catch (IOException e) {
//            System.out.println("Ошибка записи в файл: " + e.getMessage());
//        }
//    }
//}