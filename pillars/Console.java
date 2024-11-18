package oop.pillars;

public class Console {

    public String brand;

    private String model;

    protected int series;

    String message="Congrats on your brand new";

    public Console(String brand, String model, int series){
        this.brand=brand;
        this.model=model;
        this.series=series;
    }

    public void setModel(String model){
        this.model=model;
    }

    public String getModel(){
        return model;
    }

    void showMessage() {
        System.out.println(message + " " + brand + " " + model + " " + series);
    }
}