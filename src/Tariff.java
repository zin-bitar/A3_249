public class Tariff {
    private String name;
    private String country;
    private String category;
    private String price;

    public Tariff() {
        this.name = "";
        this.country = "";
        this.category = "";
        this.price = "";
    }

    public Tariff(String name, String country, String category, String price) {
        this.name = name;
        this.country = country;
        this.category = category;
        this.price = price;
    }


}
