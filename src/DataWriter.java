import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class DataWriter {

    public static void write(String card_number, String password, String outfile, int funds){
        try {
            ReaderDataFromFile r = new ReaderDataFromFile();
            r.read("data.txt");
            r.setFunds(card_number, password, funds);
            PrintWriter printWriter = new PrintWriter(new File(outfile));
            for (int i = 0; i < r.sizeUserList(); i++) {
                printWriter.write(r.getUser(i).getInfo() + "\n");
            }
            printWriter.close();
        } catch (IOException exception){
            System.out.println("Error -> " + exception.getMessage());
        }
    }

}
