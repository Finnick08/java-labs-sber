package lr3;

public class Task4 {

    // Класс узла
    static class Node {
        int value;
        Node next;

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // Построение списка "с хвоста": 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(5, null);
        head = new Node(4, head);
        head = new Node(3, head);
        head = new Node(2, head);
        head = new Node(1, head);

        System.out.print("Список: ");
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }
}