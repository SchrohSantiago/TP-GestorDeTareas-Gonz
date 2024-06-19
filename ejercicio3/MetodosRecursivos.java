import java.util.List;

public class MetodosRecursivos {

    public static void main(String[] args) {
        // Pruebas para los metodos
        List<String> listaDeCadenas = List.of("manzana", "banana", "cereza", "durazno");
        String objetivo = "cereza";
        System.out.println("La cadena '" + objetivo + "' esta presente: " + estaCadenaPresente(listaDeCadenas, objetivo, 0));

        List<Integer> listaDeNumeros = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Cantidad de numeros impares: " + contarNumerosImpares(listaDeNumeros, 0));

        List<Integer> listaCreciente = List.of(1, 2, 3, 4, 5);
        System.out.println("La lista es creciente: " + esListaCreciente(listaCreciente, 0));

        List<Integer> listaDeValores = List.of(3, 5, 7, 2, 8);
        System.out.println("El maximo valor en la lista: " + encontrarValorMaximo(listaDeValores, 0, Integer.MIN_VALUE));
    }

    // Metodo recursivo para determinar si una cadena esta presente en una lista de cadenas
    public static boolean estaCadenaPresente(List<String> lista, String objetivo, int indice) {
        if (indice >= lista.size()) {
            return false;
        }
        if (lista.get(indice).equals(objetivo)) {
            return true;
        }
        return estaCadenaPresente(lista, objetivo, indice + 1);
    }

    // Metodo recursivo para contar la cantidad de numeros impares en una lista
    public static int contarNumerosImpares(List<Integer> lista, int indice) {
        if (indice >= lista.size()) {
            return 0;
        }
        int contador = lista.get(indice) % 2 != 0 ? 1 : 0;
        return contador + contarNumerosImpares(lista, indice + 1);
    }

    // Metodo recursivo para determinar si una lista de enteros es creciente
    public static boolean esListaCreciente(List<Integer> lista, int indice) {
        if (indice >= lista.size() - 1) {
            return true;
        }
        if (lista.get(indice) >= lista.get(indice + 1)) {
            return false;
        }
        return esListaCreciente(lista, indice + 1);
    }

    // Metodo recursivo para determinar el maximo valor en una lista de valores
    public static int encontrarValorMaximo(List<Integer> lista, int indice, int maxActual) {
        if (indice >= lista.size()) {
            return maxActual;
        }
        int nuevoMax = Math.max(maxActual, lista.get(indice));
        return encontrarValorMaximo(lista, indice + 1, nuevoMax);
    }
}
