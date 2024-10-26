package task2;

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    // Процедура для вставки элемента x в голову списка L
    public void ListInsert(Node x) {
        if (head == null) { // Если список пуст
            head = x;
            tail = x;
        } else {
            x.next = head;
            head.prev = x;
            head = x;
        }
    }

    // Вывод списка
    public void printList() {
        Node x = head;
        while (x != null) {
            System.out.print(x.key + " ");
            x = x.next;
        }
        System.out.println();
    }
}