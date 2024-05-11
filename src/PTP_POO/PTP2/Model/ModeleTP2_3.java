package PTP_POO.PTP2.Model;

public class ModeleTP2_3 {

    public ModeleTP2_3() {
    }


    /**
     * Fonction pour calculer le plus précisément le nombre d'or f[n+1]/f[n]
     * @param n entier représentant l'inconnue dans l'équation O(n) = f[n+1]/f[n]
     * @return Le nombre d'or approximatif
     */
    public double O(int n) {
        if (n == 0)//car fib(0) = 0 et division par 0 est impossible donc O[0] = 0
            return 0;
        else if (n < 0)
            throw new IllegalArgumentException("La suite Fibonacci accepte que les entiers positifs");
        ModeleTP2_2 a = new ModeleTP2_2();
        return (double) a.fibonacci(n+1)/a.fibonacci(n);
    }
}
