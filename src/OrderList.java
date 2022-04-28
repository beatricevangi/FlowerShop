import java.io.*;
import java.util.ArrayList;

public class OrderList implements Subject {
    private ArrayList<Observer> observers = new ArrayList<>();
    private ArrayList<Order> orders = new ArrayList<>();
    public static OrderList ol = new OrderList();

    private OrderList(){
        init();

    }

    public static synchronized OrderList getInstance(){
        return ol;
    }

    public int getSize(){
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

    public void displayOrders(){
        System.out.println("Completati:");
        for(Order o : orders){
            o.displayOrderFloristPOV();
        }
    }

    public void removeOrder(Order o) {
        this.orders.remove(o);
    }

    public void init(){
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/order.csv";
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader(pathToCSV));
            String row = csvReader.readLine();
            while ((row) != null) {
                String[] data = row.split(";");
                //Order o = new Order(data[0], data[2], data[3], data[4], data[5], false);
                //users.add(f);

                row = csvReader.readLine();
            }
            csvReader.close();
        } catch (IOException e) {
            System.err.println("Error");
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

    public void writeOrderOnCSV(Order order){
        String pathToCSV = "/home/beatrice/Scrivania/VICARIO/FlowerShop/orders.csv";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(pathToCSV, true));
        } catch (IOException e) {
            System.err.println("Error");
        }
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append(order.getId() + ";" + order.getCustomer().getId() + ";" + order.getStatus() + ";" + order.getSubtotal() + ";");
        for(Product a : order.getComponents())
            builder.append(a);
        pw.write(builder.toString());
        pw.close();
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