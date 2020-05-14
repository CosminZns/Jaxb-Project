package Model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement(name = "orders")
public class OrderList {

    private ArrayList<Order> orders;


    public OrderList() {

    }

    public OrderList(ArrayList<Order> orders) {
        this.orders = orders;

    }


    @XmlElement(name = "order")
    public ArrayList<Order> getOrders() {
        return orders;
    }

    public void setOrders(ArrayList<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orders=" + orders +
                '}';
    }

}
