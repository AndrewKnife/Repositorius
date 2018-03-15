import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EDocP11 {
    private static final String FILE_DESTYTOJAS = "Duomenys/destytojas.txt";
    public static void main(String[] args) {
        List<double[]> lis = skaitytiFaila();
        sutaupytuSuma(lis);
        arUztenka(lis);
        kuriDaugiausiai(lis);
        maxInesta(lis);
        minInesta(lis);
        kiekKartuNese(lis);
    }

    private static void sutaupytuSuma(List<double[]> lis){
        double result = 0;
        for(int i = 0 ; i < (lis.size()-1);i++){
            for(int j = 0 ; j < lis.get(i).length ; j++){
                result += lis.get(i)[j];
            }
        }
        System.out.println("Iš viso senis sutaupė: "+result+" eurų");
    }

    private static void kiekKartuNese(List<double[]> lis){
        double result = 0;
        for(int i = 0 ; i < (lis.size()-1);i++){
            result += lis.get(i).length;
        }
        System.out.println("Iš viso senis kartų pinigų dėjo į taupyklę: "+result);
    }

    private static void minInesta(List<double[]> lis){
        double  min = 10000;
        for(int i = 0 ; i < (lis.size()-1);i++){
            for(int j = 0 ; j < lis.get(i).length ; j++){
                if(lis.get(i)[j]<min){
                    min = lis.get(i)[j];
                }
            }
        }
        System.out.println("Mažiausia įnešta suma: "+min);
    }

    private static void maxInesta(List<double[]> lis){
        double max = 0;
        for(int i = 0 ; i < (lis.size()-1);i++){
            for(int j = 0 ; j < lis.get(i).length ; j++){
                if(lis.get(i)[j]>max){
                    max = lis.get(i)[j];
                }
            }
        }
        System.out.println("Didžiausia įnešta suma: "+max);
    }

    private static void kuriDaugiausiai(List<double[]> lis) {
        double max = 0;
        double result;
        int men = 0;
        for(int i = 0 ; i < (lis.size()-1);i++){
            result = 0;
            for(int j = 0 ; j < lis.get(i).length ; j++){
                result += lis.get(i)[j];
            }
            if(max < result){
                max = result;
                men = i+1;
            }
        }
        System.out.println("Daugiausia įnešta pinigų buvo: "+men+" mėnesį: "+max+" eurų");
    }

    private static void arUztenka(List<double[]> lis){
        double result = 0;
        for(int i = 0 ; i < (lis.size()-1);i++){
            for(int j = 0 ; j < lis.get(i).length ; j++){
                result += lis.get(i)[j];
            }
        }
        if(result <= lis.get(lis.size()-1)[0]){
            System.out.println("Senis lauks akcijos, nes kolkas per brangu");
        }else{
            System.out.println("Seniui užtenka pinigu ant laptopo");
        }
    }

    private static List<double[]> skaitytiFaila(){
        List<double[]> listas = new ArrayList<>();
        String line;
        String[] mas;
        double[] dmas;
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_DESTYTOJAS))) {
            while ((line = br.readLine()) != null){
                mas = line.split(" ");
                dmas = new double[mas.length];
                for(int i = 0 ; i < mas.length; i++){
                    dmas[i] = Double.parseDouble(mas[i]);
                }
                listas.add(dmas);
            }

        }catch (IOException e){
            listas = null;
        }
        return listas;
    }
}
