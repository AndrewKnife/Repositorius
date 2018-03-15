import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Zaidejas{
    private String number;
    private String fullName;
    private int bauduMetimai;
    private int dviMetimai;
    private int triMetimai;
    private int taskai;
    private int metimai;
    private double taiklumas;

    Zaidejas(String number, String fullName){
        this.number = number;
        this.fullName = fullName;
    }


    //region Getters and Setters
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBauduMetimai() {
        return bauduMetimai;
    }

    public void setBauduMetimai(int bauduMetimai) {
        this.bauduMetimai = bauduMetimai;
    }

    public int getDviMetimai() {
        return dviMetimai;
    }

    public void setDviMetimai(int dviMetimai) {
        this.dviMetimai = dviMetimai;
    }

    public int getTriMetimai() {
        return triMetimai;
    }

    public void setTriMetimai(int triMetimai) {
        this.triMetimai = triMetimai;
    }

    public int getTaskai() {
        return taskai;
    }

    public void setTaskai(int taskai) {
        this.taskai = taskai;
    }

    public int getMetimai() {
        return metimai;
    }

    public void setMetimai(int metimai) {
        this.metimai = metimai;
    }

    public double getTaiklumas() {
        return taiklumas;
    }

    public void setTaiklumas(double taiklumas) {
        this.taiklumas = taiklumas;
    }
    //endregion

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append(number);
        builder.append(" ");
        builder.append(fullName);
        builder.append(" ");
        builder.append(bauduMetimai);
        builder.append(" ");
        builder.append(dviMetimai);
        builder.append(" ");
        builder.append(triMetimai);
        builder.append(" ");
        builder.append(taskai);
        builder.append(" ");
        builder.append(metimai);
        builder.append(" ");
        builder.append(taiklumas);

        return builder.toString();
    }
}

public class EDocP9 {

    private static final String FILE_ZAIDEJAI = "Duomenys/zaidejai.txt";
    private static final String FILE_TASKAI = "Duomenys/taskai.txt";
    private static final String FILE_SUVESTINE = "Duomenys/suvestine.txt";

    public static void main(String[] args) {
        List<Zaidejas> liz = gautiZaidejus();
        List<String[]> lis = gautiTaskus();
        List<Zaidejas> full = pildytiDuomenis(liz, lis);
        darytiSuvestine(full);


    }

    private static List<Zaidejas> gautiZaidejus(){
        String eil;
        String[] duom;
        List<Zaidejas> listas = new ArrayList<>();
        Zaidejas zaid;
        try(BufferedReader read = new BufferedReader(new FileReader(FILE_ZAIDEJAI))){
            while ((eil = read.readLine())!= null){
                duom = eil.split(" ");
                zaid = new Zaidejas(duom[0], (duom[1]+" "+duom[2]));
                listas.add(zaid);
            }
        }catch (IOException e){

        }
        return listas;
    }

    private static List<String[]> gautiTaskus(){
        List<String[]> listas = new ArrayList<>();
        String eil;
        String[] duom;
        try(BufferedReader read = new BufferedReader(new FileReader(FILE_TASKAI))){
            while ((eil = read.readLine())!= null){
                duom = eil.split(" ");
                listas.add(duom);
            }
        }catch (IOException e){

        }
        return listas;
    }

    private static List<Zaidejas> pildytiDuomenis(List<Zaidejas> zd, List<String[]> st){
        int t1;
        int t2;
        int t3;
        int t0;
        int spek;
        int taskai;
        int metimai;
        double taikl;
        for(int i = 0; i < zd.size(); i++){
            t1 =0;
            t2 =0;
            t3=0;
            t0 = 0;
            for(int j = 0; j < st.size(); j++){
                if(zd.get(i).getNumber().equals(st.get(j)[0])){
                    spek = Integer.parseInt(st.get(j)[1]);
                    if(spek == 0){
                        t0++;
                    }else if(spek == 1){
                        t1++;
                    }else if(spek == 2){
                        t2++;
                    }else{
                        t3++;
                    }
                }
                taskai = t1+(t2*2)+(t3*3);
                if(t2 == 0 && t3 != 0){
                    metimai = (t0 + t1 +(t3));
                }
                else if(t2 !=0 && t3 == 0){
                    metimai = (t0 + t1 +(t2));
                }
                else{
                    metimai = (t0 + t1 +t2+t3);
                }
                if(taskai != 0 && metimai != 0){
                    taikl = (double) metimai/((double) metimai+t0);
                    taikl = taikl *100;
                }
                else{
                    taikl = 0;
                }

                zd.get(i).setMetimai(t0);
                zd.get(i).setDviMetimai(t2);
                zd.get(i).setBauduMetimai(t1);
                zd.get(i).setTriMetimai(t3);
                zd.get(i).setTaskai(taskai);
                zd.get(i).setTaiklumas(taikl);
            }
        }
        return zd;
    }

    private static void darytiSuvestine(List<Zaidejas> listas){
        try(BufferedWriter write = new BufferedWriter(new FileWriter(FILE_SUVESTINE))){
            for(Zaidejas zd : listas){
                write.write(zd.toString()+"\n");
            }
            System.out.println("Darbas Baigtas");

        }catch (IOException e){

        }
    }
}
