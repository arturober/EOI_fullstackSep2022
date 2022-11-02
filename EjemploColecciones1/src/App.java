import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

public class App {
    /**
     * Transformar array a lista
     */
    public static void ejemplo1() {
        Integer[] numeros = { 3, 4, 5, 6, 2};
        Arrays.sort(numeros);
        Arrays.toString(numeros);
        List<Integer> list = new ArrayList<>(List.of(numeros));
        list.add(4);
        System.out.println(list);
    }

    public static void ejemplo2() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 5, 7, 3, 8));
        System.out.println(numeros.size());
        System.out.println(numeros);
        numeros.add(0, 99);
        System.out.println(numeros);
        
        numeros.addAll(List.of(10, 11, 12, 13));
        System.out.println(numeros);
    }

    /**
     * Transformar lista a array
     */
    public static void ejemplo3() {
        List<String> palabras = new ArrayList<>();
        palabras.add("coche");
        palabras.add("casa");
        palabras.add("perro");
        palabras.add("gato");

        palabras.remove("casa");

        String[] palabrasArray = new String[palabras.size()];
        palabras.toArray(palabrasArray);
        System.out.println(Arrays.toString(palabrasArray));
    }

    public static void ejemplo4() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 5, 7, 6, 8));
        System.out.println(numeros.contains(7));
        System.out.println(numeros.indexOf(7));
        System.out.println(numeros.contains(12));
        System.out.println(numeros.indexOf(12));
        System.out.println(numeros.containsAll(List.of(5, 6, 3)));

        // Cuidado con las listas de Integer (por defecto remove cuando recibe un número borra la posición)
        numeros.remove(3); // Borra el índice 3 (valor = 6)
        // Tendremos que crear un objeto Integer para que borre por valor
        numeros.remove(Integer.valueOf(3)); // Borra el valor 3 (índice = 0)
        System.out.println(numeros);
    }

    // Ordenar listas
    public static void ejemplo5() {
        List<Integer> numeros = new ArrayList<>(List.of(3, 1, 7, 6, 8, 2));
        // Método 1 (Collections.sort): Ordenar por defecto listas
        // Collections.sort(numeros);

         // Método 2 (List.sort) (Hay que pasarle un comparador o null por defecto)
        numeros.sort(null);
        System.out.println(numeros);

        // Ordenar al revés (mayor a menor)
        // Collections.sort(numeros, Comparator.reverseOrder());
        numeros.sort(Comparator.reverseOrder());
        System.out.println(numeros);
        Collections.shuffle(numeros); // Desordena lista (random)
        System.out.println(numeros);
    }



    public static void main(String[] args) throws Exception {
        // ejemplo1();
        // ejemplo2();
        // ejemplo3();
        // ejemplo4();
        ejemplo5();
    }
}
