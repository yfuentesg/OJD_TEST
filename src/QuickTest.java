
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class QuickTest {

    public static void main(String[] args) {
        Path path = Path.of("C:\\Users\\HP user\\Downloads\\VALGRIND\\corpusagerep-valgrind_202301301259.txt");

        try {
            String line;
            BufferedReader br = Files.newBufferedReader(path);
            boolean printNextLine = false;
            int numberLinesPrinted = 0;
            int lineNumber = 0;
            while ((line = br.readLine()) != null) {
                lineNumber++;
                if (line.equals("==27063== ")) {
                    printNextLine = true;
                    continue;
                }

                if (printNextLine) {
                    System.out.println(lineNumber + ": " + line);
                    
                    if (numberLinesPrinted++ >= 2) {
                        printNextLine = false;   
                        numberLinesPrinted = 0;
                    }
                    
                }                
            }
            br.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
