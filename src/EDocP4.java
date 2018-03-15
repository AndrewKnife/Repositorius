import java.util.Scanner;

public class EDocP4 {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        double[] dom;
        System.out.println("KMI skaičiuoklė");
        dom = gautiDuomenis();
        rodytiRezultata(dom);

    }

    private static double[] gautiDuomenis() {
        double[] duom = new double[2];
        Metodai met = new Metodai();
        String ugis;
        String svoris;
        System.out.println("Įveskite savo ūgį: ");
        ugis = scan.nextLine();
        if (met.isDouble(ugis)) {
            duom[0] = Double.parseDouble(ugis);
        } else {
            while (!met.isDouble(ugis)) {
                System.out.println("Įveskite savo ūgį iš naujo ");
                ugis = scan.nextLine();
            }
            duom[0] = Double.parseDouble(ugis);
        }
        System.out.println("Įveskite savo svorį: ");
        svoris = scan.nextLine();
        if (met.isDouble(svoris)) {
            duom[1] = Double.parseDouble(svoris);
        } else {
            while (!met.isDouble(svoris)) {
                System.out.println("Įveskite savo svorį iš naujo ");
                svoris = scan.nextLine();
            }
            duom[1] = Double.parseDouble(svoris);
        }
        return duom;
    }

    private static void rodytiRezultata(double[] a){
        double result;
        result = a[1]/(a[0]*a[0]);
        System.out.println("Jūsų KMI : "+result);
    }
}