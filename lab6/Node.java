package lab6;

// Клас вузла однозв’язного списку. Містить посилання на об'єкт Candy та наступний вузол.
class Node {
    Candy data;
    Node next;

    Node(Candy data) {
        this.data = data;
        this.next = null;
    }
}
