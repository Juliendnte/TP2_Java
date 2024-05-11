package PTP_POO.PTP2.Vue;

import PTP_POO.PTP2.Model.ModeleTP2_6;
import PTools.tools;

import java.util.Arrays;

public class TP2_6 implements IVue{
    private final ModeleTP2_6 m_mod;
    public static void main(String[] args) {
        TP2_6.execute();
    }
    public static void execute() {
        new TP2_6(new ModeleTP2_6()).lancer();
    }

    public TP2_6(ModeleTP2_6 mod) {
        this.m_mod = mod;
    }

    @Override
    public void lancer() {
        int nb = tools.AskInt("Entrer un nombre : ");
        try {
            System.out.println("Le résultat des 20 premiers nombres de la suite Syracuse pour U("+nb+") est : "+ Arrays.toString(this.m_mod.U(nb)));
        }catch (IllegalArgumentException | ArithmeticException e){
            System.err.println("Erreur : " + e);
        }
    }
}
