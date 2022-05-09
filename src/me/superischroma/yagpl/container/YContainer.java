package me.superischroma.yagpl.container;

public interface YContainer<E>
{
    E push(E element);
    E pop();
    int size();
    boolean isEmpty();
}
