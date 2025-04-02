public class Tariff {

    private String destinationCountry;
    private String originCountry;
    private String productCategory;
    private double minimumTariff;

    public Tariff(){
        destinationCountry = "";
        originCountry = "";
        productCategory = "";
        minimumTariff = 0.0;
    }

    public Tariff(String destinationCountry, String originCountry, String productCategory, double minimumTariff) {
        this.destinationCountry = destinationCountry;
        this.originCountry = originCountry;
        this.productCategory = productCategory;
        this.minimumTariff = minimumTariff;
    }

    public Tariff(Tariff copy){
        this.destinationCountry = copy.getDestinationCountry();
        this.originCountry = copy.getOriginCountry();
        this.productCategory = copy.getProductCategory();
        this.minimumTariff = copy.getMinimumTariff();
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public double getMinimumTariff() {
        return minimumTariff;
    }

    public void setMinimumTariff(double minimumTariff) {
        this.minimumTariff = minimumTariff;
    }

    public Tariff clone(){
        Tariff copy = new Tariff(this);
        this.destinationCountry = copy.getDestinationCountry();
        this.originCountry = copy.getOriginCountry();
        this.productCategory = copy.getProductCategory();
        this.minimumTariff = copy.getMinimumTariff();
        return copy;
    }

    public String toString(){
        return "destination: " + destinationCountry + "origin: " + originCountry + "category: " + productCategory + "mininmum Tariff: " + minimumTariff;
    }
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return this.destinationCountry.equals(tariff.destinationCountry) && this.originCountry.equals(tariff.originCountry) && this.productCategory.equals(tariff.productCategory) && this.minimumTariff == tariff.minimumTariff;
    }

}
