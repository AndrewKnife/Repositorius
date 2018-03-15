import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Numbers {

    private String filename;

    Numbers(String filename){
        this.filename = filename;
    }

    public void PrintList() {
        List<Integer> lis = GetNumbers();
        System.out.println("Visi skaičiai: ");
        for(int x: lis){
            System.out.println(x);
        }
        System.out.println("Šių skaičių suma: " + NumberSum(lis));

    }

    private List<Integer> GetNumbers()
    {
        String line;
        String[] values = null;
        List<Integer> listas = new ArrayList<>();
        int[] numbers;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            while ((line = br.readLine()) != null) {
                values = line.split(" ");
                for(String a: values)
                {
                    listas.add(Integer.parseInt(a));
                }
            }
            return listas;

        } catch (IOException e) {

        }
        return listas;
    }

    private int NumberSum(List<Integer> listas){
        int result=0;
        for(int a: listas){
            result += a;
        }
        return result;
    }
}

public class EDoc19 {

    public static void main(String[] args){
        Numbers skai = new Numbers("Duomenys/Numbers.txt");
        skai.PrintList();

    }
}
