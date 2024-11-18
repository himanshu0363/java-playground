package org.hmnsch.lab.practice.collection.list.arraylist;

public class Employee {
    int id;
    String name;
    int yoj;

    public String getName() {
        return name;
    }

    public int getYoj() {
        return yoj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yoj=" + yoj +
                '}';
    }

    public Employee(int id, String name, int yoj) {
        this.id = id;
        this.name = name;
        this.yoj = yoj;
    }
}
