package io.java_drill.access;

public class PrivateAccess {
    // static int data; // 전역변수
    public static void main(String[] args) {
        // static int argsCount = args.length; -> 오류: 지역변수는 static 선언이 불가능

        Person a = new Person();
        a.name = "A";
        a.age = 10;
        System.out.println("a.name = " + a.name + " a.age = " + a.age);

        OutPerson b = new OutPerson();
        // b.name  // 외부에서 private으로 설정한 name은 직접 접근이 안됨
        System.out.println("b.name = " + b.getName() + " b.age = " + b.getAge());
        b.setName("B");
        System.out.println("b.name = " + b.getName() + " b.age = " + b.getAge());

    }

    static class Person{
        private String name;
        private int age;

        public Person(){
        }

        public Person(int age){
            this.age = age;
        }

        public String getName(){
            return name;
        }

        public String setName(String name) {
            return this.name = name;
        }
    }

}
