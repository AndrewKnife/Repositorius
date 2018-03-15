import java.util.Scanner;

public class EDocP2 {

    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String word;
        String wb ="";
        System.out.println("Įveskite žodį: ");
        word = scan.nextLine();
        word = word.replace(" ","");
        for(int i = (word.length() -1); i>=0;i--){
            wb += String.valueOf(word.charAt(i));
        }
        if(word.equals(wb)){
            System.out.println("Jūsų įvestas žodis yra polindromas");
        }else{
            System.out.println("Jūsų įvestas žodis nėra polindromas");
        }

    }
}
