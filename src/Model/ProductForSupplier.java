package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductForSupplier {

    private String description;
    private int gtin;
    private Price price;
    private int id;


    public ProductForSupplier() {

    }

    public ProductForSupplier(String description, int gtin, Price price, int id) {
        this.description = description;
        this.gtin = gtin;
        this.price = price;
        this.id = id;

    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getGtin() {
        return gtin;
    }

    public void setGtin(int gtin) {
        this.gtin = gtin;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
