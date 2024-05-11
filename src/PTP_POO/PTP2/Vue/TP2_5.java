package PTP_POO.PTP2.Vue;

import PTP_POO.PTP2.Model.ModeleTP2_5;
import PTools.tools;

public class TP2_5{
    private final ModeleTP2_5 m_mod;

    public TP2_5() {
        this.m_mod = new ModeleTP2_5();
    }


    public ModeleTP2_5.Player getPlayer(String str){
        return this.m_mod.new Player(tools.AskString(str));
    }

    public ModeleTP2_5.Player getPlayer2(){
        return switch (tools.AskString("Voulez vous faire une partie contre un autre joueur(1) ou une IA(2)")) {
            case "1" -> this.m_mod.new Player(tools.AskString("Comment s'appelle le joueur 2"));
            case "2" -> this.m_mod.chooseComputerLevel("Choisissez le niveau de difficulté de l'ordinateur :\n1. Facile\n2. Moyen\n3. Difficile\n");
            default -> getPlayer2();
        };
    }

    public void printAllumette(ModeleTP2_5.Hangman hangman){
        System.out.println("| ".repeat(hangman.getAllumette()));//Affichage des allumettes affiche | * le nombre dans allumettes
        System.out.println("Il y a " + hangman.getAllumette() + " " + (hangman.getAllumette() > 1 ? "allumettes" : "allumette"));//ternaire pour que si il reste 1 allumette il est affiché allumette et pas allumettes
    }

    public void printWin(boolean Turn, ModeleTP2_5.Hangman hangman){
        //Affichage des victoire si Turn est true alors le joueur a gagné
        System.out.println(Turn ? hangman.getM_joueur2().getName() + " a perdu !\n"+hangman.getM_joueur().getName() + " a gagné :-)" : hangman.getM_joueur().getName() + " a perdu :-(\n"+hangman.getM_joueur2().getName() + " a gagné !");
        System.out.println("Fin du Jeu");
    }

    public static void Println(String str){
        System.out.println(str);
    }
}
