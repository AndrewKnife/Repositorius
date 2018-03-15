

public class EDoc7 {
    public static void main(String[] args)
    {
        int suma = 0;
        int[][] masyvas = {{1,5,4},{2,5,14},{8,7,13}};
        for(int i = 0; i< masyvas.length; i++)
        {
            for(int a: masyvas[i])
            {
                if(a%2 == 0)
                {
                    suma ++;
                }
            }
        }
        System.out.println(suma);
    }
}
