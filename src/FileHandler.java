//-----------------------------
//Assignment 3
//Written by: Zin Bitar 40305895 && Lasmar Khalifa 40321544
//-----------------------------
import java.io.*;
import java.util.Scanner;

public class FileHandler {

    public static Scanner createInputScanner(String fileName) {
        File file = new File(fileName);
        Scanner input = null;
        try{
            input = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
        return input;
    }

    public static PrintWriter createOutputPrintWriter(String fileName) {
        File file = new File(fileName);
        PrintWriter output = null;
        try{
        output = new PrintWriter(new FileOutputStream(fileName));
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }
        return output;
    }
}
