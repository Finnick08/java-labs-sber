package lr3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Task6 {

    static int josephus(List<Integer> people) {
        int idx = 0;
        while (people.size() > 1) {
            idx = (idx + 1) % people.size();
            people.remove(idx);
            if (idx == people.size()) idx = 0;
        }
        return people.get(0);
    }

    static long measure(List<Integer> list, int n) {
        for (int i = 1; i <= n; i++) list.add(i);
        long start = System.currentTimeMillis();
        josephus(list);
        return System.currentTimeMillis() - start;
    }

    public static void main(String[] args) {
        int n = 10000;

        long timeArrayList  = measure(new ArrayList<>(), n);
        long timeLinkedList = measure(new LinkedList<>(), n);

        System.out.println("ArrayList  время: " + timeArrayList  + " мс");
        System.out.println("LinkedList время: " + timeLinkedList + " мс");
        System.out.println("""
                Вывод: ArrayList работает быстрее, так как удаление
                по индексу у LinkedList требует прохода по цепочке узлов O(n),
                тогда как у ArrayList удаление из середины — O(n) сдвиг,
                но с меньшими константными затратами благодаря непрерывной памяти.""");
    }
}