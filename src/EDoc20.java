import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class DataWorker {
    private String filename;

    private Scanner scan;

    DataWorker(String filename, Scanner scan) {
        this.filename = filename;
        this.scan = scan;
    }

    public void PrintPeople() {
        List<Person> sarasas = GetAllPeople();
        for (Person as : sarasas) {
            System.out.println(as.getVardas() + " " + as.getPavarde() + " " + as.getAmzius());
        }
    }

    public void FilterByName() {
        String pername;
        String nameup;
        System.out.println("Įveskite ieškomą vardą");
        String name = scan.nextLine();
        boolean rasta = false;
        List<Person> sarasas = GetAllPeople();
        System.out.println("Sąrašas pagal pasirinktą vardą " + "[" + name + "]");
        for (Person as : sarasas) {
            nameup = name.toUpperCase();
            pername = as.getVardas().toUpperCase();
            if (pername.equals(nameup)) {
                System.out.println(as.getVardas() + " " + as.getPavarde() + " " + as.getAmzius());
                rasta = true;
            }
        }
        if (!rasta) {
            System.out.println("Nieko pagal duotą vardą: " + "[" + name + "] nebuvo rasta");
        }
    }

    public void FilterByAge() {
        int age ;
        boolean rasta = false;
        List<Person> sarasas = GetAllPeople();
        while (true){
            try {
                System.out.println("Įveskite mažiausią ieškomo vartotojo amžių: ");
                age = scan.nextInt();

                break;
            }catch (Exception e){
                System.out.println("Bloga įvestis, vykdykite komandą iš naujo");
            }
        }
        System.out.println("Sąrašas vartotojų nuo amžiaus" + "[" + age + "]");
        for (Person as : sarasas) {
            if (as.getAmzius() >=age) {
                System.out.println(as.getVardas() + " " + as.getPavarde() + " " + as.getAmzius());
                rasta = true;
            }
        }
        if (!rasta) {
            System.out.println("Nieko vyresnio nei: " + "[" + age + "] nebuvo rasta");
        }

    }

    public void FilterByLetter(String filter) {
        boolean rasta = false;
        List<Person> sarasas = GetAllPeople();
        Character firlet;
        if (filter.toUpperCase().equals("NAME")) {
            System.out.println("Įveskite pirmą vardo raidę: ");
        } else {
            System.out.println("Įveskite pirmą pavardės raidę: ");
        }
        String letter = scan.nextLine();
        System.out.println("Sąrašas pagal pasirinktą raidę " + "[" + letter + "]");
        for (Person as : sarasas) {
            if (filter.toUpperCase().equals("NAME")) {
                firlet = as.getVardas().charAt(0);
                if (firlet.toString().toUpperCase().equals(letter.toUpperCase())) {
                    System.out.println(as.getVardas() + " " + as.getPavarde() + " " + as.getAmzius());
                    rasta = true;
                }
            } else {
                firlet = as.getPavarde().charAt(0);
                if (firlet.toString().toUpperCase().equals(letter.toUpperCase())) {
                    System.out.println(as.getVardas() + " " + as.getPavarde() + " " + as.getAmzius());
                    rasta = true;
                }
            }
        }
        if (!rasta) {
            System.out.println("Nieko pagal duotą reaidę: " + "[" + letter + "] nebuvo rasta");
        }
    }

    public void AddPerson() {
        boolean Err = true;
        String[] newperson = new String[3];
        String newname;
        String newsur;
        String newage ="";
        List<Person> sarasas = GetAllPeople();
        System.out.println("Įveskite vardą");
        newname = scan.nextLine();
        newname = CheckForErrors(newname);
        System.out.println("Įveskite Pavardę");
        newsur = scan.nextLine();
        newsur = CheckForErrors(newsur);
        while (Err) {
            try {
                System.out.println("Įveskite Amžių");
                newage = scan.nextLine();
                Err = false;

            } catch (Exception e) {
                System.out.println("Bloga Įvestis");

            }
        }

        newperson[0] = newname;
        newperson[1] = newsur;
        newperson[2] = newage;
        Person pers = new Person(newperson[0], newperson[1], Integer.parseInt(newperson[2]));
        sarasas.add(pers);
        RewriteFile(sarasas);
        System.out.println("Naujas vartotojas " + "[" + pers.getVardas() + " " + pers.getPavarde() + " " + pers.getAmzius() + "] Buvo pridėtas prie sąrąšo");
    }

    private List<Person> GetAllPeople() {
        String line;
        String[] duoms;
        List<Person> zmones = new ArrayList();
        Person zmogus;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {

                duoms = line.split(" ");
                zmogus = new Person(duoms[0], duoms[1], Integer.parseInt(duoms[2]));
                zmones.add(zmogus);
            }
            return zmones;

        } catch (IOException e) {
            System.out.println("Neveikia skaitymas iš failo");
        }
        return zmones;
    }

    private void RewriteFile(List<Person> listas) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(filename))) {
            StringBuilder build;
            for (Person per : listas) {
                build = new StringBuilder();
                build.append(per.getVardas()).append(" ").append(per.getPavarde()).append(" ").append(per.getAmzius());
                br.write(build.toString() + "\n");
            }


        } catch (IOException e) {
            System.out.println("Neveikia skaitymas iš failo");
        }
    }

    private String CheckForErrors(String word) {
        Scanner scan = new Scanner(System.in);
        char[] badletters = {'/', ';', ' ', '.', ',', '?', '>', '<', '!', '|', '\'', '~', '!'};
        boolean gerai = false;
        while (!gerai) {
            for (char a : badletters) {
                if (!word.contains(String.valueOf(a))) {
                    gerai = true;
                } else {
                    System.out.println("Įveskite iš naujo");
                    word = scan.nextLine();
                }
            }
        }
        return word;
    }

}

