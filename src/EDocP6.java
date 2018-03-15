import java.util.Scanner;

public class EDocP6 {
    private static Scanner scan = new Scanner(System.in);
    private static final String[] OP = {"+", "-", "*", "/", "^"};

    public static void main(String[] args) {
        double result;
        String ivestis;
        System.out.println("Skaičiuotuvas");
        ivestis = scan.nextLine();
        doMath(ivestis);
    }

    private static void doMath(String text) {
        String ope;
        double[] val;
        ope = getOperator(text);
        if (ope != null) {
            val = getValues(text);
            if (val != null && val.length == 3) {
                switch (ope) {
                    case "+":
                        SumNumbers(val[0], val[1]);
                        break;
                    case "-":
                        SubstractNumbers(val[0], val[1]);
                        break;
                    case "*":
                        MultiplyNumbers(val[0], val[1]);
                        break;
                    case "/":
                        divideNumbers(val[0], val[1]);
                        break;
                    case "^":
                        involuteNumbers(val[0], val[1]);
                        break;

                }
            } else {
                System.out.println("Negera Ivestis");
            }

        } else {
            System.out.println("Negera Ivestis");
        }
    }

    private static String getOperator(String text) {
        boolean error = false;
        int opkiekis = 0;
        String opc = null;
        for (int i = 0; i < OP.length; i++) {
            if (text.contains(OP[i])) {
                opkiekis++;
                opc = OP[i];
            }
        }
        if (opkiekis == 1) {
            return opc;
        } else {
            return opc;
        }


    }

    private static double[] getValues(String text) {
        String[] splitted;
        double[] values = null;
        int i = 0;
        splitted = text.split(" ");
        values = new double[splitted.length];
        if (values.length == 3) {
            try {
                values[0] = Double.parseDouble(splitted[0]);
                values[1] = Double.parseDouble(splitted[2]);
                return values;
            } catch (Exception e) {
                return values;
            }
        }

        return values;
    }

    private static void SumNumbers(double a, double b) {
        double result;
        result = a + b;
        System.out.println(a + " + " + b + " = " + result);
    }

    private static void SubstractNumbers(double a, double b) {
        double result;
        result = a - b;
        System.out.println(a + " - " + b + " = " + result);
    }

    private static void MultiplyNumbers(double a, double b) {
        double result;
        result = a * b;
        System.out.println(a + " * " + b + " = " + result);
    }

    private static void divideNumbers(double a, double b) {
        double result;
        if (a != 0 && b != 0) {
            result = a / b;
            System.out.println(a + " / " + b + " = " + result);
        } else {
            System.out.println("Bloga Ivestis");
        }
    }

    private static void involuteNumbers(double a, double b) {

        double result = 0;

        if(b%2 == 1 || b%2 ==0) {
            for (int i = 0; i < b; i++) {
                if (result == 0) {
                    result = a;
                } else {
                    result = result * a;
                }
            }
            System.out.println(a + " ^ " + b + " = " + result);
        }
        else
        {
            System.out.println("Klaidinga įvestis");
        }

    }
}
