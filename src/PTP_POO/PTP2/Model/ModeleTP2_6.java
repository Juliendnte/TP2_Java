package PTP_POO.PTP2.Model;

import java.util.Arrays;

public class ModeleTP2_6 {

    public ModeleTP2_6() {
    }

    /**
     * Fonction pour calculer les 20 premiers nombres de la suite de Syracuse pour n
     * @param n entier positif paramètre pour la suite
     * @return Liste des 20 premiers nombres
     */
    public int[] U(int n) throws IllegalArgumentException {
        int[] lst = new int[20];
        if (n == 0){
            Arrays.fill(lst, 0);//Remplie les tous les éléments par des 0
        } else if (n < 0) {
            throw new IllegalArgumentException("La suite Syracuse n'accepte que les entiers possitifs");
        }else{
            lst[0] = n;
            for (int i = 1 ; i < lst.length ; ++i){
                lst[i] = (lst[i-1]%2 == 0 ? lst[i-1]/2 : 3*lst[i-1]+1);
            }
        }
        return lst;
    }
}
