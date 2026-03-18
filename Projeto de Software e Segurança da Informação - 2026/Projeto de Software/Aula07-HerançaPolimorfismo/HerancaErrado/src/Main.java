import entidades.Cachorro;
import entidades.Gato;
import entidades.Peixe;

public class Main {
    public static void main(String[] args) {
        Cachorro cachorro = new Cachorro("Marley", 1, 20, "Labrador");
        Gato gato = new Gato("Cicinho", 1, 10, "Marrom");
        Peixe peixe = new Peixe("Marry", 1, 0.005, "Betta");

        System.out.println(peixe);
        System.out.println(gato);
        System.out.println(cachorro);
    }
}
