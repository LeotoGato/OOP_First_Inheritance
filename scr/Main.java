//С наследованием, Product наследуется от Item
class Item {
    private String name;
    private String category;
    private double price;

    public Item(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }
}

class Product extends Item {
    public Product(String name, String category, double price) {
        super(name, category, price);
    }
}


class Order {
    private int number;
    private Client client;
    private Item[] items; // Массив товаров в заказе
    private int itemCount = 0;

    public Order(int number, Client client, int capacity) {
        this.number = number;
        this.client = client;
        this.items = new Item[capacity];
    }

    public void addItem(Item item){
        if(itemCount < items.length){
            items[itemCount++] = item;
        } else {
            System.out.println("Order is full!");
        }
    }

    public int getNumber() {
        return number;
    }

    public Client getClient() {
        return client;
    }

    public Item[] getItems() { return items; }

}

class Delivery {
    private Order order;
    private String courier;

    public Delivery(Order order, String courier) {
        this.order = order;
        this.courier = courier;
    }

    public Order getOrder() {
        return order;
    }

    public String getCourier() {
        return courier;
    }
}

class Client {
    private String name;

    public Client(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Иван Иванов");
        Order order = new Order(123, client, 2); // Заказ может содержать 2 товара
        Product product1 = new Product("iPhone 14", "Смартфоны", 999.99);
        Product product2 = new Product("AirPods Pro", "Наушники", 199.99);
        order.addItem(product1);
        order.addItem(product2);
        Delivery delivery = new Delivery(order, "Петр Сидоров");

        System.out.println("Заказ №" + delivery.getOrder().getNumber() +
                " клиента " + delivery.getOrder().getClient().getName() +
                " содержит товары:");
        for(Item item : delivery.getOrder().getItems()){
            if(item != null){
                System.out.println("  - " + item.getName() +
                        " (" + item.getCategory() + "), цена: " + item.getPrice());
            }
        }
        System.out.println("Доставка осуществляется курьером: " + delivery.getCourier());
    }
}