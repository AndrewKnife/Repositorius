import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class Filmas {
    private String kategorija;
    private String pavadinimas;
    private double vertinimai;

    Filmas(String kategorija, String pavadinimas){
        this.kategorija = kategorija;
        this.pavadinimas = pavadinimas;
    }

    //region Getters and Setters
    public String getKategorija() {
        return kategorija;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public double getVertinimai() {
        return vertinimai;
    }

    public void setVertinimai(double vertinimai) {
        this.vertinimai = vertinimai;
    }
    //endregion

    public static Comparator<Filmas> sortByGrade = new Comparator<Filmas>() {
        @Override
        public int compare(Filmas o1, Filmas o2) {
            if(o1.getVertinimai() > o2.getVertinimai()){
                return 1;
            }else if(o1.getVertinimai() < o2.getVertinimai()){
                return -1;
            }else{
                return 0;
            }
        }
    };


}

public class EDocP14 {
    private static final String FILE_FILMAI = "Duomenys/filmai.txt";
    private static final String FILE_FILXL = "Duomenys/filmai.xlsx";
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Filmų vertinimno sistema");
        List<Filmas> filmai = pildytiInfomacija(FILE_FILMAI);
        filmai = gautiVertinimus(filmai);
        pToConsole(filmai);
        pToFile(filmai);
        //labas
    }

    private static void pToFile(List<Filmas> filmai){
        Collections.sort(filmai, Filmas.sortByGrade);
        Workbook book = new XSSFWorkbook();
        Sheet shet = book.createSheet("Vertinimai");
        Row ro ;

        int rowcount = 0;
        for(Filmas filmas : filmai){
            ro = shet.createRow(rowcount);
            ro.createCell(0).setCellValue(filmas.getPavadinimas());
            ro.createCell(1).setCellValue(filmas.getKategorija());
            ro.createCell(2).setCellValue(filmas.getVertinimai());
            rowcount++;
        }

        // Write the output to a file
        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_FILXL);
            book.write(fileOut);
            fileOut.close();
            book.close();
        }catch (IOException e){

        }

    }

    private static void pToConsole(List<Filmas> filmai){
        for(Filmas fi : filmai){
            System.out.println(fi.getPavadinimas()+" "+fi.getVertinimai());
        }
    }

    private static List<Filmas> gautiVertinimus(List<Filmas> filmai) {
        String katpas;
        String pas;
        boolean rasta;
        List<String> kategorijos;
        for(int i = 1 ; i <= 5 ; i++) {
            kategorijos = gautiKategorijas(filmai);
            rasta = false;
            System.out.println("Išsirinkite "+i+" filmą");
            for (String kat : kategorijos) {
                System.out.println(kat);
            }

            while (true) {
                System.out.println("Pasirinkite vieną kategoriją iš esamų: ");
                katpas = scan.nextLine().toUpperCase();
                for (String kat : kategorijos) {
                    if (kat.toUpperCase().equals(katpas)) {
                        rasta = true;
                    } else {
                    }
                }
                if (rasta) {
                    break;
                }
            }
            for (Filmas fi : filmai) {

                if (fi.getKategorija().toUpperCase().equals(katpas)) {
                    System.out.println(fi.getPavadinimas());
                }
                rasta = false;
            }
            while (true) {
                System.out.println("Pasirinkitę filmą šioje kategorijoje: ");
                pas = scan.nextLine().toUpperCase();
                for (Filmas af : filmai) {
                    if (af.getPavadinimas().toUpperCase().contains(pas)) {
                        if (af.getVertinimai() != 0) {
                            af.setVertinimai((af.getVertinimai() + (double) gautiIvertinima()) / 2);
                        } else {
                            af.setVertinimai(gautiIvertinima());
                        }
                        rasta = true;
                    } else {
                    }
                }
                if (rasta) {
                    break;
                }
            }
            scan.nextLine();
        }
        return filmai;
    }

    private static List<String> gautiKategorijas( List<Filmas> listas){
        List<String> li= new ArrayList<>();
        String toadd= "";
        boolean yraVienodas;
        for(Filmas f: listas){
            yraVienodas = false;
            if(li.size()== 0){
               li.add(f.getKategorija()) ;
            }
            else {
                toadd ="";
                for(String sd: li){
                    if(sd.equals(f.getKategorija())){
                        yraVienodas = true;
                        break;
                    }
                }
                if(!yraVienodas){
                    toadd = f.getKategorija();
                }
            }
            if(!toadd.equals("")){
                li.add(toadd);
            }
        }
        return li;
    }

    private static List<Filmas> pildytiInfomacija(String filePath){
        List<Filmas> listas = new ArrayList<>();
        Filmas film;
        String line;
        String[] duom;

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            while ((line = br.readLine())!= null){
                line = line.replace(":",";");
                duom= line.split(";");
                for(int i = 0; i < (duom.length-1); i++){
                    duom[i] = duom[i].trim();
                    film = new Filmas(duom[0],duom[i+1]);
                    listas.add(film);
                }

            }

        }catch (IOException e){

        }
        return listas;
    }

    private static int gautiIvertinima(){
        int ivertinimas = 0;
        boolean dirba = true;
        while (dirba) {
            System.out.println("Įveskite įvertinimą nuo 1-10");
            try {
               ivertinimas =  scan.nextInt();
               if(ivertinimas >= 1 && ivertinimas <= 10){
                   dirba = false;
               }else{
                   scan.nextInt();
               }

            } catch (InputMismatchException e) {

            }
        }
        return ivertinimas;
    }


}
