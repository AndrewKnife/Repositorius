import java.io.File;
import java.io.IOException;
import java.util.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

class Studentas {//implements Comparable<Studentas> {
    private String vardas;
    private String pavarde;
    private String dalykas;
    private double pazimys;

    Studentas(String vardas, String pavarde, String dalykas, double pazimys) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.dalykas = dalykas;
        this.pazimys = pazimys;
    }

    //region Getters
    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public String getDalykas() {
        return dalykas;
    }

    public double getPazimys() {
        return pazimys;
    }

  /*  @Override
    public int compareTo(Studentas o) {
        return o.getVardas().compareTo(vardas);
    }*/
    //endregion

    //region Filters
    public static Comparator<Studentas> sortByName  = new Comparator<Studentas>() {
        @Override
        public int compare(Studentas o1, Studentas o2) {
            return o1.getVardas().compareTo(o2.getVardas());
        }
    };

    public static Comparator<Studentas> sortByLastName  = new Comparator<Studentas>() {
        @Override
        public int compare(Studentas o1, Studentas o2) {
            return o1.getPavarde().compareTo(o2.getPavarde());
        }
    };

    public static Comparator<Studentas> sortBySubject  = new Comparator<Studentas>() {
        @Override
        public int compare(Studentas o1, Studentas o2) {
            return o1.getDalykas().compareTo(o2.getDalykas());
        }
    };

    public static Comparator<Studentas> sortByGrade = new Comparator<Studentas>() {
        @Override
        public int compare(Studentas o1, Studentas o2) {
            if(o1.getPazimys() > o2.getPazimys()){
                return 1;
            } else if(o1.getPazimys() < o2.getPazimys()){
                return -1;
            }else {
                return 0;
            }
        }
    };
    //endregion
}

public class EDocP13 {
    private static Scanner scan = new Scanner(System.in);
    private static final String FILE_PAZYMIAI = "Duomenys/pazymiai.xlsx";

    public static void main(String[] args) {
        System.out.println("Pažymių skaičiuoklė");
        if (checkIfFileExists(FILE_PAZYMIAI)) {
            printMenu();
            menuSelector();
        } else {
            System.out.println("Tokio failo nėra");
        }


    }

    private static void menuSelector() {
        List<Studentas> stud = skaitytiFaila(FILE_PAZYMIAI);
        String selected;
        boolean working = true;
        while (working) {
            System.out.println("Pasirinkite norimą veiksmą: ");
            selected = scan.nextLine();
            selected = selected.toUpperCase();
            switch (selected) {
                case "A":
                    printAllStudents(stud);
                    break;
                case "B":
                    printMeanGrade(stud);
                    break;
                case "C":
                    printBestWorstStudent(stud,"BEST");
                    break;
                case "D":
                    printBestWorstStudent(stud,"WORST");
                    break;
                case "E":
                    printByFilter(stud,"NAME");
                    break;
                case "F":
                    printByFilter(stud,"LASTNAME");
                    break;
                case "G":
                    printByFilter(stud,"SUBJECT");
                    break;
                case "H":
                    printByFilter(stud,"GRADE");
                    break;
                case "0":
                    working = false;
                    break;
                default:
                    System.out.println("Bloga Įvestis");
                    break;
            }
        }
    }

    private static void printAllStudents(List<Studentas> listas) {

        for (Studentas st : listas) {
            System.out.println(st.getVardas() + " " + st.getPavarde() + " " + st.getDalykas() + " " + st.getPazimys());
        }
    }

    private static void printMeanGrade(List<Studentas> listas) {
        double vid;
        int moksk = 0;
        int pazsum = 0;
        for (Studentas st : listas) {
            moksk ++;
            pazsum += st.getPazimys();
        }
        vid = (double) pazsum/(double) moksk;
        System.out.println("Studentų vidurkis: "+vid);
    }

