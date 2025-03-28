import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = FileHandler.createInputScanner("TradeData.txt");
        while(scanner.hasNextLine()){
            String name = scanner.next();
            String country = scanner.next();
            String category = scanner.next();
            double price = scanner.nextDouble();
        }






    }
}