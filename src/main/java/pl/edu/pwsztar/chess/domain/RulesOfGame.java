package pl.edu.pwsztar.chess.domain;

interface RulesOfGame {

    /**
     * Metoda zwraca true, tylko gdy przejscie z polozenia
     * source na destination w jednym ruchu jest zgodne
     * z zasadami gry w szachy
     */
    boolean isCorrectMove(Point source, Point destination);

    class Bishop implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if(source.getX() == destination.getX() && source.getY() == destination.getY()) {
                return false;
            }

            return Math.abs(destination.getX() - source.getX()) ==
                    Math.abs(destination.getY() - source.getY());
        }
    }

    class Knight implements RulesOfGame {
        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if((Math.abs(destination.getX()-source.getX())==2 && Math.abs(destination.getY()-source.getY())==1 ) || (Math.abs(destination.getX()-source.getX())==1 && Math.abs(destination.getY()-source.getY())==2 )){
                return true;
            }
            return false;
        }
    }
    class Queen implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            // TODO: Prosze dokonczyc implementacje
            return true;
        }
    }

    class King implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if((source.getX()==destination.getX() && Math.abs(source.getY()-destination.getY())==1) || (source.getY()==destination.getY() && Math.abs(source.getX()-destination.getX())==1)){
            return true;
        }
        return false;
    }
        }

    class Rock implements RulesOfGame {
        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            if(source.getX()==destination.getX() || source.getY()==destination.getY()){
                return true;
            }
            return false;

        }
    }

    class Pawn implements RulesOfGame {

        @Override
        public boolean isCorrectMove(Point source, Point destination) {
            // TODO: Prosze dokonczyc implementacje
            return true;
        }
    }


    // TODO: Prosze dokonczyc implementacje kolejnych figur szachowych: Knight, King, Queen, Rook, Pawn
    // TODO: Prosze stosowac zaproponowane nazwy klas !!!
    // TODO: Kazda klasa powinna implementowac interfejs RulesOfGame
}
