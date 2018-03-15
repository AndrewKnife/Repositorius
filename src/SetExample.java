import java.util.HashSet;
import java.util.Set;

public class SetExample {
    public static void main(String[] args) {
        Set<Integer> setas = new HashSet<>();
        for(int i = 0; i < 100 ; i++){
            setas.add(i);
        }
        setas.add(3);
        for(int i :setas){
            System.out.println(i);
        }
    }
}
