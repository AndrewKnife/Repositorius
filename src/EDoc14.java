import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EDoc14 {

    private static final String FILE_NAME="Duomenys/textas.txt";

    public static void main(String[] args) {
        boolean IsWord;

        IsWord = FindWord(FILE_NAME);
        if(IsWord){
            System.out.println("Sakinyje žodis labas yra");
        }
        else
        {
            System.out.println("Sakinyje žodžio labas nėra");
        }
    }

    private static boolean FindWord(String filename)
    {
        String line;
        boolean yra = false;
        try (BufferedReader bf = new BufferedReader(new FileReader(FILE_NAME))){
            while((line = bf.readLine())!= null) {
                if (line.contains("labas")) {
                    yra = true;
                    break;
                }
            }

        }catch (IOException e) {


        }
        return yra;

    }

}
