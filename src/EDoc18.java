import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFile {
    private String filename;

    ReadFile(String filename) {
        this.filename = filename;
    }

    public void printData() {
        String[] lines = read();
        for (String a : lines) {
            System.out.println(a);
        }
    }

    private String[] read() {
        String[] names = null;
        String line;
        String lines = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {
                lines += line + " ";
            }
            names = lines.split(" ");
            return names;
        } catch (IOException e) {

        }
        return names;
    }
}

public class EDoc18 {

    public static void main(String[] args){
        ReadFile readeris = new ReadFile("vardai.txt");
        readeris.printData();
    }
}
