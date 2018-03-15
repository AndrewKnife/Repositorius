import java.util.InputMismatchException;
import java.util.Scanner;

class Uzsakymas {
    private double kaina;
    private int menesiai;
    private String pavadinimas;
    private double veikejoalga;

    Uzsakymas(double kaina, int menesiai, String pavadinimas, double veikejoalga) {
        this.kaina = kaina;
        this.menesiai = menesiai;
        this.pavadinimas = pavadinimas;
        this.veikejoalga = veikejoalga;
    }

    //region Getters
    public double getKaina() {
        return kaina;
    }

    public int getMenesiai() {
        return menesiai;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public double getVeikejoalga() {
        return veikejoalga;
    }
    //endregion
}

public class EDocP12 {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Uzsakymas prek = ivestiDuomenis();
        if (arLizinguojamas(prek)) {
            kiekSumokes(prek);
        } else {
            System.out.println("Gryžkite kai rasite geresnį darbą");
        }

    }

    private static void kiekSumokes(Uzsakymas uz) {
        StringBuilder build = new StringBuilder();
        int menesis=0;
        double palukanos = 0;
        double visomoketi = uz.getKaina();
        double likomoketi = visomoketi;
        double menimoka = visomoketi / uz.getMenesiai();
        double reikesmoketi;
        double sumoketa = 0;
        while (likomoketi != 0) {
            menesis ++;
            reikesmoketi = menimoka + kokiosPalukanos(likomoketi);
            if (likomoketi < reikesmoketi) {
                reikesmoketi = likomoketi + kokiosPalukanos(likomoketi);
            }
            sumoketa += reikesmoketi;
            palukanos += kokiosPalukanos(likomoketi);

            if (likomoketi > menimoka) {
                likomoketi -= menimoka;
            } else {

                sumoketa += likomoketi + kokiosPalukanos(likomoketi);
                likomoketi = 0;
            }
            build.append(menesis+" mėnesį mokėsite "+ menimoka + " ir "+palukanos+" palūkanų ir viso liks mokėti: "+likomoketi+"\n");

        }
        System.out.println("Pirkėjui reikės sumokėti iš viso: " + sumoketa);
        System.out.println("Iš kurių palūkanų: " + palukanos);
        System.out.println(build.toString());

    }

    private static boolean arLizinguojamas(Uzsakymas uz) {
        boolean viskasOk = false;
        if ((uz.getKaina() * 2) > uz.getVeikejoalga()) {
            System.out.println("Pirkėjas nėra lizinguojamas");
            viskasOk = false;
        } else {
            System.out.println("Pirkėjas bus lizinguojamas");
            viskasOk = true;
        }
        return viskasOk;
    }

    private static Uzsakymas ivestiDuomenis() {
        Uzsakymas prek;
        String pavadin;
        double alga;
        double kaina;
        int menesiai;
        System.out.println("Įveskite prekės pavadinimą: ");
        pavadin = scan.nextLine();
        System.out.println("Įveskite prekės kainą: ");
        kaina = ivestisDouble();
        System.out.println("Pasirinkite gražinimo laikotarpį: 6, 10 , 12 arba 24 mėnesiai ");
        while (true) {
            try {
                menesiai = scan.nextInt();
                if (menesiai == 6 || menesiai == 10 || menesiai == 12 || menesiai == 24) {
                    break;
                } else {
                    System.out.println("Kartokite įvesti: ");
                }

            } catch (InputMismatchException e) {
                System.out.println("Kartokite įvesti: ");
                scan.nextLine();
            }
        }
        System.out.println("Įveskite savo algą: ");
        alga = ivestisDouble();

        prek = new Uzsakymas(kaina, menesiai, pavadin, alga);
        return prek;
    }

    private static double kokiosPalukanos(double likomoketi) {
        double palukanos;

        if (likomoketi > 2000) {
            palukanos = likomoketi * 0.03;
        } else if (likomoketi > 1000) {
            palukanos = likomoketi * 0.04;
        } else if (likomoketi > 500) {
            palukanos = likomoketi * 0.05;
        } else {
            palukanos = likomoketi * 0.06;
        }

        return palukanos;
    }

    private static double ivestisDouble() {
        double skaicius;
        while (true) {
            try {
                skaicius = scan.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Kartokite įvesti: ");
                scan.nextLine();
            }
        }
        return skaicius;
    }
}
