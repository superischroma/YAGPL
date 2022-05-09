package me.superischroma.yagpl.container;

import java.util.NoSuchElementException;

public class YQueue<E> implements YContainer<E>
{
    private Node<E> head, back;
    private int size;

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public E push(E element)
    {
        size++;
        if (head == null)
        {
            head = new Node<>(element, null);
            back = head;
            return null;
        }
        E value = back.value;
        back.next = new Node<>(element, null);
        back = back.next;
        return value;
    }

    @Override
    public E pop()
    {
        if (head == null)
            throw new NoSuchElementException("queue is empty");
        size--;
        E value = head.value;
        head = head.next;
        return value;
    }

    public E peek()
    {
        return head != null ? head.value : null;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        for (Node<E> node = head; node != null; node = node.next)
            builder.append(node == head ? "[" : ", ").append(node.value);
        return builder.append(']').toString();
    }

    @Override
    public int size()
    {
        return size;
    }

    private static class Node<E>
    {
        private final E value;
        private Node<E> next;

        private Node(E value, Node<E> next)
        {
            this.value = value;
            this.next = next;
        }
    }
}