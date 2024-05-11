package PTP_POO.PTP2.Vue;

import PTP_POO.PTP2.Model.ModeleTP2_2;
import PTools.tools;

public class TP2_2 implements IVue{
    private final ModeleTP2_2 m_mod;
    public static void main(String[] args) {
        TP2_2.execute();
    }
    public static void execute() {
        new TP2_2(new ModeleTP2_2()).lancer();
    }

    public TP2_2(ModeleTP2_2 mod) {
        this.m_mod = mod;
    }

    @Override
    public void lancer() {
        int n = tools.AskInt("Entrer n : ");
        try {
            long fib = this.m_mod.fibonacci(n);
            System.out.println("Fibonacci de " + n + " est : " + fib + " : F[" + n + "] = " + fib);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Erreur : " + e);
        }
    }
}
