import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddingAToy {
    public static void main(String args[]) throws IOException{
        try (FileWriter fileWriter = new FileWriter("Toys.csv", true)) {
            StringBuilder sb = new StringBuilder();
            try (Scanner scan = new Scanner(System.in)) {
                try (Scanner sc = new Scanner(System.in)) {
                    System.out.println( "Enter toy ID: ");
                    int i = scan.nextInt();
                    System.out.println( "Enter toy name: ");
                    String name = sc.nextLine();
                    sb.append(i);
                    sb.append(',');
                    sb.append(name);
                    //sb.append('\n');
                }
            }
            sb.append(System.lineSeparator())
                    .toString();
            fileWriter.append(sb);
            System.out.println("Done!");
            

            } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        AddingAToy addingAToy =  new AddingAToy();
        addingAToy.readCSVFile();
}

public void readCSVFile(){
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Toys.csv"));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(records.toString());
    }
    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}