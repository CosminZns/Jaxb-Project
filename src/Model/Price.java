package Model;

import javax.xml.bind.annotation.*;


public class Price  {


    private String currency;
    private String price;

    public Price(){

    }
    public Price(String currency, String price) {
        this.price=price;
        this.currency = currency;

    }

    @XmlValue
   public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }
    @XmlAttribute
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public Double getPriceDouble(){
        return Double.parseDouble(price);
    }


    @Override
    public String toString() {
        return "Price{" +
                "currency='" + currency + '\'' +
                ", price=" + price +
                '}';
    }
}
