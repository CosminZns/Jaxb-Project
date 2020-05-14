package Model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

import java.util.ArrayList;
import java.util.Date;


public class Order {

    private Date created;
    private int id;
    private ArrayList<Product> products;


    public Order() {

    }

    public Order(Date created, int id, ArrayList<Product> products) {
        this.products = products;
        this.created = created;
        this.id = id;

    }



    @XmlElement(name = "product")
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @XmlAttribute
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }


    @XmlAttribute(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "created=" + created +
                ", id=" + id +
                ", product=" + products +
                '}';
    }

}
