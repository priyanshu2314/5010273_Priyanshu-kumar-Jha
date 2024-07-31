import java.util.*;

class Product {
    private int productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(int productId, String productName, double price, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{productId=" + productId + ", productName='" + productName + "', price=" + price + ", quantity=" + quantity + "}";
    }
}

class ProductManager {
    private Map<Integer, Product> products;

    public ProductManager() {
        this.products = new HashMap<>();
    }

    public void addProduct(int productId, String productName, double price, int quantity) {
        Product product = new Product(productId, productName, price, quantity);
        products.put(productId, product);
    }

    public void updateProduct(int productId, String productName, Double price, Integer quantity) {
        Product product = products.get(productId);
        if (product != null) {
            if (productName != null) {
                product.setProductName(productName);
            }
            if (price != null) {
                product.setPrice(price);
            }
            if (quantity != null) {
                product.setQuantity(quantity);
            }
        }
    }

    public void deleteProduct(int productId) {
        products.remove(productId);
    }

    public Product getProduct(int productId) {
        return products.get(productId);
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.addProduct(1, "Peanut butter", 479, 5);
        productManager.addProduct(2, "Oats", 203, 10);

        System.out.println("All Products:");
        for (Product product : productManager.getAllProducts()) {
            System.out.println(product);
        }

        System.out.println("\nUpdating product 1");
        productManager.updateProduct(1, "Organic Peanut Butter", 499.99, 7);
        System.out.println(productManager.getProduct(1));

        System.out.println("\nDeleting product 2");
        productManager.deleteProduct(2);
        System.out.println("All Products:");
        for (Product product : productManager.getAllProducts()) {
            System.out.println(product);
        }
    }
}
