package me.superischroma.yagpl.container;

import java.util.NoSuchElementException;

public class YStack<E> implements YContainer<E>
{
    private Node<E> top;
    private int size;

    private YStack()
    {
        this.top = null;
        this.size = 0;
    }

    public E push(E element)
    {
        size++;
        top = new Node<>(element, top);
        return top.below != null ? top.below.value : null;
    }

    public E pop()
    {
        if (top == null)
            throw new NoSuchElementException("stack is empty");
        size--;
        E element = top.value;
        top = top.below;
        return element;
    }

    public E peek()
    {
        if (top == null)
            throw new NoSuchElementException("stack is empty");
        return top.value;
    }

    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (Node<E> node = top; node != null; node = node.below)
            builder.append(node == top ? "[" : ", ").append(node.value);
        return builder.append(']').toString();
    }

    private static class Node<T>
    {
        private final T value;
        private Node<T> below;

        public Node(T value, Node<T> below)
        {
            this.value = value;
            this.below = below;
        }
    }
}