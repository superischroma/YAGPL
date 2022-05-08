package me.superischroma.yagpl.container;

import java.util.NoSuchElementException;

public class YStack<E>
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

    private static class Node<T>
    {
        T value;
        Node<T> below;

        public Node(T value, Node<T> below)
        {
            this.value = value;
            this.below = below;
        }
    }
}