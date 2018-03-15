import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EDocP7 {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Darbas su masyvu");
        int[] duom = null;
        while (duom == null) {
            duom = ivestiDuom();
        }
        rodytiMeniu();
        inputCommand(duom);
        System.out.println("Darbas baigtas");

    }

    private static void rodytiMeniu() {
        System.out.println("A: Susumuoti teigiamus masyvo elementus");
        System.out.println("B: Skaičiuoti sumą nuo pirmo iki pasirinkto elemento");
        System.out.println("C: Rasti didžiausia masyvo skaičių");
        System.out.println("D: Rasti mažiausią masyvo elementą");
        System.out.println("E: Apversti masyvo elementus");
        System.out.println("F: Surikiuoti masyvą didėjimo tvarka");
        System.out.println("G: Surikiuoti masyvą mažėjimo tvarka");
    }

    private static void inputCommand(int[] mas) {
        System.out.println("Įveskite varianto raidę: ");
        String a = scan.nextLine().toUpperCase();
        switch (a) {
            case "A":
                teigElSum(mas);
                break;
            case "B":
                elSumIkiKito(mas);
                break;
            case "C":
                findLargestElement(mas);
                break;
            case "D":
                findSmallestElement(mas);
                break;
            case "E":
                apverstiMasyva(mas);
                break;
            case "F":
                rikiuotiDid(mas);
                break;
            case "G":
                rikiuotiMaz(mas);
                break;
            default:
                System.out.println("Bloga įvestis");
                break;

        }
    }

    private static int[] ivestiDuom() {
        String eil;
        String[] val;
        int[] result;
        System.out.println("Iveskite masyvo elementus atskirdami juos tarpais: ");
        eil = scan.nextLine();
        val = eil.split(" ");
        result = new int[val.length];
        try {
            for (int i = 0; i < val.length; i++) {
                result[i] = Integer.parseInt(val[i]);
            }
        } catch (Exception e) {
            System.out.println("Teks pakartoti");

            result = null;
        }
        return result;
    }

    private static void teigElSum(int[] mas) {
        int result = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] % 2 == 0) {
                result += mas[i];
            }

        }
        System.out.println("Teigiamų elementų suma: " + result);
    }

    private static void elSumIkiKito(int[] mas) {
        int result = 0;
        System.out.println("Įveskite skaičių iki kurio sumuosime masyvą: ");
        int sk = 0;
        try {
            sk = scan.nextInt();
            if (sk > 0) {
                for (int i = 0; i < sk; i++) {
                    result += mas[i];
                }
            } else {
                result = 0;
            }
        } catch (Exception e) {
            System.out.println("Bloga Įvestis");
        }
        System.out.println("Elementų suma nuo 1 iki " + sk + " yra: " + result);
    }

    private static void findLargestElement(int[] mas) {
        int max = 0;
        for (int i = 0; i < mas.length; i++) {
            if (max < mas[i]) {
                max = mas[i];
            }
        }
        System.out.println("Didžiausias elementas masyve: " + max);
    }

    private static void findSmallestElement(int[] mas) {
        int min = 0;
        for (int i = 0; i < mas.length; i++) {
            if (min > mas[i]) {
                min = mas[i];
            }
        }
        System.out.println("Didžiausias elementas masyve: " + min);
    }

    private static void apverstiMasyva(int[] mas) {
        int[] sam = new int[mas.length];
        int sk = 0;
        for (int i = (mas.length - 1); i >= 0; i--) {
            sam[sk] = mas[i];
            sk++;
        }
        System.out.println("Apverstas masyvas: ");
        for (int a : sam) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void rikiuotiDid(int[] mas) {
        int sk = 0;
        for (int i = 0; i < mas.length; i++) {

            for (int j = 0; j < mas.length; j++) {
                if (mas[i] < mas[j]) {
                    sk = mas[i];
                    mas[i] = mas[j];
                    mas[j] = sk;
                }

            }
        }
        System.out.println("Masyvas didėjimo tvarka: ");
        for (int a : mas) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    private static void rikiuotiMaz(int[] mas) {
        int sk = 0;
        for (int i = 0; i < mas.length; i++) {

            for (int j = 0; j < mas.length; j++) {
                if (mas[i] > mas[j]) {
                    sk = mas[i];
                    mas[i] = mas[j];
                    mas[j] = sk;
                }
            }
        }
        System.out.println("Masyvas mažėjimo tvarka: ");
        for (int a : mas) {
            System.out.print(a + " ");
        }
        System.out.println();
    }



}
