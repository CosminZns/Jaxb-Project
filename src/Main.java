import javax.xml.bind.JAXBException;
import java.text.ParseException;


public class Main {

    public static void main(String[] args) throws JAXBException, ParseException {

        OrdersJaxb ordersJaxb = new OrdersJaxb();
        OrdersJaxb ordersJaxb2 = new OrdersJaxb(ordersJaxb.unmarshall());
        ordersJaxb2.export();

    }
}
