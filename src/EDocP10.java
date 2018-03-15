import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Bustas{
    private String nr;
    private double plotas;
    private int gyventojusk;
    private double kainauzpl;
    private double kainaviegyv;

    Bustas(String nr, double plotas, int gyventojusk){
        this.nr = nr;
        this.plotas = plotas;
        this.gyventojusk = gyventojusk;
    }

    //region Getters
    public String getNr() {
        return nr;
    }

    public double getPlotas() {
        return plotas;
    }

    public int getGyventojusk() {
        return gyventojusk;
    }


    public double getKainauzpl() {
        return kainauzpl;
    }

    public void setKainauzpl(double kainauzpl) {
        this.kainauzpl = kainauzpl;
    }

    public double getKainaviegyv() {
        return kainaviegyv;
    }

    public void setKainaviegyv(double kainaviegyv) {
        this.kainaviegyv = kainaviegyv;
    }
    //endregion
}

public class EDocP10 {
    private static final String FILE_BUSTAI = "Duomenys/bustai.txt";
    private static final double EL_KAINA = 1500;

    public static void main(String[] args) {
        List<Bustas> lis = skaitytiFaila();
        lis = skaiciuoti(lis);
        printResult(lis);
    }

    private static void printResult(List<Bustas> listas){
        System.out.println("Busto numeris | Kaina už m2 | Kaina už gyv. skaičių");
        for(int i = 0; i< listas.size();i++){
            System.out.print(listas.get(i).getNr()+" | "+(listas.get(i).getKainauzpl())+" | " + (listas.get(i).getKainaviegyv()));
            if(listas.get(i).getKainauzpl() > listas.get(i).getKainaviegyv()){
                System.out.println( " - Labiau apsimoka mokėti už gyventojų skaičių"+"\n");
            } else{
                System.out.println( " - Labiau apsimoka mokėti už m2"+"\n");
            }

        }

    }

    private static List<Bustas> skaiciuoti (List<Bustas> listas) {
        double kvm = 0;
        double gsk = 0;
        double kp;
        double gm;

        for(int i = 0 ; i < listas.size();i++){
            kvm += listas.get(i).getPlotas();
            gsk += listas.get(i).getGyventojusk();
        }
        for(int i = 0 ; i < listas.size();i++){
            kp = (EL_KAINA/kvm)*listas.get(i).getPlotas();
            gm = (EL_KAINA/gsk)*listas.get(i).getGyventojusk();
            listas.get(i).setKainauzpl(kp);
            listas.get(i).setKainaviegyv(gm);
        }
        return listas;

    }

    private static List<Bustas> skaitytiFaila(){
        String eil;
        String[] duom;
        List<Bustas> listas = new ArrayList<>();
        Bustas bust;
        try(BufferedReader read = new BufferedReader(new FileReader(FILE_BUSTAI))){
            while ((eil = read.readLine())!= null){
                duom = eil.split(" ");
                bust = new Bustas(duom[0], Double.parseDouble(duom[1]), Integer.parseInt(duom[2]));
                listas.add(bust);
            }
        }catch (IOException e){

        }
        return listas;
    }
}
