import java.util.Scanner;

public class EDoc2 {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String textnrcount = "Įveskite keik skaičių rašysite: ";
        String textin = "Įveskite skaičių:  ";
        int numbercount;
        int[] allnumbers;

        System.out.println(textnrcount);
        numbercount = Integer.parseInt(scan.nextLine());
        allnumbers = new int[numbercount];
        for(int i = 0; i < numbercount; i++)
        {
            System.out.println(textin);
            allnumbers[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Jūsų skaičiai didesni už 100: ");
        for(int i = 0; i < allnumbers.length; i++)
        {
            if(allnumbers[i] >= 100)
            {
                System.out.println(allnumbers[i]);
            }
        }
    }
}
