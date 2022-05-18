package io.java_drill.abstractTest;

import java.util.Arrays;

public class SubClass extends AbstractTest{

    public int getName(int a){
        return a;
    }
    public static void main(String[] args) {
        SubClass subClass = new SubClass();
        String name = subClass.getName();// 상위 클래스 함수
        int name1 = subClass.getName(10);// 상위 클래스 오버로딩

        System.out.println("name = " + name);
        System.out.println("name1 = " + name1);
    }
}
