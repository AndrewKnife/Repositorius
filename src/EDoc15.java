import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EDoc15 {

    private static final String FILE_NAME="Duomenys/textas.txt";

    public static void main(String[] args) {
        int wordcount = CountWords(FILE_NAME);
        System.out.println("Žodžių sakinyje: " + wordcount);

    }

    private static int CountWords(String filename)
    {
        int wordcount = 0;
        String[] words;
        String lines = "";
        String line;
        boolean yra = false;
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME))){
            while((line = bf.readLine())!= null) {
                lines+= line;
            }
            words = lines.split(" ");
            wordcount = words.length +1;
            return wordcount;


        }catch (IOException e) {


        }
        return wordcount;

    }

}
