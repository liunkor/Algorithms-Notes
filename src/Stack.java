import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

// The Stack class represents a last in first out (LIFO) stack of generic items.
public class Stack<Item> implements Iterable<Item> {
    private Node<Item> first;    //point to the top fo stack
    private int n;

    /**
     * data node to help link list class
     */
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes a empty stack
     */
    public Stack() {
        first = null;
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of items in this stack.
     */
    public int size() {
        return n;
    }

    /**
     * Add a item to the stack
     * @param item
     */
    public void push(Item item) {
        Node<Item> newNode = new Node<>();
        newNode.item = item;
        newNode.next = first;
        first = newNode;
        n++;
    }

    public Item pop() {
        if (n == 0)
            throw new NoSuchElementException("Stack is empty!");
        Item item = first.item;
        first = first.next;
        n--;
        return item;
    }

    /**
     * Returns (but does not remove) the item most recently added to this stack.
     */
    public Item peek() {
        if (n == 0)
            throw new NoSuchElementException("Stack is empty!");
        return first.item;
    }

    public Stack<Item> copy() {
        Stack<Item> newStack = new Stack<>();
        Stack<Item> tmp = new Stack<>();
        for (Item item: this) tmp.push(item);
        for (Item item: tmp) newStack.push(item);
        return newStack;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item: this) {
            s.append(item);
            s.append(" ");
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<Item> {
        private Node<Item> current;

        public LinkedIterator(Node<Item> current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.println(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + ") left on stack");
        Stack<String> s = stack.copy();
        for (String str: s) System.out.println(s.pop());
        for (String str: stack) System.out.println(stack.pop());
    }
}
