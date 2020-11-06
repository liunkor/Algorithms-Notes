import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;   //point to the first node of queue
    private Node<Item> last;    //point to the last node of queue
    private int n;      // number of elements on queue

    public Queue() {
        first = null;
        last = null;
        n = 0;
    }

    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    public void push(Item item) {
        Node<Item> newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if (isEmpty()) first = newNode;
        else last.next = newNode;
        last = newNode;
        n++;
    }
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty.");
        return first.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this) s.append(item).append(" ");
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> first;

        public LinkedIterator(Node<Item> first) {
            this.first = first;
        }

        @Override
        public void remove() { throw new UnsupportedOperationException(); }

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = first.item;
            first = first.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (!s.equals("-")) q.push(s);
            else if (!q.isEmpty())
                StdOut.print(q.pop() + " ");
        }
        StdOut.println("(" + q.size() + " left on queue)");
    }

}
