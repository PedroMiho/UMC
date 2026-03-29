public class Vetores {
    public static void main(String[] args) {
        double[] listaNumeros = new double[5];

        listaNumeros[0] = 10;
        listaNumeros[1] = 20;
        listaNumeros[2] = 40;
        listaNumeros[4] = 10;
        listaNumeros[3] = 30;

        //Percorrer Vetores em Java
        //Tradicional - for
        for(int i = 0; i < listaNumeros.length; i++){
            System.out.println(listaNumeros[i]);
        }

        //forEach
        for(double num : listaNumeros){
            System.out.println(num);
        }




    }
}
