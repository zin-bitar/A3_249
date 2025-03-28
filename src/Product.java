public class Product {
    private String name;
    private String country;
    private String category;
    private double price;

    public Product() {
        this.name = "";
        this.country = "";
        this.category = "";
        this.price = 0.0;
    }

    public Product(String name, String country, String category, double price) {
        this.name = name;
        this.country = country;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }



}
