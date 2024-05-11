package PTP_POO.PTP2.Vue;

import PTP_POO.PTP2.Model.ModeleTP2_1;
import PTools.tools;

/**
 * Classe TP_21
 * @author julien
 */
public class TP2_1 implements IVue {

    private final ModeleTP2_1 m_mod;
    public static void main(String[] args) {
        execute();
    }
    public static void execute() {
        new TP2_1(new ModeleTP2_1()).lancer();
    }

    public TP2_1(ModeleTP2_1 mod) {
        this.m_mod = mod;
    }

    @Override
    public void lancer() {
        int cin = tools.AskInt("Entrer un nombre premier ");
        //Opérateur ternaire si isPrime == true alors le nombre est premier sinon il ne l'est pas
        System.out.println(cin + (this.m_mod.isPrime(cin) ? " est un nombre premier" : " n'est pas un nombre premier"));
    }
}
