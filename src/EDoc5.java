import java.util.Scanner;

public class EDoc5 {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args)
    {
        String word ;
        String sentence = null;
        System.out.println("Įveskite 5 žodžius: ");
        for(int i = 0; i < 5; i++) {
            System.out.println("Įveskite "+ (i+1) +" Žodį: ");
            word = scan.nextLine();
            if(sentence == null)
            {
                sentence = word;
            }
            else
            {
                sentence += " "+ word;
            }

        }
        System.out.println("Jūsų sakinys: " + sentence);
    }
}
