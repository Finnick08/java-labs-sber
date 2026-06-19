package lr3;

public class Task7 {

    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static void printList(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Способ 1: с хвоста (добавляем в начало)
        Node head1 = null;
        for (int i = 5; i >= 1; i--) {
            head1 = new Node(i, head1);
        }
        System.out.print("Список (с хвоста): ");
        printList(head1);

        // Способ 2: с головы (добавляем в конец)
        Node head2 = new Node(1, null);
        Node tail = head2;
        for (int i = 2; i <= 5; i++) {
            tail.next = new Node(i, null);
            tail = tail.next;
        }
        System.out.print("Список (с головы): ");
        printList(head2);
    }
}