import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<String> listaLanches = new ArrayList<>(
            Arrays.asList("X-Burger", "X-Salada", "X-Bacon", "X-Tudo")
    );

    static ArrayList<Double> precoLanches = new ArrayList<>(
            Arrays.asList(18.90, 22.90, 22.90, 29.80)
    );

    public static void main(String[] args) {
        cardapio();
    }

    static void cardapio() {
        for (int i = 0; i < listaLanches.size(); i++) {
            System.out.println(i + " - " + listaLanches.get(i) +
                    " - R$ " + precoLanches.get(i));
        }
    }
}
