import java.util.Scanner;

public class EDocP5 {
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Apskaičiuokite vidutines kuro sąnaudas");
        double[] duom = GautiDuomenis();
        rodytiRezultata(duom);

    }

    private static double[] GautiDuomenis() {
        double[] duom = new double[2];
        Metodai met = new Metodai();
        String sanaudos;
        String nuvaziuota;
        System.out.println("Įveskite Kuro sąnaudas 100 kilometrų: ");
        sanaudos = scan.nextLine();
        if (met.isDouble(sanaudos)) {
            duom[0] = Double.parseDouble(sanaudos);
        } else {
            while (!met.isDouble(sanaudos)) {
                System.out.println("Įveskite kuro sąnaudas iš naujo ");
                sanaudos = scan.nextLine();
            }
            duom[0] = Double.parseDouble(sanaudos);
        }
        System.out.println("Įveskite kiek kilometrų nuvažiavote: ");
        nuvaziuota = scan.nextLine();
        if (met.isDouble(nuvaziuota)) {
            duom[1] = Double.parseDouble(nuvaziuota);
        } else {
            while (!met.isDouble(nuvaziuota)) {
                System.out.println("Įveskite atstumą iš naujo ");
                nuvaziuota = scan.nextLine();
            }
            duom[1] = Double.parseDouble(nuvaziuota);
        }
        return duom;

    }

    private static void rodytiRezultata(double[] a){
        double result;
        result = (a[0]*100)/a[1];
        System.out.println("Jūsų mašinos vidutinės kuro sąnaudos šimtam kilometrų: "+result);
    }
}
