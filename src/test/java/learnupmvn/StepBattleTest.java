package learnupmvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StepBattleTest {
    StepsManager managerFirst = new StepsManager();
    StepsManager managerSecond = new StepsManager();
    StepBattle battleFirst = new StepBattle(managerFirst, managerSecond);

    @BeforeEach
        public void managersInit(){
        battleFirst.addSteps(1, 1, 40);
        battleFirst.addSteps(1, 2, 50);
        battleFirst.addSteps(1, 3, 50);
        battleFirst.addSteps(1, 4, 30);
        battleFirst.addSteps(2, 1, 100);
        battleFirst.addSteps(2, 2, 80);
        battleFirst.addSteps(2, 3, 20);
        battleFirst.addSteps(2, 4, 10);
        battleFirst.addSteps(0, 300, 450);
        battleFirst.addSteps(0, 300, 450);
    }


    @Test
    public void shouldWorkWithCompareTo(){
        int expected = managerFirst.compareTo(managerSecond);
        int actual = -40;

        Assertions.assertEquals(expected, actual, "Неправильно сравнивает по сумме шагов.");

    }
    @Test
    public void shouldWorkWithComparator(){
        ManagerStepsComparator comp = new ManagerStepsComparator(30);
        int expected = comp.compare(managerFirst, managerSecond);
        int actual = 1;

        Assertions.assertEquals(expected, actual, "Неправильно сравнивает по количеству дней, превышающим минимальное значение шагов.");
    }


}
