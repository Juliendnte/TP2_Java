package PTP_POO.PTP2.Model;

import PTools.tools;

import java.util.Random;

public class ModeleTP2_5 {

    public ModeleTP2_5() {
    }

    /**
     * Classe hangman
     * Pour faire une partie
     * @see Hangman#setAllumette(int)
     * @see Hangman#getM_joueur()
     * @see Hangman#getM_joueur2()
     * @see Hangman#getAllumette()
     */
    public class Hangman {

        private final Player m_joueur2;
        private final Player m_joueur;
        private int m_nb_allumette;

        /**
         * Constructeur
         * @param joueur L'utilisateur
         * @param joueur2 Autre joueur (ordi ou non)
         * @param all nbr allumette
         */
        public Hangman(Player joueur,Player joueur2,int all){
            m_joueur2 = joueur2;
            m_joueur = joueur;
            m_nb_allumette = all;
        }


        //Setteur Getteur

        /**
         * Setteur du nombre d'allumette
         * @param all nombre d'allumette
         */
        public void setAllumette(int all){
            m_nb_allumette = all;
        }

        /**
         * Getteur du premier joueur
         * @return Le joueur
         */
        public final Player getM_joueur(){
            return m_joueur;
        }

        /**
         * Getteur du deuxième joueur
         * @return Le joueur/ordi
         */
        public final Player getM_joueur2(){
            return m_joueur2;
        }

        /**
         * Getteur des allumettes
         * @return le nombre d'allumette
         */
        public final int getAllumette(){
            return m_nb_allumette;
        }
    }

    /**
     * Class Player
     * @see Player#makeMove(int)
     * @see Player#Player(String)
     * @see Player#getName()
     */
    public class Player {
        private final String name;

        /**
         * Constructeur de la class Player
         * @param name Nom du joueur
         */
        public Player(String name) {
            this.name = name;
        }

        /**
         * Fonction pour savoir combien d'allumette l'utilsateur a prit
         * @param allumettes Le nombre d'allumettes dans la partie
         * @return Le nombre d'allumettes que l'utilisateur a prit
         */
        public int makeMove( int allumettes) {
            int move = tools.AskInt(name + ", combien d'allumettes voulez-vous enlever (1, 2 ou 3) ? ");
            while (move < 1 || move > 3) {
                move = tools.AskInt("Nombre invalide, veuillez choisir entre 1, 2 ou 3 .");
            }
            //S'il reste 2 allumette et que j'en prend 3 ça me fait automatiquement prendre 2 c'est juste pour de l'affichage et ma conscience
            return Math.min(move, allumettes);
        }

        /**
         * Getteur de nom
         * @return this.name
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Classe Computer fille de la classe Player
     * @see Player
     * @see Computer#difficulty
     * @see Computer#makeMove(int)
     * @see Computer#easyMode()
     * @see Computer#mediumMode(int)
     * @see Computer#hardMode(int)
     */
    public class Computer extends Player {
        /**
         * Variable pour savoir le niveau de difficulté ne peut être que égale a  {EASY,MEDIUM,HARD}
         * @see Computer.DifficultyLevel
         */
        private final Computer.DifficultyLevel difficulty;

        /**
         * Enumération des niveaux possibles EASY,MEDIUM,HARD
         */
        public enum DifficultyLevel {EASY,MEDIUM,HARD}//"Liste"(<= pour vulgariser) des niveaux possibles

        /**
         * Constructeur de Computer
         * @param difficulty La difficulté choisie
         * @see Player#Player(String)
         */
        public Computer(Computer.DifficultyLevel difficulty) {
            super("Ordinateur");
            this.difficulty = difficulty;
        }

        /**
         * Méthode surchargé pour savoir le nombre d'allumettes prit par l'ordinateur
         * @param allumettes Le nombre d'allumettes dans la partie
         * @return Le nombre d'allumettes prit
         * @see Computer#easyMode()
         * @see Computer#mediumMode(int)
         * @see Computer#hardMode(int)
         */
        @Override
        public int makeMove(int allumettes) {
            return switch (difficulty) {
                case EASY -> easyMode();
                case MEDIUM -> mediumMode(allumettes);
                case HARD -> hardMode(allumettes);
            };
        }

        /**
         * Méthode pour le bot en mode easy
         * @return Nombre aléatoire entre 1 et 3
         */
        private int easyMode() {
            return new Random().nextInt(3) + 1;
        }

        /**
         * Méthode pour le bot en mode medium
         * @param allumettes Nombre d'allumette dans la partie
         * @return S'il y a plus que 10 allumettes dans la partie le bot est en easy sinon il est en Hard
         * @see Computer#easyMode()
         * @see Computer#hardMode(int)
         */
        private int mediumMode(int allumettes) {
            return (allumettes > 10) ? easyMode() : hardMode(allumettes);
        }

        /**
         * Méthode pour le bot en mode Hard
         * @param allumettes Nombre d'allumette dans la partie
         * @return Laisse à l'adversaire un nombre d'allumettes qui est un multiple de 4 à chaque tour.
         */
        private int hardMode(int allumettes) {
            if (allumettes <= 4) {//S'il y a moins de 4 allumettes
                //S'il y en a qu'une il n'en prend que une sinon il en prends le nombre d'allumette - 1 pour en laisser plus que une a l'adversaire
                return allumettes == 1 ? 1 : allumettes - 1;
            } else {
                int remainder = (allumettes % 4) - 1;
                return remainder == -1 ? 1 : remainder;// renvoie le reste du modulo de 4 et si le modulo de 4 est égale a 0 il en prends 1
            }
        }
    }

    /**
     * Fonction pour instancier le niveau de l'ordi selon l'utilisateur
     * @see Computer#difficulty
     * @param message Le message qui est affiché avant d'instancier la classe (choix entre 1,2 et 3)
     * @return L'objet de classe Computer choisi par l'utilisateur
     */
    public Computer chooseComputerLevel(String message) {
        return switch (tools.AskInt(message)) {
            case 1 -> new Computer(Computer.DifficultyLevel.EASY);
            case 2 -> new Computer(Computer.DifficultyLevel.MEDIUM);
            case 3 -> new Computer(Computer.DifficultyLevel.HARD);
            default -> chooseComputerLevel("Vous ne pouvez choisir que 1, 2 ,ou 3");
        };
    }
}
