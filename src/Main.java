class Animal {
    public Animal() {
        System.out.println("Animal");
    }
}

class Dog extends Animal implements AnimalInterface {
    public Dog() {
        super();
        System.out.println("Dog");
    }

}

interface AnimalInterface {
    default void setColor(String color) {
        System.out.println("this is an animal : " + color);
    }

    default void setColor(String color, int a) {
        System.out.println("this is an animal : " + color + a);
    }
}

interface Animal2 extends  AnimalInterface {
    default void setColor(String color) {
        System.out.println("there is an animal : " + color);
    }
}

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog();

    }
}