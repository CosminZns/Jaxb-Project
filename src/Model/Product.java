package Model;

public class Product {

    private String description;
    private int gtin;
    private String supplier;
    private Price price;


    public Product() {

    }

    public Product(String description, int gtin, String supplier, Price price) {
        this.description = description;
        this.gtin = gtin;
        this.supplier = supplier;
        this.price = price;

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


    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "description='" + description + '\'' +
                ", gtin=" + gtin +
                ", supplier='" + supplier + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
