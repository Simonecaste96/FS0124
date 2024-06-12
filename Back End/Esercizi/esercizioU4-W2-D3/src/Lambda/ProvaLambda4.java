package Lambda;

import java.util.ArrayList;
import java.util.List;

public class ProvaLambda4 {
    public static void main(String[] args) {

        List<Integer> numeriImmutabili = List.of(1,2,3,4,5,6,7,8,9,10);

        ArrayList<Integer> numeri = new ArrayList<>(numeriImmutabili);


        System.out.println(numeri);

        numeri.forEach(e -> System.out.println(e));

        //metodo replaceAll aggiungo +10 ad ogni numero
        numeri.replaceAll(e -> e+10);

        numeri.forEach(e -> System.out.println(e));
    }


}
