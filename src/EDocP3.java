import java.util.Scanner;

public class EDocP3 {
    private static final double PI = 3.1415;
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Plotų skaičiavimas");
        rodytiMeniu();
        System.out.println("Įveskite pasirinkimą");
        inputCommand();
    }

    private static void inputCommand(){
        String a = scan.nextLine().toUpperCase();
        switch (a){
            case "A":
                trikampioPlotas();
                break;
            case "B":
                rectanPlotas();
                break;
            case "C":
                squarePlotas();
                break;
            case "D":
                circlePlotas();
                break;
                default:
                    System.out.println("Bloga įvestis");
                    break;

        }
    }

    private static void rodytiMeniu(){
        System.out.println("A: Apskaičiuotu stačiojo trikampio plotą.");
        System.out.println("B: Stačiakampio plotas");
        System.out.println("C: Kvadrato plotas");
        System.out.println("D: Apskritimo plotas");
    }

    private static void trikampioPlotas(){
        double result;
        System.out.println("Įveskite pirmą kraštinę");
        int a = Integer.parseInt(scan.nextLine());
        System.out.println("Įveskite pirmą kraštinę");
        int b = Integer.parseInt(scan.nextLine());
        result = (a*b)/2;
        System.out.println("Atsakymas: "+ result);
    }

    private static void rectanPlotas(){
        double result;
        System.out.println("Įveskite pirmą kraštinę");
        int a = Integer.parseInt(scan.nextLine());
        System.out.println("Įveskite pirmą kraštinę");
        int b = Integer.parseInt(scan.nextLine());
        result = (a*b);
        System.out.println("Atsakymas: "+ result);
    }

    private static void squarePlotas(){
        double result;
        System.out.println("Įveskite kraštinę");
        int a = Integer.parseInt(scan.nextLine());
        result = (a*a);
        System.out.println("Atsakymas: "+ result);
    }

    private static void circlePlotas(){
        double result;
        System.out.println("Įveskite spindulį");
        int a = Integer.parseInt(scan.nextLine());
        result = (a*a) * PI;
        System.out.println("Atsakymas: "+ result);
    }
}
