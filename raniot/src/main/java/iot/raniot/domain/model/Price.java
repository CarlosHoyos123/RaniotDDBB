package iot.raniot.domain.model;

public class Price {
    private int id ;
    private int price;

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public Price(int id, int price) {
        this.id = id;
        this.price = price;
    }
}
