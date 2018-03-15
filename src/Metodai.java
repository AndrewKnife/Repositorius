public class Metodai {
    public boolean isDouble(String a){
        boolean isnumber= false;
        double b;
        try {
            b = Double.parseDouble(a);
            isnumber = true;

        }catch (Exception e){
            isnumber = false;
        }
        return isnumber;
    }
}
