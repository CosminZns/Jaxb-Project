import Model.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

import java.util.*;

public class OrdersJaxb {
    private OrderList orderList;

    public OrdersJaxb() {

    }

    public OrdersJaxb(OrderList orderList) {
        this.orderList = orderList;

    }

    //Unmarhalling or importing a xml file to an object
    public OrderList unmarshall() throws JAXBException {
        String path = "src\\InputFiles\\orders23.xml";
        File file = new File(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(OrderList.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        OrderList orderList = (OrderList) unmarshaller.unmarshal(file);
        return this.orderList = orderList;
    }
    //Marhalling or importing a xml file to an object
    public void marshall(String path, Object object) throws JAXBException {
        JAXBContext jaxbContext1 = JAXBContext.newInstance(Products.class);
        Marshaller marshaller = jaxbContext1.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, new File(path));
    }
    //Return the pattern speficic for files names
    public char[] returnPattern() {
        String path = "src\\InputFiles\\orders23.xml";
        char[] pattern = path.toCharArray();
        char[] pattern1 = path.toCharArray();
        pattern1[0] = pattern[pattern.length - 6];
        pattern1[1] = pattern[pattern.length - 5];
        return pattern1;
    }

    //Sorting orders by date and then by price
    public void sortOrders() {
        orderList.getOrders().sort(new Comparator<Order>() {
            @Override
            //Sort by date
            public int compare(Order o1, Order o2) {
                int comp = 0;
                comp = o1.getCreated().compareTo(o2.getCreated());
                //If comp=0, the date are equal and we sort by price
                if (comp == 0) {
                    orderList.getOrders().get(0).getProducts().sort(new Comparator<Product>() {
                        @Override
                        //Sort by price
                        public int compare(Product o1, Product o2) {
                            return o1.getPrice().getPriceDouble().compareTo(o2.getPrice().getPriceDouble());
                        }
                    });
                }
                return comp;
            }
        });
        //Reverse from ascending order to descending
        Collections.reverse(orderList.getOrders());
    }
//Return a list of products from a specific supplier
    public ArrayList<Product> returnSupplierProducts(String supplierName) throws JAXBException {
        ArrayList<Product> products = new ArrayList<>();
        for (int i = 0; i < orderList.getOrders().size(); i++) {
            for (int j = 0; j < orderList.getOrders().get(i).getProducts().size(); j++) {
                if (orderList.getOrders().get(i).getProducts().get(j).getSupplier().equals(supplierName)) {
                    products.add(orderList.getOrders().get(i).getProducts().get(j));
                }
            }
        }
        return products;
    }
//Creating product list to export
    public void createProductList(ArrayList<Order> orders, String path, ArrayList<Product> products) throws JAXBException {
        ArrayList<ProductForSupplier> productForSuppliers = new ArrayList<>();
        if (products.size() == 1) {
            int id = orders.get(0).getId();
            String desription = products.get(0).getDescription();
            int gtin = products.get(0).getGtin();
            Price price = products.get(0).getPrice();
            ProductForSupplier productForSupplier = new ProductForSupplier(desription, gtin, price, id);
            productForSuppliers.add(productForSupplier);
        } else {
            for (int i = 0; i < orders.size(); i++) {
                int id = orders.get(i).getId();
                String desription = products.get(i).getDescription();
                int gtin = products.get(i).getGtin();
                Price price = products.get(i).getPrice();
                ProductForSupplier productForSupplier = new ProductForSupplier(desription, gtin, price, id);
                productForSuppliers.add(productForSupplier);
            }
        }
        Products productList = new Products(productForSuppliers);
        marshall(path, productList);
    }

//Exporting the files to the specified folder
    public void export() throws JAXBException {
        ArrayList<String> names=returnSuppliersNames();
        String supplierName=null;
        String path=null;
        for (String name : names) {
            supplierName = name;
            path = "src\\ExportFiles\\" + supplierName + returnPattern()[0] + returnPattern()[1] + ".xml";
            sortOrders();
            createProductList(orderList.getOrders(), path, returnSupplierProducts(supplierName));
        }
        System.out.println("The files were exported");
    }

    //Return suppliers names
    public ArrayList<String> returnSuppliersNames() {
        //Adding all the names to a list
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < orderList.getOrders().size(); i++) {
            for (int j = 0; j < orderList.getOrders().get(i).getProducts().size(); j++) {
                names.add(orderList.getOrders().get(i).getProducts().get(j).getSupplier());
            }
        }
        //Remove duplicates from the list
        ArrayList<String> nameRemoveDuplicates= new ArrayList<>();
        for (String name : names) {
            if (!nameRemoveDuplicates.contains(name)){
                nameRemoveDuplicates.add(name);
            }
        }
       return nameRemoveDuplicates;
    }
}

