import java.util.Scanner;

public class EDocP1 {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int letters;
        int a = 0;
        String word;
        boolean pabaiga = false;
        while (!pabaiga){
            System.out.println("Įveskite (pabaiga) norint užbaigti rašymą");
            System.out.println("Įveskite žodį");
            word = scan.nextLine();
            if(word.toUpperCase().equals("PABAIGA")){
                pabaiga = true;
                break;
            }
            for(int i = 0; i < word.length();i++){
                if(word.charAt(i)== 'a'){
                    a++;
                }
            }
            System.out.println(word);
            letters = word.length();
            if (letters % 2 == 0){
                System.out.println(word + " yra lyginis, ilgiu("+word.length()+") ir turintis "+a+" [a] raid.");
            }
            else{
                System.out.println(word + " yra nelyginis, ilgiu("+word.length()+") ir turintis "+a+" [a] raid.");

            }
        }
    }
}
