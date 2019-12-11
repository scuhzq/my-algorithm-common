package com.hzq.test;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class TestUnsafe {

    private static int staticInt = 10;
    private int insInt = 20;

    public static void main(String[] args) throws Exception{
        TestUnsafe testUnsafe = new TestUnsafe();
        Unsafe unsafe = getInstance();
        long staticFieldOffset = unsafe.staticFieldOffset(TestUnsafe.class.getDeclaredField("staticInt"));
        System.out.println("staticFieldOffset:" + staticFieldOffset);
        long objectFieldOffset = unsafe.objectFieldOffset(TestUnsafe.class.getDeclaredField("insInt"));
        System.out.println("objectFieldOffset:" + objectFieldOffset);
        unsafe.compareAndSwapInt(testUnsafe, staticFieldOffset, 10, 15);
        unsafe.compareAndSwapInt(testUnsafe, objectFieldOffset, 20, 25);
        System.out.println("staticInt:" + staticInt + ", insInt:" + testUnsafe.insInt);
    }

    private static Unsafe getInstance() throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        return (Unsafe) field.get(Unsafe.class);
    }

}
