public class EDoc17 {
    public static void main(String[] args)
    {
        int a = 5;
        int b = 4;

        System.out.println("Skaičių suma: " + SumNumbers(a,b));
        System.out.println("Skaičių skirtumas: " + SubstractNumbers(a,b));
        System.out.println("Skaičių daugyba: " + MultiplyNumbers(a,b));
    }

    private static int SumNumbers(int a, int b)
    {
        int result;
        result = a + b;
        return result;
    }

    private static int SubstractNumbers(int a, int b)
    {
        int result;
        result = a - b;
        return result;
    }

    private static int MultiplyNumbers(int a, int b)
    {
        int result;
        result = a * b;
        return result;
    }
}
