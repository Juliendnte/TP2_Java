package PTP_POO.PTP2.Vue;

import PTP_POO.PTP2.Model.ModeleTP2_4;
import PTools.tools;

public class TP2_4 implements IVue{
    private final ModeleTP2_4 m_mod;

    public TP2_4() {
        this.m_mod = new ModeleTP2_4();
    }

    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        new TP2_4().lancer();
    }

    @Override
    public void lancer() {
        try {
            ModeleTP2_4.Archimede archi = this.m_mod.new Archimede(tools.AskInt("Entrer X : "), tools.AskInt("Entrer Y : "));
            System.out.println("Cn(" + archi.getX() + ", " + archi.getY() + ") = " + archi.Cn());
            System.out.println("In(" + archi.getX() + ", " + archi.getY() + ") = " + archi.In());

            int N = tools.AskInt("Entrer N : ");
            double[] result = archi.An(N);
            System.out.println("Résultat de An pour N = " + N + " :");
            System.out.println("X = " + result[0]);
            System.out.println("Y = " + result[1]);
            System.out.println("Le PI de la machine "+Math.PI);
        }catch (ArithmeticException e){
            System.err.println("Erreur : " + e);
        }
    }
}
