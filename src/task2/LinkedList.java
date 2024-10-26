package task2;

public class LinkedList {
    public static void main(String[] args) {
        DoublyLinkedList L = new DoublyLinkedList();

        // Создаем новый элемент x и вставляем его в голову списка
        Node x = new Node(1);
        L.ListInsert(x);

        // Вставляем еще несколько элементов в голову списка
        L.ListInsert(new Node(2));
        L.ListInsert(new Node(3));

        // Печать списка после вставок
        System.out.println("Список после вставки элементов в голову:");
        L.printList(); // Ожидаемый вывод: 3 2 1
    }
}