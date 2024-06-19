public class FactorialCalculator {
    public static void main(String[] args) {
        try {
            int number = 5; // Cambia este valor para probar diferentes casos
            int result = calculateFactorial(number);
            System.out.println("El factorial de " + number + " es: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int calculateFactorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("No se puede calcular el factorial de un numero negativo.");
        }
        if (n > 12) {
            throw new IllegalArgumentException("No se permite calcular el factorial de un numero mayor a 12.");
        }
        return factorial(n);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
