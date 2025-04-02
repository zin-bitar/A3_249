import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TariffList list1 = new TariffList();
        TariffList list2;
        Scanner tariffsScanner = FileHandler.createInputScanner("src/Tariffs.txt");


        //For the products (Part 1)
        ArrayList<Product> products = new ArrayList<Product>();
        Scanner scanner = FileHandler.createInputScanner("src/TradeData.txt");
        while (scanner.hasNextLine()) {
            String[] data = scanner.nextLine().split(",");
            String name = data[0];
            String country = data[1];
            String category = data[2];
            double price = Double.parseDouble(data[3]);
            Product product = new Product(name, country, category, price);
            products.add(product);
        }
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getCountry().equals("China")) {
                product.setPrice(product.getPrice() * 1.25);
            } else if (product.getCountry().equals("USA") && product.getCategory().equals("Electronics")) {
                product.setPrice(product.getPrice() * 1.1);
            } else if (product.getCountry().equals("Japan") && product.getCategory().equals("Automobiles")) {
                product.setPrice(product.getPrice() * 1.15);
            } else if (product.getCountry().equals("India") && product.getCategory().equals("Agriculture")) {
                product.setPrice(product.getPrice() * 1.05);
            } else if (product.getCountry().equals("South Korea") && product.getCategory().equals("Electronics")) {
                product.setPrice(product.getPrice() * 1.08);
            } else if (product.getCountry().equals("Saudi Arabia") && product.getCategory().equals("Energy")) {
                product.setPrice(product.getPrice() * 1.12);
            } else if (product.getCountry().equals("Germany") && product.getCategory().equals("Manufacturing")) {
                product.setPrice(product.getPrice() * 1.06);
            } else if (product.getCountry().equals("Bangladesh") && product.getCategory().equals("Textile")) {
                product.setPrice(product.getPrice() * 1.04);
            } else if (product.getCountry().equals("Brazil") && product.getCategory().equals("Agriculture")) {
                product.setPrice(product.getPrice() * 1.09);
            }
        }

        products.sort((a, b) -> a.getCountry().compareTo(b.getCountry()));

        PrintWriter writer = FileHandler.createOutputPrintWriter("UpdatedTradeData.txt");
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            writer.print(product.getName() + "," + product.getCountry() + "," + product.getCategory() + "," + product.getPrice());
        }
        scanner.close();
        writer.close();

        //for part 2:
        while (tariffsScanner.hasNextLine()) {
            String[] data = tariffsScanner.nextLine().split(" ");
            String destinationCountry = data[0];
            String originCountry = data[1];
            String productCategory = data[2];
            double minimumTariff = Double.parseDouble(data[3]);
            Tariff tariff = new Tariff(destinationCountry, originCountry, productCategory, minimumTariff);
            if (!(list1.contains(tariff.getOriginCountry(), tariff.getOriginCountry(), tariff.getProductCategory()))) {
                list1.addToStart(tariff);
            }
        }

        Scanner requestScanner = FileHandler.createInputScanner("src/TradeRequests.txt");
        while (requestScanner.hasNextLine()) {
            String[] data = requestScanner.nextLine().split(" ");
            String requestID = data[0];
            String originCountry = data[1];
            String destinationCountry = data[2];
            String productCategory = data[3];
            double tradeValue = Double.parseDouble(data[4]);
            double proposedTariff = Double.parseDouble(data[5]);
            TariffList.TariffNode node = list1.find(originCountry, destinationCountry, productCategory);
            if (node == null) {
                System.out.println(requestID + " - Rejected.");
                System.out.println("No matching tariff rule found.");
                System.out.println();
            } else {
                double minimumTariff = node.getTariff().getMinimumTariff();
                String status = list1.evaluateTrade(proposedTariff, minimumTariff);

                if(status.equals("Accepted")){
                    System.out.println(requestID + " - Accepted." + "\n" +
                            "Proposed tariff meets or exceeds the minimum requirement.");
                }
                else if(status.equals("Rejected")){
                    System.out.println(requestID + " - Rejected." + "\n" +
                            "Proposed tariff" + proposedTariff + "% is more than 20% below the required minimum tariff " + minimumTariff + "%.");
                }
                else if(status.equals("Conditional")){
                    double surcharge = tradeValue*((minimumTariff - proposedTariff)/100);
                    System.out.println(requestID + " - Conditionally Accepted." + "\n" +
                            "Proposed tariff " + proposedTariff + " is within 20% of the required minimum tariff " + minimumTariff + "%." + "\n" +
                            "A surcharge of $" + surcharge + " is applied.");
                }

            }
        }

        requestScanner.close();
        list1.outputList();
        list2 = new TariffList(list1);
        list2.outputList();
        Tariff test = new Tariff("Syria", "Lebanon", "Water Bottle", 28);
        list2.insertAtIndex(test, 1);
            System.out.println(list2);
    }}