class Person {

    private String vardas;
    private String pavarde;
    private int amzius;

    Person(String vardas, String pavarde, int amzius) {
        this.vardas = vardas;
        this.pavarde = pavarde;
        this.amzius = amzius;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public int getAmzius() {
        return amzius;
    }
}


public class EDoc20 {

    public static void main(String[] args) {
        boolean dirba = true;
        String ivestis;
        Scanner scan = new Scanner(System.in);
        PrintMenu();
        while (dirba) {
            System.out.println("Spauzskite [H], jei norite pamatyti meniu");
            System.out.println("Įveskite komandą: ");
            ivestis = scan.nextLine();
            dirba = ExecuteCommand(ivestis, scan);
        }
    }

    private static void PrintMenu() {
        System.out.println("A: Atvaizduoti visus vartotojus.");
        System.out.println("B: Naujo vartotojo įrašimas į failą");
        System.out.println("C: Atvaizduoti vartotojus pagal prašomą vardą.");
        System.out.println("D: Atvaizduoti vartotojus kurių vardai prasideda prašoma raide.");
        System.out.println("E: Atvaizduoti vartotojus kurių pavardės prasideda prašoma raide");
        System.out.println("F: Atvaizduoti vartotojus kurių amžius yra didesnis nei įvestas skaičius.");
        System.out.println("H: Parodyti meniu.");
        System.out.println("0: Baigti Darbą.");
    }

    private static boolean ExecuteCommand(String letter, Scanner scanner) {
        boolean dirba = true;
        DataWorker dar = new DataWorker("Duomenys/zmogai.txt", scanner);
        letter = letter.toUpperCase();
        switch (letter) {
            case "A":
                dar.PrintPeople();
                break;

            case "B":
                dar.AddPerson();
                break;

            case "C":
                dar.FilterByName();
                break;

            case "D":
                dar.FilterByLetter("NAME");
                break;

            case "E":
                dar.FilterByLetter("SURNAME");
                break;

            case "F":
                dar.FilterByAge();
                break;

            case "H":
                PrintMenu();
                break;

            case "0":
                dirba = false;
                break;

            default:
                System.out.println("Pasirinkite kitą variantą: ");


        }
        return dirba;

    }


}
