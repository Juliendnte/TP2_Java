package PTP_POO.PTP2.Controller;

import PTP_POO.PTP2.Model.ModeleTP2_5;
import PTP_POO.PTP2.Vue.TP2_5;
import PTools.tools;

import java.util.Random;


public class ControllerTP2_5 {

    private final ModeleTP2_5 m_mod;

    public ControllerTP2_5() {
        this.m_mod = new ModeleTP2_5();
    }

    public static void main(String[] args) {
        execute();
    }

    public static void execute() {
        new ControllerTP2_5().Jeu();
    }

    public void Jeu(){
        ModeleTP2_5.Player Player1 = new TP2_5().getPlayer("Entrer votre nom : ");//Instance des joueurs / allumettes
        ModeleTP2_5.Player Player2 = new TP2_5().getPlayer2();
        int allumettes = tools.AskInt("Choisir le nombre d'allumettes de départ : ");
        while (allumettes <= 0){
            allumettes = tools.AskInt("Le nombres d'allumettes doit être un entier positif non nul \nChoisir le nombre d'allumettes de départ : ");
        }

        ModeleTP2_5.Hangman hangman = this.m_mod.new Hangman(Player1,Player2,allumettes);//Instance du Jeu
        boolean Turn = new Random().nextBoolean(); // Choisir aléatoirement le joueur qui commence

        while (hangman.getAllumette() > 0) {
            new TP2_5().printAllumette(hangman);//Affichage pour les allumettes
            Manche(hangman, Turn ? Player1 : Player2);//Selon le tour le joueur 1 ou 2 fait une manche
            Turn = !Turn;//Au tour de l'autre joueur
        }
        new TP2_5().printWin(Turn,hangman);
    }

    public void Manche(ModeleTP2_5.Hangman hangman, ModeleTP2_5.Player player){
        TP2_5.Println(player.getName() + " à vous de jouer !");
        int playerMove = player.makeMove(hangman.getAllumette());
        hangman.setAllumette(hangman.getAllumette() - playerMove);
        TP2_5.Println(player.getName() + " enlève : " + playerMove);
    }
}
