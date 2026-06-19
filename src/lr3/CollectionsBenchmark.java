package lr3;

import java.util.*;

public class CollectionsBenchmark {

    static final int N = 1_000_000;

    public static void main(String[] args) {
        System.out.println("Количество элементов: " + N);
        System.out.println();

        // === ДОБАВЛЕНИЕ ===
        System.out.println("=== Добавление в начало ===");
        System.out.println("ArrayDeque : " + testAddFirst_Deque()  + " мс");
        System.out.println("ArrayList  : " + testAddFirst_Array()  + " мс");
        // TreeMap не поддерживает понятие "начало" как список,
        // добавляем с ключом 0..N (начало = минимальный ключ)
        System.out.println("TreeMap    : " + testAddFirst_Tree()   + " мс");

        System.out.println("\n=== Добавление в конец ===");
        System.out.println("ArrayDeque : " + testAddLast_Deque()   + " мс");
        System.out.println("ArrayList  : " + testAddLast_Array()   + " мс");
        System.out.println("TreeMap    : " + testAddLast_Tree()    + " мс");

        System.out.println("\n=== Добавление в середину ===");
        System.out.println("ArrayDeque : не поддерживается (нет индекса)");
        System.out.println("ArrayList  : " + testAddMiddle_Array() + " мс");
        System.out.println("TreeMap    : " + testAddMiddle_Tree()  + " мс");

        // === УДАЛЕНИЕ ===
        System.out.println("\n=== Удаление с начала ===");
        System.out.println("ArrayDeque : " + testRemoveFirst_Deque() + " мс");
        System.out.println("ArrayList  : " + testRemoveFirst_Array() + " мс");
        System.out.println("TreeMap    : " + testRemoveFirst_Tree()  + " мс");

        System.out.println("\n=== Удаление с конца ===");
        System.out.println("ArrayDeque : " + testRemoveLast_Deque()  + " мс");
        System.out.println("ArrayList  : " + testRemoveLast_Array()  + " мс");
        System.out.println("TreeMap    : " + testRemoveLast_Tree()   + " мс");

        System.out.println("\n=== Удаление из середины ===");
        System.out.println("ArrayDeque : не поддерживается (нет индекса)");
        System.out.println("ArrayList  : " + testRemoveMiddle_Array() + " мс");
        System.out.println("TreeMap    : " + testRemoveMiddle_Tree()  + " мс");

        // === ПОЛУЧЕНИЕ ПО ИНДЕКСУ (17 млрд — симулируем через цикл) ===
        System.out.println("\n=== Получение по индексу ===");
        System.out.println("ArrayDeque : не поддерживается (нет get по индексу)");
        System.out.println("ArrayList  : " + testGet_Array()  + " мс");
        System.out.println("TreeMap    : " + testGet_Tree()   + " мс");
    }

    // ---- ArrayDeque ----

    static long testAddFirst_Deque() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) d.addFirst(i);
        return System.currentTimeMillis() - start;
    }

    static long testAddLast_Deque() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) d.addLast(i);
        return System.currentTimeMillis() - start;
    }

    static long testRemoveFirst_Deque() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N; i++) d.addLast(i);
        long start = System.currentTimeMillis();
        while (!d.isEmpty()) d.pollFirst();
        return System.currentTimeMillis() - start;
    }

    static long testRemoveLast_Deque() {
        ArrayDeque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N; i++) d.addLast(i);
        long start = System.currentTimeMillis();
        while (!d.isEmpty()) d.pollLast();
        return System.currentTimeMillis() - start;
    }

    // ---- ArrayList ----

    static long testAddFirst_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) list.add(0, i);
        return System.currentTimeMillis() - start;
    }

    static long testAddLast_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) list.add(i);
        return System.currentTimeMillis() - start;
    }

    static long testAddMiddle_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        list.add(N / 2, 999);
        return System.currentTimeMillis() - start;
    }

    static long testRemoveFirst_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        while (!list.isEmpty()) list.remove(0);
        return System.currentTimeMillis() - start;
    }

    static long testRemoveLast_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        while (!list.isEmpty()) list.remove(list.size() - 1);
        return System.currentTimeMillis() - start;
    }

    static long testRemoveMiddle_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        list.remove(N / 2);
        return System.currentTimeMillis() - start;
    }

    static long testGet_Array() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) list.get(i);
        return System.currentTimeMillis() - start;
    }

    // ---- TreeMap ----
    // В TreeMap нет позиционного индекса, "начало" = минимальный ключ,
    // "конец" = максимальный, "середина" = ключ N/2

    static long testAddFirst_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) map.put(i, i); // ключи 0..N — "начало" = 0
        return System.currentTimeMillis() - start;
    }

    static long testAddLast_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        long start = System.currentTimeMillis();
        for (int i = N; i > 0; i--) map.put(i, i); // добавляем в обратном порядке
        return System.currentTimeMillis() - start;
    }

    static long testAddMiddle_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i += 2) map.put(i, i); // чётные ключи
        long start = System.currentTimeMillis();
        map.put(N / 2 + 1, 999); // нечётный — попадёт в середину
        return System.currentTimeMillis() - start;
    }

    static long testRemoveFirst_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) map.put(i, i);
        long start = System.currentTimeMillis();
        while (!map.isEmpty()) map.pollFirstEntry();
        return System.currentTimeMillis() - start;
    }

    static long testRemoveLast_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) map.put(i, i);
        long start = System.currentTimeMillis();
        while (!map.isEmpty()) map.pollLastEntry();
        return System.currentTimeMillis() - start;
    }

    static long testRemoveMiddle_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) map.put(i, i);
        long start = System.currentTimeMillis();
        map.remove(N / 2);
        return System.currentTimeMillis() - start;
    }

    static long testGet_Tree() {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) map.put(i, i);
        long start = System.currentTimeMillis();
        for (int i = 0; i < N; i++) map.get(i);
        return System.currentTimeMillis() - start;
    }
}