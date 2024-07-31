class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{orderId=" + orderId + ", customerName='" + customerName + "', totalPrice=" + totalPrice + "}";
    }
}

class OrderManager {
    private Order[] orders;
    private int size;

    public OrderManager(int capacity) {
        orders = new Order[capacity];
        size = 0;
    }

    public void addOrder(int orderId, String customerName, double totalPrice) {
        if (size < orders.length) {
            orders[size++] = new Order(orderId, customerName, totalPrice);
        }
    }

    public void bubbleSortByTotalPrice() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public void quickSortByTotalPrice() {
        quickSort(0, size - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public Order[] getOrders() {
        return orders;
    }

    public int getSize() {
        return size;
    }
}

public class SortingCustomerOrders {
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager(10);

        orderManager.addOrder(1, "Priyanshu", 250.0);
        orderManager.addOrder(2, "Sneha", 150.0);
        orderManager.addOrder(3, "Harshit", 300.0);
        orderManager.addOrder(4, "Rahul", 200.0);

        System.out.println("Orders:");
        printOrders(orderManager.getOrders(), orderManager.getSize());

        System.out.println("\nBubble Sort:");
        orderManager.bubbleSortByTotalPrice();
        printOrders(orderManager.getOrders(), orderManager.getSize());

        orderManager.addOrder(5, "Subhashish", 100.0);
        System.out.println("\nQuick Sort:");
        orderManager.quickSortByTotalPrice();
        printOrders(orderManager.getOrders(), orderManager.getSize());
    }

    private static void printOrders(Order[] orders, int size) {
        for (int i = 0; i < size; i++) {
            System.out.println(orders[i]);
        }
    }
}
