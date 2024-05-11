package PTP_POO.PTP2.Model;

public class ModeleTP2_1 {
    public ModeleTP2_1() {
    }

    /**
     * Fonction pour savoir si un nombre est premier ou non
     * @param nmb Le nombre testé
     * @return true signifie que nmb est premier / false signifie que nmb n'est pas premier
     */
    public boolean isPrime(int nmb) {
        if (nmb <= 0) nmb = -nmb;//Si le nombre est négatif je le met en positif
        if (nmb % 2 != 0) {
            for (int i = 3; i <= Math.sqrt(nmb); i += 2) {
                if (nmb % i == 0) return false;
            }
        }
        return nmb > 1 && nmb % 2 != 0;
    }
}
