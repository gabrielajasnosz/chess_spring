package pl.edu.pwsztar.chess.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;

@Transactional
public class ChessFacade {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame queen;
    private RulesOfGame king;
    private RulesOfGame rock;
    private RulesOfGame pawn;

    PointConverter pointConverter=new PointConverter();


    public ChessFacade() {
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        queen = new RulesOfGame.Queen();
        king = new RulesOfGame.King();
        rock = new RulesOfGame.Rock();
        pawn = new RulesOfGame.Pawn();
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {

        switch (figureMoveDto.getType()) {
            case BISHOP:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return bishop.isCorrectMove(pointConverter.convert(figureMoveDto.getSource()),pointConverter.convert(figureMoveDto.getDestination()));
            case KNIGHT:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return knight.isCorrectMove(pointConverter.convert(figureMoveDto.getSource()),pointConverter.convert(figureMoveDto.getDestination()));
            case KING:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return king.isCorrectMove(pointConverter.convert(figureMoveDto.getSource()),pointConverter.convert(figureMoveDto.getDestination()));
            case QUEEN:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return queen.isCorrectMove(new Point(0, 0), new Point(1, 1));
            case ROCK:
//                System.out.println(pointConverter.convert(figureMoveDto.getSource()).getX());
//                System.out.println(pointConverter.convert(figureMoveDto.getSource()).getY());
//                System.out.println(pointConverter.convert(figureMoveDto.getDestination()).getX());
//                System.out.println(pointConverter.convert(figureMoveDto.getDestination()).getY());
//                System.out.println(rock.isCorrectMove(pointConverter.convert(figureMoveDto.getSource()),pointConverter.convert(figureMoveDto.getDestination())));

                return rock.isCorrectMove(pointConverter.convert(figureMoveDto.getSource()),pointConverter.convert(figureMoveDto.getDestination()));
            case PAWN:
                // wywolaj konwerter punktow oraz popraw ponizszy kod
                return pawn.isCorrectMove(new Point(0, 0), new Point(1, 1));
        }

        return false;
    }
}
