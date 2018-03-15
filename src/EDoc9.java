import java.util.Scanner;

public class EDoc9 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        int sk;
        int ats;

        System.out.println("Įveskite x : ");
        sk = Integer.parseInt(scan.nextLine());
        ats = Funkcija(sk);
        System.out.println("Atsakymas: " + ats);
    }

    public static int Funkcija(int x)
    {
        int ats = 0;

        if(x%2 == 0)
        {
            ats = (2*x)+8;

        }
        else
        {
            ats = 21 - (7*x);
        }
        return ats;
    }
}
