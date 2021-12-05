package learnupmvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.Map;

public class StepBattleTest {
    StepsManager managerFirst = Mockito.mock(StepsManager.class);
    StepsManager managerSecond = Mockito.mock(StepsManager.class);
    StepBattle battleFirst = new StepBattle(managerFirst, managerSecond);

    @Test
    public void shouldAdd(){
        battleFirst.addSteps(1, 1, 3);
        battleFirst.addSteps(2, 3, 5);
        battleFirst.addSteps(0, 300, 450);

        int expectedDayFirstPlayer = 1;
        int expectedStepsFirstPlayer = 3;
        int expectedDaySecondPlayer = 3;
        int expectedStepsSecondPlayer = 5;

        verify(managerFirst).add(expectedDayFirstPlayer, expectedStepsFirstPlayer);
        verify(managerSecond).add(expectedDaySecondPlayer, expectedStepsSecondPlayer);
    }

    @Test
    public void stepBattleWinner(){
        doReturn(
                Map.of(1,40,2,50,3,50,5,30)
        ).when(managerFirst).getStat();

        doReturn(
                Map.of(1,100,2,80,3,20,5,10)
        ).when(managerSecond).getStat();

        int actual = battleFirst.winner();
        int expected = 2;

        Assertions.assertEquals(expected, actual, "Неправильно выводит победившего игрока.");
    }
}
