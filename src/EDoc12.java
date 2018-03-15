import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EDoc12 {

    private static final String FILE_NAME="vardai.txt";

    public static void main(String[] args) {

        String line;

        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME))){
            System.out.println("Vardai: ");
            while((line = bf.readLine())!= null)
            {
                System.out.println(line);
            }

        }catch (IOException e) {

        }
    }

}
