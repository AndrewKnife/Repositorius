import java.util.Scanner;

public class EDoc10 {



    public static void main(String[] args)
    {
        Scanner scaner = new Scanner(System.in);
        String word;
        char letter = 'a';
        int lettercount;
        System.out.println("Įveskite žodį: ");
        word = scaner.nextLine().toString();
        lettercount = CountLetters(word, letter);
        System.out.println(lettercount);
        System.out.println("Raidžių " + letter+ " Žodyje "+ word +" rasta: "+ lettercount);
    }


    private static int CountLetters(String word, char lett)
    {
        int count = 0;

        for(int i = 0; i < word.length(); i++)
        {
            if(word.charAt(i) == lett)
            {
                count ++;
            }
        }

        return count;
    }
}
