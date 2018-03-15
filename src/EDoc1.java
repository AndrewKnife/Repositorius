import java.util.Scanner;

public class EDoc1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Labas Pasaulis!");
        String texteven = "Lyginis";
        String textodd = "Nelyginis";
        String textfail = "Neteisinga įvestis";

        double taip;
        double dalinasi;
        try {
            taip = Double.parseDouble(scanner.nextLine());
            dalinasi = taip % 2;
            if(dalinasi==0) {
                System.out.println(texteven);
            }
            else
            {
                System.out.println(textodd);
            }
        }
        catch(Exception e){
            System.out.println(textfail);
        }


    }
}
