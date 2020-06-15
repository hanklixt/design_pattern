package com.hank.current.commonMethod;

import com.hank.current.pojo.Student;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Description
 * @auther 李先涛
 * @create 2020-06-15 9:44
 */
public class TestUnSafeAccessor {

    private static Unsafe unsafe;

    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

    public static Unsafe getUnsafe(){
        return unsafe;
    }

    public static void main(String[] args) {
//        UnSafeCas();
       UnSafeString();
    }

    private static void UnSafeCas() {
        Unsafe unsafe = TestUnSafeAccessor.getUnsafe();
        try {
            Field age = Student.class.getDeclaredField("age");
            Field name = Student.class.getDeclaredField("name");
            long a = unsafe.objectFieldOffset(age);
            long n = unsafe.objectFieldOffset(name);

            Student student = new Student();

            Student student1 = new Student(10,"李四");

            //返回true
            boolean upAge = unsafe.compareAndSwapInt(student, a, 0, 100);
            boolean up = unsafe.compareAndSwapObject(student, n, null, "张三");

            //返回true
            boolean upAge1 = unsafe.compareAndSwapInt(student1, a, 0, 20);
            boolean up1 = unsafe.compareAndSwapObject(student1, n, null, "李四");

            System.out.println(student.toString());
            System.out.println(student1.toString());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     * UnSafe操作String和Integer
     */
    private static void UnSafeString(){

        String s="abc";

        String b=s.intern();

        String d="abc";

        Integer f=100;

        Integer g=100;

        Unsafe unsafe = TestUnSafeAccessor.getUnsafe();
        try {
            //String类，使用Unsafe进行修改会 修改常量词
            Field value = String.class.getDeclaredField("value");
            long offset = unsafe.objectFieldOffset(value);
            //String类 value值是char数组
            int base = unsafe.arrayBaseOffset(char[].class);
            char[] values = (char[]) unsafe.getObject(s, offset);
            unsafe.putChar(values,base,'e');
            System.out.println(s);
            System.out.println(b);
            System.out.println(d);

            Field value1 = Integer.class.getDeclaredField("value");
            long offset1 = unsafe.objectFieldOffset(value1);

            unsafe.putInt(f,offset1,20);
            System.out.println(f);
            System.out.println(g);
            unsafe.compareAndSwapInt(f,offset1,20,100);

            System.out.println(f);
            System.out.println(g);


        } catch (NoSuchFieldException e ) {
            e.printStackTrace();
        }


    }


}
