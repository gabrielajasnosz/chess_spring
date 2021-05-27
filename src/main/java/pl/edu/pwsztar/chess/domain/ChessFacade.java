package pl.edu.pwsztar.chess.domain;

import org.springframework.transaction.annotation.Transactional;
import pl.edu.pwsztar.chess.dto.FigureMoveDto;
import pl.edu.pwsztar.chess.dto.FigureType;

import java.util.HashMap;
import java.util.Map;

@Transactional
public class ChessFacade {

    private RulesOfGame bishop;
    private RulesOfGame knight;
    private RulesOfGame queen;
    private RulesOfGame king;
    private RulesOfGame rock;
    private RulesOfGame pawn;


    PointConverter pointConverter = new PointConverter();


    public ChessFacade() {
        bishop = new RulesOfGame.Bishop();
        knight = new RulesOfGame.Knight();
        queen = new RulesOfGame.Queen();
        king = new RulesOfGame.King();
        rock = new RulesOfGame.Rock();
        pawn = new RulesOfGame.Pawn();
    }

    public boolean isCorrectMove(FigureMoveDto figureMoveDto) {
        Map<FigureType, RulesOfGame> figures = new HashMap<>();
        figures.put(FigureType.BISHOP, new RulesOfGame.Bishop());
        figures.put(FigureType.KNIGHT, new RulesOfGame.Knight());
        figures.put(FigureType.KING, new RulesOfGame.King());
        figures.put(FigureType.ROCK, new RulesOfGame.Rock());

        return figures.get(figureMoveDto.getType()).isCorrectMove(pointConverter.convert(figureMoveDto.getSource()), pointConverter.convert(figureMoveDto.getDestination()));
    }
}
