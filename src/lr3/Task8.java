package lr3;

public class Task8 {

    static class Node {
        int value;
        Node next;
        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class LinkedListCustom {
        Node head;

        // === Итеративные методы ===

        void createHead(int[] values) {
            head = null;
            for (int v : values) head = new Node(v, head);
        }

        void createTail(int[] values) {
            head = null;
            Node tail = null;
            for (int v : values) {
                Node node = new Node(v, null);
                if (head == null) { head = node; tail = node; }
                else { tail.next = node; tail = node; }
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[");
            Node ref = head;
            while (ref != null) {
                sb.append(ref.value);
                if (ref.next != null) sb.append(", ");
                ref = ref.next;
            }
            return sb.append("]").toString();
        }

        void addFirst(int value) {
            head = new Node(value, head);
        }

        void addLast(int value) {
            Node node = new Node(value, null);
            if (head == null) { head = node; return; }
            Node ref = head;
            while (ref.next != null) ref = ref.next;
            ref.next = node;
        }

        // Вставка перед элементом с номером index (0-based)
        void insert(int index, int value) {
            if (index == 0) { addFirst(value); return; }
            Node ref = head;
            for (int i = 0; i < index - 1 && ref.next != null; i++) ref = ref.next;
            ref.next = new Node(value, ref.next);
        }

        void removeFirst() {
            if (head != null) head = head.next;
        }

        void removeLast() {
            if (head == null) return;
            if (head.next == null) { head = null; return; }
            Node ref = head;
            while (ref.next.next != null) ref = ref.next;
            ref.next = null;
        }

        void remove(int index) {
            if (index == 0) { removeFirst(); return; }
            Node ref = head;
            for (int i = 0; i < index - 1 && ref.next != null; i++) ref = ref.next;
            if (ref.next != null) ref.next = ref.next.next;
        }

        // === Рекурсивные методы ===

        void createHeadRec(int[] values, int index) {
            if (index < 0) return;
            head = new Node(values[index], head);
            createHeadRec(values, index - 1);
        }

        Node createTailRec(int[] values, int index) {
            if (index == values.length) return null;
            Node node = new Node(values[index], null);
            node.next = createTailRec(values, index + 1);
            return node;
        }

        String toStringRec(Node node) {
            if (node == null) return "]";
            return node.value + (node.next != null ? ", " : "") + toStringRec(node.next);
        }
    }

    public static void main(String[] args) {
        LinkedListCustom list = new LinkedListCustom();
        int[] data = {1, 2, 3, 4, 5};

        list.createTail(data);
        System.out.println("После createTail: " + list);

        list.addFirst(0);
        System.out.println("После addFirst(0): " + list);

        list.addLast(6);
        System.out.println("После addLast(6): " + list);

        list.insert(3, 99);
        System.out.println("После insert(3, 99): " + list);

        list.removeFirst();
        System.out.println("После removeFirst: " + list);

        list.removeLast();
        System.out.println("После removeLast: " + list);

        list.remove(2);
        System.out.println("После remove(2): " + list);

        // Рекурсивные методы
        LinkedListCustom list2 = new LinkedListCustom();
        list2.head = list2.createTailRec(data, 0);
        System.out.println("Рекурсивный createTailRec: [" + list2.toStringRec(list2.head));

        LinkedListCustom list3 = new LinkedListCustom();
        list3.createHeadRec(data, data.length - 1);
        System.out.println("Рекурсивный createHeadRec: [" + list3.toStringRec(list3.head));
    }
}