package lab6;
import java.util.*;

//Клас, що реалізує колекцію на основі однозв’язного списку. Реалізує інтерфейс List<Candy>.
public class CandyLinkedList implements List<Candy> {
    private Node head;
    private int size;

    // Порожній конструктор.
    public CandyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Конструктор, що приймає один об'єкт Candy.
    public CandyLinkedList(Candy candy) {
        this();
        add(candy);
    }

    // Конструктор, що приймає колекцію цукерок.
    public CandyLinkedList(Collection<? extends Candy> candies) {
        this();
        for (Candy c : candies) {
            add(c);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Candy c : this) {
            if (Objects.equals(c, o)) return true;
        }
        return false;
    }

    @Override
    public Iterator<Candy> iterator() {
        return new Iterator<>() {
            private Node current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Candy next() {
                if (current == null) throw new NoSuchElementException();
                Candy data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (Candy c : this) arr[i++] = c;
        return arr;
    }

    @Override
    public boolean add(Candy candy) {
        Node newNode = new Node(candy);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (head == null) return false;

        if (Objects.equals(head.data, o)) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (Objects.equals(current.next.data, o)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public Candy get(int index) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }

    @Override
    public Candy set(int index, Candy element) {
        checkIndex(index);
        Node current = head;
        for (int i = 0; i < index; i++) current = current.next;
        Candy old = current.data;
        current.data = element;
        return old;
    }

    @Override
    public void add(int index, Candy element) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    @Override
    public Candy remove(int index) {
        checkIndex(index);
        if (index == 0) {
            Candy removed = head.data;
            head = head.next;
            size--;
            return removed;
        }

        Node current = head;
        for (int i = 0; i < index - 1; i++) current = current.next;
        Candy removed = current.next.data;
        current.next = current.next.next;
        size--;
        return removed;
    }

    @Override
    public int indexOf(Object o) {
        int i = 0;
        for (Candy c : this) {
            if (Objects.equals(c, o)) return i;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1, i = 0;
        for (Candy c : this) {
            if (Objects.equals(c, o)) index = i;
            i++;
        }
        return index;
    }

    // Методи, які можна залишити не реалізованими для стислості
    @Override public ListIterator<Candy> listIterator() { throw new UnsupportedOperationException(); }
    @Override public ListIterator<Candy> listIterator(int index) { throw new UnsupportedOperationException(); }
    @Override public List<Candy> subList(int fromIndex, int toIndex) { throw new UnsupportedOperationException(); }
    @Override public <T> T[] toArray(T[] a) { throw new UnsupportedOperationException(); }
    @Override public boolean containsAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean addAll(Collection<? extends Candy> c) { throw new UnsupportedOperationException(); }
    @Override public boolean addAll(int index, Collection<? extends Candy> c) { throw new UnsupportedOperationException(); }
    @Override public boolean removeAll(Collection<?> c) { throw new UnsupportedOperationException(); }
    @Override public boolean retainAll(Collection<?> c) { throw new UnsupportedOperationException(); }

    // Службовий метод
    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Невірний індекс: " + index);
    }
}
