package oop;

public abstract class BaseEntity implements Validatable, Scorable{
    protected int id;
    protected String name;

    public BaseEntity(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // concrete method
    public void printInfo() {
        System.out.println("Entity #" + id + " | name=" + name);
    }

    // 2 abstract methods (требование задания)
    public abstract String getType();
    public abstract double getScore();
}
