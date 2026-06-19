package lr8;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Iterator;

public class JsonTask {

    static final String FILE = "automobiles.json";

    @SuppressWarnings("unchecked")
    static JSONObject loadOrCreate() throws Exception {
        File file = new File(FILE);
        if (file.exists()) {
            return (JSONObject) new JSONParser().parse(new FileReader(FILE));
        }
        JSONObject root = new JSONObject();
        root.put("automobiles", new JSONArray());
        return root;
    }

    static void save(JSONObject root) throws Exception {
        try (FileWriter fw = new FileWriter(FILE)) {
            fw.write(root.toJSONString());
        }
    }

    @SuppressWarnings("unchecked")
    static void addCar(JSONObject root, String brand, String model, String year) throws Exception {
        JSONObject car = new JSONObject();
        car.put("brand", brand);
        car.put("model", model);
        car.put("year",  year);
        ((JSONArray) root.get("automobiles")).add(car);
        save(root);
        System.out.println("Добавлен: " + brand + " " + model);
    }

    static void searchByBrand(JSONObject root, String brand) {
        System.out.println("Поиск по бренду: " + brand);
        JSONArray cars = (JSONArray) root.get("automobiles");
        for (Object obj : cars) {
            JSONObject car = (JSONObject) obj;  // явный каст
            if (brand.equalsIgnoreCase((String) car.get("brand"))) {
                System.out.println("  " + car.get("brand") + " "
                        + car.get("model") + " (" + car.get("year") + ")");
            }
        }
    }

    static void deleteByModel(JSONObject root, String model) throws Exception {
        JSONArray cars = (JSONArray) root.get("automobiles");
        Iterator<?> it = cars.iterator();
        while (it.hasNext()) {
            JSONObject car = (JSONObject) it.next();
            if (model.equals(car.get("model"))) {
                it.remove();
                save(root);
                System.out.println("Удалён: " + model);
                return;
            }
        }
        System.out.println("Не найден: " + model);
    }

    public static void main(String[] args) throws Exception {
        JSONObject root = loadOrCreate();
        addCar(root, "Toyota", "Camry",   "2020");
        addCar(root, "BMW",    "X5",      "2021");
        addCar(root, "Toyota", "Corolla", "2019");

        searchByBrand(root, "Toyota");

        deleteByModel(root, "Corolla");
        System.out.println("После удаления:");
        searchByBrand(root, "Toyota");
    }
}