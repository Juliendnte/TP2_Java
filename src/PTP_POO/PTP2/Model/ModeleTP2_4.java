package PTP_POO.PTP2.Model;

public class ModeleTP2_4 {
    public ModeleTP2_4() {
    }


    /**
     * Classe Archimede avec 2 attributs :
     * X (double)
     * Y (double)
     */
    public class Archimede {
        private final double X;
        private final double Y;

        /**
         * Constructeur de la class Archimede
         * @param x Variable x double > = 0
         * @param y Variable y double > = 0
         */
        public Archimede(double x, double y){
            if (x < 0 || y < 0) {
                throw new ArithmeticException("Les valeurs de X ou Y ne peuveut pas être negatif.");
            }
            this.X = x;
            this.Y = y;
        }

        /**
         * Fonction Cn avec les attributs de sa classe (X, et Y)
         * @return 2XY/(X+Y) (double)
         */
        public double Cn() {
            if ( this.X + this.Y == 0){
                throw new ArithmeticException("Division par 0 imposible");
            }
            return 2 * this.X * this.Y / (this.X + this.Y);
        }
        /**
         * Fonction Cn avec les paramètres X, et Y
         * @param x (double) valeur de X
         * @param y (double) valeur de Y
         * @return 2XY/(X+Y) (double)
         */
        private double Cn(double x, double y) {
            if (x < 0 || y < 0) {
                throw new ArithmeticException("Les valeurs de X ou Y ne peuveut pas être positif.");
            }
            return 2 * x * y/ (x + y);
        }

        /**
         * Fonction In avec les attributs de sa classe (X, et Y)
         * @return racine carré de X * Y
         */
        public double In() {
            return Math.sqrt(this.X * this.Y);
        }

        /**
         * Fonction In avec les paramètres X, et Y
         * @param x (double) valeur de X
         * @param y (double) valeur de Y
         * @return racine carré de X * Y
         */
        private double In(double x, double y) {
            return Math.sqrt(x * y);
        }

        /**
         * Fonction An avec X = 4 et Y = 2 * racine carré de 2
         * @param N nombre d'itération
         * @return Liste avec X et Y
         */
        public double[] An(int N) {
            if (N <= 0) {
                throw new ArithmeticException("N doit être un entier positif non nul.");
            }
            double X = 4;
            double Y = 2 * Math.sqrt(2);

            for (int i = 1; i < N; ++i) {
                X = Cn(X,Y);
                Y = In(X,Y);
            }
            return new double[]{X, Y};
        }
        //Getteur

        /**
         * Getteur de X
         * @return valeur de X
         */
        public double getX(){
            return this.X;
        }

        /**
         * Getteur de Y
         * @return valeur de y
         */
        public double getY(){
            return this.Y;
        }
    }
}
