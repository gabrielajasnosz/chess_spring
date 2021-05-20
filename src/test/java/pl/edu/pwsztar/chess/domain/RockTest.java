package pl.edu.pwsztar.chess.domain;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RockTest {


    private final RulesOfGame rock = new RulesOfGame.Rock();

    @Tag("Rock")
    @ParameterizedTest
    @CsvSource({
            " 0,  0,  0,  5",
            "-5, -5, 4, -5",
            "1, 7, 1, 1",
            " 4,  0,  4,  7",
    })
    void checkCorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertTrue(rock.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }

    @ParameterizedTest
    @CsvSource({
            "1,  2,  3, 4",
            "4, -6, 3,  2"
    })
    void checkIncorrectMoveForRock(int xStart, int yStart, int xStop, int yStop) {
        assertFalse(rock.isCorrectMove(new Point(xStart, yStart), new Point(xStop, yStop)));
    }
}
