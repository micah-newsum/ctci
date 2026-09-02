package chapter3;

public abstract class Animal {
    protected String name;
    private int order;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal animal) {
       return this.order < animal.order;
    }

    public String toString() {
        return "{name=" + name + ", order=" + order + "}";
    }
}