    private static void printBestWorstStudent(List<Studentas> listas, String ser) {
        List<Studentas> sras = new ArrayList<>();
        double grade =0;
        if(ser.equals("BEST")){
            grade=0;
            for (Studentas st : listas) {
                if(grade < st.getPazimys()){
                    grade = st.getPazimys();
                }
            }
        }else{
            for (Studentas st : listas) {
                grade=10;
                if(grade > st.getPazimys()){
                    grade = st.getPazimys();
                }
            }
        }
        for (Studentas st : listas) {
            if(st.getPazimys() == grade){
                sras.add(st);
            }
        }
        if(ser.equals("BEST")){
            System.out.println("Geriausių mokinių sąrašas");
        }else{
            System.out.println("Blogiausių mokinių sąrašas");
        }
        for(Studentas st:sras){
            System.out.println(st.getVardas() +" "+ st.getPavarde()+" "+st.getDalykas()+" "+st.getPazimys());
        }
    }

    private static void printByFilter(List<Studentas> listas, String filter) {
        // galimas nereikia kurti klases
       /* Collections.sort(listas, new Comparator<Studentas>() {

            @Override
            public int compare(Studentas o1, Studentas o2) {
                return o1.getVardas().compareTo(o2.getVardas());
            }
        });*/
        //nelankstus nes object klase gali tureti tik viena suriavimo buda
        // Collections.sort(listas);
        if(filter.equals("NAME")){
            Collections.sort(listas,  Studentas.sortByName);
        }else if(filter.equals("LASTNAME")){
            Collections.sort(listas,  Studentas.sortByLastName);
        }else if(filter.equals("SUBJECT")){
            Collections.sort(listas,  Studentas.sortBySubject);
        }else{
            Collections.sort(listas,  Studentas.sortByGrade);
        }
        System.out.println("Surušiuotas sąrašas: ");
        for (Studentas st : listas) {

            System.out.println(st.getVardas() + " " + st.getPavarde() + " " + st.getDalykas() + " " + st.getPazimys());
        }
    }

    private static void printMenu() {
        System.out.println("A: Atspausdinti visus studentus");
        System.out.println("B: Atspausdinti grupės vidurkį");
        System.out.println("C: Atspausdinti geriausiai besimokanti studentą");
        System.out.println("D: Atspausdinti blogiausiai besimokanti studentą");
        System.out.println("E: Surikiuoti studentus pagal vardus");
        System.out.println("F: Surikiuoti studentus pagal pavardes");
        System.out.println("G: Surikiuoti studentus pagal dalykų pavadinimus");
        System.out.println("H: Surikiuoti studentus pagal pažymius");
        System.out.println("0: Baigti darbą");
    }

    private static List<Studentas> skaitytiFaila(String fileName) {
        List<Studentas> student =new ArrayList<>();
        Studentas vienas;
        String vardas;
        String pavarde;
        String dalykas;
        double pazymys;
        int skip =0;

        //sukurti workbook
        int puslapiai;
        try{
            Workbook book = WorkbookFactory.create(new File(fileName));
            puslapiai = book.getNumberOfSheets();
            Sheet shet  = book.getSheetAt(0);
            for(Row row:shet){
                if(skip == 1) {
                    vardas = row.getCell(0).getStringCellValue().toString();
                    pavarde = row.getCell(1).getStringCellValue().toString();
                    dalykas = row.getCell(2).getStringCellValue().toString();
                    pazymys = row.getCell(3).getNumericCellValue();
                    vienas = new Studentas(vardas, pavarde, dalykas, pazymys);
                    student.add(vienas);
                }
                skip = 1;
            }

        }catch (InvalidFormatException e){

        }catch (IOException o){

        }


        return student;
    }

    private static boolean checkIfFileExists(String fileName) {
        boolean eg;
        File file = new File(fileName);
        if (file.exists()) {
            eg = true;
        } else {
            eg = false;
        }
        return eg;
    }
}
