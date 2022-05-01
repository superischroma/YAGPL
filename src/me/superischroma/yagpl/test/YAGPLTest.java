package me.superischroma.yagpl.test;

import me.superischroma.yagpl.YConstants;
import me.superischroma.yagpl.YMath;

public final class YAGPLTest
{
    public YAGPLTest() throws IllegalAccessException // Prevent library users from constructing the test class
    {
        throw new IllegalAccessException(YConstants.CANNOT_CREATE_INSTANCE);
    }

    public static void main(String[] args)
    {
        System.out.println(YMath.sin(YMath.PI));
        System.out.println(YMath.sin(YMath.PI / 2));
        System.out.println(YMath.cos(0));
        System.out.println(YMath.cos(YMath.PI));
        System.out.println(YMath.cos(YMath.PI / 2));
        System.out.println(YMath.pow(16.0, 0.5));
    }
}