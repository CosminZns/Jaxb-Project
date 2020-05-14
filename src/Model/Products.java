package Model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Products {

    private ArrayList<ProductForSupplier> product;



    public Products() {

    }

    public Products(ArrayList<ProductForSupplier> product) {
        this.product = product;
    }

    public ArrayList<ProductForSupplier> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<ProductForSupplier> product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "products=" + product +
                '}';
    }
}
