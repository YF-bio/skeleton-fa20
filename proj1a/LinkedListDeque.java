public class LinkedListDeque<T> implements Deque<T> {
    private class LinkedList<T2> {
        private T2 item;
        private LinkedList next;
        private LinkedList prev;

        LinkedList(T2 item, LinkedList next, LinkedList prev) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private LinkedList<Integer> sentinel = new LinkedList<Integer>(-123123,null,null);
    private int size = 0;
    // private LinkedList recursion = sentinel;

    public LinkedListDeque() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    public void addFirst(T item) {
        LinkedList<T> temp = new LinkedList<T>(item, sentinel.next, sentinel);
        sentinel.next.prev = temp;
        sentinel.next = temp;
        size++;
    }

    public void addLast(T item) {
        LinkedList<T> temp = new LinkedList(item, sentinel, sentinel.prev);
        sentinel.prev.next = temp;
        sentinel.prev = temp;
        size++;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void printDeque() {
        LinkedList<T> temp = sentinel.next;
        while (temp != sentinel) {
            System.out.println(temp.item + " ");
            temp = temp.next;
        }
    }

    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        T item = (T) sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }

    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        T item = (T) sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }

        LinkedList<T> temp = sentinel.next;
        while (temp != sentinel && index > 0) {
            temp = temp.next;
            index--;
        }

        if (temp == sentinel) {
            return null;
        } else {
            return temp.item;
        }

    }

}
