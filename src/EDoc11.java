import java.util.Scanner;

public class EDoc11 {



    public static void main(String[] args)
    {
        Scanner scaner = new Scanner(System.in);
        String word;
        char[] letters = {'a','b'}; // raidžių derinys
        int lettercount;
        System.out.println("Įveskite žodį: ");
        word = scaner.nextLine().toString();
        lettercount = CountLetters(word, letters);
        System.out.println(lettercount);
        System.out.println("Raidžių derinių : " + letters[0] + letters[1]+ " Žodyje: "+ word +" rasta: "+ lettercount);
    }


    private static int CountLetters(String word, char[] lett)
    {
        int count = 0;

        for(int i = 0; i < word.length(); i++)
        {

            if(word.charAt(i) == lett[0])
            {
                if(word.charAt(i+1) == lett[1])
                {
                    count ++;
                }
            }
        }

        return count;
    }
}
