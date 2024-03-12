package domain;

import mapper.ProductIvaMapper;

public class ProductIva {


    private Integer id;

    private String name;

    private Double price;

    private Double priceWithIva;



    public ProductIva(Integer id, String name, Double price, Double priceWithIva) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.priceWithIva = priceWithIva;
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

    public Double getPriveWithIva() {
        return priceWithIva;
    }

    public void setPriveWithIva(Double priveWithIva) {
        this.priceWithIva = priveWithIva;
    }

    @Override
    public String toString() {
        return "ProductIva{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", priceWithIva=" + priceWithIva +
                '}';
    }
}
