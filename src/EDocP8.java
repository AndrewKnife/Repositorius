import java.util.Random;
import java.util.Scanner;

public class EDocP8 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("High - Low");
        printMenu();
        menuSelect();

    }

    private static void menuSelect(){
        String a;
        boolean fin = false;
        while (!fin) {
            a = scan.nextLine();
            a = a.toUpperCase();
            switch (a) {
                case "A":
                    playGame(10);
                    fin = true;
                    break;
                case "B":
                    playGame(100);
                    fin = true;
                    break;
                case "C":
                    playGame(1000);
                    fin = true;
                    break;
                    default:
                        System.out.println("Pasirinkite iš naujo: ");
            }
        }
    }

    private static void printMenu(){
        System.out.println("Pasirinkite sunkumą");
        System.out.println("A: Lengvas");
        System.out.println("B: Vidutinis");
        System.out.println("C: Sunkus");
    }

    private static void playGame(int diff){
        Random ran = new Random();
        int playerNum;
        int max = ran.nextInt(diff);
        int tries=0;
        while (true){
            System.out.println("Spėkite skaičių tarp 0 ir "+diff+": ");
            try {
                playerNum = scan.nextInt();
                tries++;
                if(playerNum == max){
                    break;
                }
                else if(playerNum > max){
                    System.out.println("Low");
                }
                else{
                    System.out.println("High");
                }
            }
            catch (Exception e){
                System.out.println("Neteisinga įvestis: ");
            }
        }
        System.out.println("Sveikiname !!! Jūs skaičių atspėjote per "+tries+" kartų");
    }
}
