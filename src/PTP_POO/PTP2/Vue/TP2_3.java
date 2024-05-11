package PTP_POO.PTP2.Vue;

import PTP_POO.PTP2.Model.ModeleTP2_3;
import PTools.tools;

public class TP2_3 implements IVue{
    private final ModeleTP2_3 m_mod;
    public static void main(String[] args) {
        TP2_3.execute();
    }
    public static void execute() {
        new TP2_3(new ModeleTP2_3()).lancer();
    }

    public TP2_3(ModeleTP2_3 mod) {
        this.m_mod = mod;
    }

    @Override
    public void lancer() {
        int n = tools.AskInt("Entrer N : ");
        try {
            System.out.println("Le résultat de O[" + n + "] est " + this.m_mod.O(n));//fib(n+1)/fib(n)
            System.out.println("Le nombre d'or est égale à : " + (1 + Math.sqrt(5)) / 2);
        }catch (IllegalArgumentException | ArithmeticException e){
            System.err.println("Erreur : " + e);
        }
    }
}
