import java.util.Arrays;
import java.util.Scanner;

public class EDoc3 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        boolean arnulis = false;
        int sk = 1;
        int[] skar = new int[0];
        int suma;

        System.out.println("Skaičiuoti sveikų skaičių sumą");
        System.out.println("Norint pabaigti skaičių vedimą, įveskite : '0'");

        while(sk != 0)
        {

            try {
                System.out.println("Veskite kitą skaičių: ");
                sk = Integer.parseInt(scan.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("Klaidingas skaičius, prašome vesti iš naujo: ");
            }
            skar = Arrays.copyOf(skar, skar.length +1);
            skar[skar.length-1] = sk;
        }
        System.out.println("Jūsų skaičių suma: ");
        suma = MasyvoSuma(skar);
        System.out.println(suma);
    }

    private static int MasyvoSuma(int[] mas){
        int sum = 0;
        for (int a: mas)
        {
            sum += a;
        }
        return sum;
    }

}
