import java.util.Scanner;

public class EDoc6 {
    public static void main(String[] args)
    {
        int[] masyv1 = {1,2,3,4};
        String[] masyv2 = {"a","b","c","d"};
        String[] result;
        Gaminti(masyv1, masyv2);


    }

    private static void Gaminti(int[] m1, String[] m2)
    {
        int sk = 0;
        int length = m1.length + m2.length;
        String[] masyv = new String[length];
        String eil = "";
        for(int i=0 ; i < m1.length; i++)
        {
            masyv[sk]= String.valueOf( m1[i]);
            sk++;
            masyv[sk] = m2[i];
            sk++;
        }

        for (String str: masyv)
        {
            eil += str;
        }
        System.out.println(eil);
    }
}
