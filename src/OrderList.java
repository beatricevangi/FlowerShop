import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class OrderList implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public static OrderList ol = new OrderList();

    private OrderList() {
        init();
    }

    public static synchronized OrderList getInstance() {
        return ol;
    }

    public int getSize() {
        return orders.size();
    }

    public Order getOrder() {
        // return first uncompleted order
        int count = 0;
        for (Order order : orders) {
            if (order.isComplete()) {
                count++;
            } else {
                return orders.get(count);
            }
        }
        return null;
    }

    public void putOrder(Order o) {
        this.orders.add(o);
        writeOrderOnCSV(o);
        notify(o.getCustomer());
    }

    public void displayOrders() {
        System.out.println("Completati:");
        for (Order o : orders) {
            o.displayOrderFloristPOV();
        }
    }

    public void removeOrder(Order o) {
        this.orders.remove(o);
    }

    public void init() {
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/order.csv";
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            for (int i = 0; i < csvBody.size(); i++) {
                Customer c = Program.getInstance().getCustomerFromId(Integer.parseInt(csvBody.get(i)[2]));
                Order o = new Order(c);
                o.setComplete(Boolean.parseBoolean(csvBody.get(i)[0]));
                o.setStatus(csvBody.get(i)[3]);
                for (int j = 5; j < csvBody.get(i).length; j++) {
                    Product a = Catalog.getInstance().cloneCatalogItem(csvBody.get(i)[j], true);
                    o.addProduct(a);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error: init on Program while reading csv");
        }
    }


    @Override
    public void notify(Object obj) {
        for (Observer o : observers) {
            o.update(obj);
        }
    }

    public void printCustomerOrders(Customer c) {
        for (Order o : orders) {
            if (o.getCustomer() == c) {
                o.displayOrderCustomerPOV();
            }
        }
    }

    public void writeOrderOnCSV(Order order) {
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/orders.csv";
        try{
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();

            int n = order.getComponents().size();
            String[] neworder = new String[n + 5];
            neworder[0] = String.valueOf(order.isComplete());
            neworder[1] = String.valueOf(order.getId());
            neworder[2] = String.valueOf(order.getCustomer().getId());
            neworder[3] = String.valueOf(order.getStatus());
            neworder[4] = String.valueOf(order.getSubtotal());
            int i = 0;
            for(Product a : order.getComponents()){
                neworder[5 + i] = a.getName();
                i ++;
            }
            csvBody.add(neworder);
            reader.close();

            CSVWriter writer = new CSVWriter(new FileWriter(pathToCSV));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();


        } catch(Exception e){
            System.err.println("Error: Csv Exception");
        }

    }

    public void refreshCSV(Order o) {
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/order.csv";
        File inputFile = new File(pathToCSV);
        try {
            CSVReader reader = new CSVReader(new FileReader(pathToCSV));
            List<String[]> csvBody = reader.readAll();
            for (int i = 0; i < csvBody.size(); i++) {
                int a = o.getId();
                if (csvBody.get(i)[1] == Integer.toString(a)) {
                    csvBody.get(i)[3] = o.getStatus();
                }
            }
            reader.close();
            CSVWriter writer = new CSVWriter(new FileWriter(inputFile));
            writer.writeAll(csvBody);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.err.println("ERROR: csv exception");
        }
    }

    @Override
    public void subscribe(Observer obs) {
        observers.add(obs);
    }

    @Override
    public void unsubscribe(Observer obs) {
        observers.remove(obs);
    }
}