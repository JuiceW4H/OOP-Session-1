package oop.pillars;

public class Main {
    public static void main(String[] args) {

        Console console = new Console("Sony", "Playstation", 4);

        System.out.println("Brand:"+ console.brand);
        System.out.println("Brand Updated");
        console.brand = "Nintendo";
        System.out.println("Brand:"+ console.brand);
        System.out.println("Model:"+ console.getModel());
        System.out.println("Series:"+ console.series);

        console.showMessage();
//
//        Dog d = new Dog();
//        d.attack();
    }
}

