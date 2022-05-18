package io.java_drill.access;

public class OutPerson {
    private String name;
    private int age;

    public OutPerson(){
    }

    public String setName(String name) {
        return this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
