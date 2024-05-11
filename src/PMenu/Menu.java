package PMenu;

import PTP_POO.PTP2.Controller.ControllerTP2_5;
import PTP_POO.PTP2.Vue.*;
import PTools.tools;

public class Menu {
    public static void main(String[] args) {
        Menu.execute();
    }

    public static void execute() {
        while (true){
            try {
                switch (tools.AskString("Quels TP voulez-vous essayer?\n1-TP.21\n2-TP.22\n3-TP.23\n4-TP.24\n5-TP.25\n6-TP.26\nq.quitter\n")){
                    case "1"-> TP2_1.execute();
                    case "2"-> TP2_2.execute();
                    case "3"-> TP2_3.execute();
                    case "4"-> TP2_4.execute();
                    case "5" -> ControllerTP2_5.execute();
                    case "6" ->TP2_6.execute();
                    case "q","Q"-> {
                        return;
                    }
                    default -> System.out.println("Résultat inconnue");
                }
                tools.AskString("");//Pour prendre le \n après avoir répondu
            }catch (Exception e){
                System.out.flush();
                System.err.println("Erreur trouvé => "+ e);
            }
        }
    }
}
