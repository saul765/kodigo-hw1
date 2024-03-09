package domain;

import enums.CometProductKey;

public class CometProduct {


    private Integer id;

    private String name;

    private Double price;

    private CometProductKey key;


    public CometProduct(Integer id, String name, Double price, CometProductKey key) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.key = key;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CometProductKey getKey() {
        return key;
    }

    public void setKey(CometProductKey key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", key=" + key
                ;
    }
}
