interface MyList<T> {
    void add(T element);
    void insert(T element, int index);
    T get(int index);
    void delete(int index);
    int size();
    boolean isEmpty();
}
class MyArrayList<T> implements MyList<T> {

    private Object[] data;
    private int size;
    private int capacity;

    public MyArrayList() {
        capacity = 1;
        data = new Object[capacity];
        size = 0;
    }

    private void resize() {
        capacity *= 2;
        Object[] newData = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public void add(T element) {
        if (size == capacity) resize();
        data[size++] = element;
    }

    public void insert(T element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Invalid index");

        if (size == capacity) resize();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    public T get(int index) {
        if (size == 0) throw new IllegalStateException("List empty");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");

        return (T) data[index];
    }

    public void delete(int index) {
        if (size == 0) throw new IllegalStateException("List empty");
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index");

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }
}
class MyLinkedList<T> implements MyList<T> {

    private class Node {
        T data;
        Node next;
        Node(T d) { data = d; }
    }

    private Node head;
    private int size;

    public void add(T element) {
        Node newNode = new Node(element);
        if (head == null) head = newNode;
        else {
            Node temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public void insert(T element, int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();

        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;

            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (size == 0) throw new IllegalStateException();
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node temp = head;
        for (int i = 0; i < index; i++)
            temp = temp.next;

        return temp.data;
    }

    public void delete(int index) {
        if (size == 0) throw new IllegalStateException();
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (index == 0) head = head.next;
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
                temp = temp.next;

            temp.next = temp.next.next;
        }
        size--;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
}
class ASSa3 {

    public static void printList(MyList<?> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Done\n");
        }
    }

    public static void main(String[] args) {

        MyList<Integer> arrList = new MyArrayList<>();
        MyList<String> linkList = new MyLinkedList<>();

        arrList.add(10);
        arrList.add(20);
        arrList.insert(15, 1);

        linkList.add("A");
        linkList.add("B");
        linkList.delete(0);

        printList(arrList);
        printList(linkList);

        try {
            arrList.get(99);
        } catch (Exception e) {
            System.out.println("Caught Exception: " + e);
        }
    }
}
