package PTP_POO.PTP2.Model;

public class ModeleTP2_2 {

    public ModeleTP2_2() {
    }


    /**
     * Fonction récursive pour calculer le nombre fibonacci de n
     * @throws IllegalArgumentException Si le nombre est négatif ou si le nombre a calculer est plus grand qu'un long
     * @param n Le nombre testé
     * @return F[n]
     */
    public long fibonacci(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("La suite Fibonacci accepte que les entiers positifs");
        } else if (n <= 1) {
            return n;
        }
        long[] lst = new long[n + 1];
        lst[0] = 0;
        lst[1] = 1;
        for (int i = 2; i <= n; ++i) {
            lst[i] = lst[i - 1] + lst[i - 2];
            if (lst[i] == Long.MAX_VALUE){
                throw new ArithmeticException("Le nombre que vous voulez calculer est trop grand");
            }
        }
        return lst[n];
    }
}
