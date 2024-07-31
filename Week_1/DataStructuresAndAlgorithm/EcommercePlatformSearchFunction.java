import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{productId=" + productId + ", productName='" + productName + "', category='" + category + "'}";
    }
}

class ProductManager {
    private Product[] products;
    private Product[] sortedProducts;
    private int size;

    public ProductManager(int capacity) {
        products = new Product[capacity];
        sortedProducts = new Product[capacity];
        size = 0;
    }

    public void addProduct(int productId, String productName, String category) {
        Product product = new Product(productId, productName, category);
        products[size] = product;
        sortedProducts[size] = product;
        size++;
        sortProducts();
    }

    private void sortProducts() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (sortedProducts[j].getProductName().compareToIgnoreCase(sortedProducts[j + 1].getProductName()) > 0) {
                    Product temp = sortedProducts[j];
                    sortedProducts[j] = sortedProducts[j + 1];
                    sortedProducts[j + 1] = temp;
                }
            }
        }
    }

    public Product linearSearch(String productName) {
        for (int i = 0; i < size; i++) {
            if (products[i].getProductName().equalsIgnoreCase(productName)) {
                return products[i];
            }
        }
        return null;
    }

    public Product binarySearch(String productName) {
        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = sortedProducts[mid].getProductName().compareToIgnoreCase(productName);
            if (cmp == 0) {
                return sortedProducts[mid];
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public Product[] getAllProducts() {
        return Arrays.copyOf(products, size);
    }
}

public class EcommercePlatformSearchFunction {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager(10);

        productManager.addProduct(1, "Oats", "Packaged foods");
        productManager.addProduct(2, "Peanut butter", "Health supplements");
        productManager.addProduct(3, "Whey Protein", "Health supplements");
        productManager.addProduct(4, "Mixer grinder", "Electronics");

        System.out.println("Linear Search:");
        System.out.println(productManager.linearSearch("Oats"));

        System.out.println("Binary Search:");
        System.out.println(productManager.binarySearch("Mixer grinder"));
    }
}
