package lr8;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;
import java.util.*;
import java.util.stream.*;

public class XmlTask {

    static final String FILE = "automobiles.xml";
    static Document doc;

    // Загрузить или создать документ
    static void loadOrCreate() throws Exception {
        File file = new File(FILE);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        if (file.exists()) {
            doc = builder.parse(file);
        } else {
            doc = builder.newDocument();
            doc.appendChild(doc.createElement("parking"));
            save();
        }
    }

    // Сохранить документ в файл
    static void save() throws Exception {
        Transformer tr = TransformerFactory.newInstance().newTransformer();
        tr.setOutputProperty(OutputKeys.INDENT, "yes");
        tr.transform(new DOMSource(doc), new StreamResult(new File(FILE)));
    }

    // Добавить автомобиль
    @SuppressWarnings("unchecked")
    static void addCar(String brand, String model, String year) throws Exception {
        Element car = doc.createElement("automobile");
        for (String[] f : new String[][]{{"brand", brand}, {"model", model}, {"year", year}}) {
            Element el = doc.createElement(f[0]);
            el.setTextContent(f[1]);
            car.appendChild(el);
        }
        doc.getDocumentElement().appendChild(car);
        save();
        System.out.println("Добавлен автомобиль: " + brand + " " + model);
    }

    // Поиск по бренду или году
    static void search(String query) throws Exception {
        NodeList nodes = doc.getElementsByTagName("automobile");
        List<Element> result = IntStream.range(0, nodes.getLength())
                .mapToObj(i -> (Element) nodes.item(i))
                .filter(el -> {
                    String brand = el.getElementsByTagName("brand").item(0).getTextContent();
                    String year  = el.getElementsByTagName("year").item(0).getTextContent();
                    return brand.equalsIgnoreCase(query) || year.equals(query);
                })
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            System.out.println("Ничего не найдено по запросу: " + query);
        } else {
            result.forEach(el -> System.out.println(
                    el.getElementsByTagName("brand").item(0).getTextContent() + " " +
                            el.getElementsByTagName("model").item(0).getTextContent() + " (" +
                            el.getElementsByTagName("year").item(0).getTextContent() + ")"
            ));
        }
    }

    // Удалить автомобиль по модели
    static void deleteCar(String model) throws Exception {
        NodeList nodes = doc.getElementsByTagName("automobile");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element el = (Element) nodes.item(i);
            if (el.getElementsByTagName("model").item(0).getTextContent().equals(model)) {
                el.getParentNode().removeChild(el);
                save();
                System.out.println("Удалён автомобиль: " + model);
                return;
            }
        }
        System.out.println("Автомобиль не найден: " + model);
    }

    public static void main(String[] args) throws Exception {
        loadOrCreate();
        addCar("Toyota",  "Camry",  "2020");
        addCar("BMW",     "X5",     "2021");
        addCar("Toyota",  "Corolla","2019");

        System.out.println("\n--- Поиск Toyota ---");
        search("Toyota");

        System.out.println("\n--- Поиск 2021 ---");
        search("2021");

        System.out.println("\n--- Удаление Corolla ---");
        deleteCar("Corolla");
    }
}