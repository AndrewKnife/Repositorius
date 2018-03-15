import java.util.Scanner;

public class EDoc4 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        int sk = 0;
        int suma = 0;
        System.out.println("Įveskite 5 skaičius: ");
        for(int i = 0; i < 5; i++)
        {
            boolean isnumber = false;
            while(isnumber == false)
            {
                try {
                    System.out.println("Įveskite " + (i+1) + " skaičių: ");
                    sk = Integer.parseInt(scan.nextLine());
                    isnumber = true;
                } catch (Exception e)
                {
                    System.out.println("Jūsų įvestyje buvo klaidų");
                    isnumber = false;
                }
            }
            suma += sk;

        }
        System.out.println("Jūsų skaičių suma: " + suma);
    }
}
