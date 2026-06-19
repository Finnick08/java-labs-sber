package lr8;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;

public class XmlExample {

    static final String FILE_PATH = "library.xml";

    // Создание XML файла
    static void createXml() throws Exception {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();

        Element root = doc.createElement("library");
        doc.appendChild(root);

        String[][] books = {
                {"Война и мир",          "Лев Толстой",      "1869"},
                {"Мастер и Маргарита",   "Михаил Булгаков",  "1967"}
        };

        for (String[] b : books) {
            Element book = doc.createElement("book");
            for (String[] field : new String[][]{{"title", b[0]}, {"author", b[1]}, {"year", b[2]}}) {
                Element el = doc.createElement(field[0]);
                el.setTextContent(field[1]);
                book.appendChild(el);
            }
            root.appendChild(book);
        }

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(doc), new StreamResult(new File(FILE_PATH)));
        System.out.println("XML создан: " + FILE_PATH);
    }

    // Чтение XML файла
    static void readXml() throws Exception {
        Document doc = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new File(FILE_PATH));

        System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

        NodeList books = doc.getElementsByTagName("book");
        for (int i = 0; i < books.getLength(); i++) {
            Element book = (Element) books.item(i);
            System.out.println("Название: " + book.getElementsByTagName("title").item(0).getTextContent());
            System.out.println("Автор:    " + book.getElementsByTagName("author").item(0).getTextContent());
            System.out.println("Год:      " + book.getElementsByTagName("year").item(0).getTextContent());
            System.out.println("---");
        }
    }

    public static void main(String[] args) throws Exception {
        createXml();
        readXml();
    }
}