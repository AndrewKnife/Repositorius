import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EDoc16 {

    private static final String FILE_NAME="vardai.txt";

    public static void main(String[] args) {
        String[] vardai = GetNames(FILE_NAME);
        PrintNames(vardai);
    }

    private static String[] GetNames(String filename)
    {
        String[] names = null;
        String lines ="" ;
        String line;
        try (BufferedReader bf = new BufferedReader(new FileReader(filename))){
            while((line = bf.readLine())!= null)
            {
                lines += line + " ";
            }
            names = lines.split(" ");
            return names;

        }catch (IOException e) {

        }

        return names;
    }

    private static void PrintNames(String[] array){
        for(String name: array)
        {
            System.out.println(name);
        }
    }

}
