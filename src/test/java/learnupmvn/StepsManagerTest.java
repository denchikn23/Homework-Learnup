package learnupmvn;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class StepsManagerTest {
    StepsManager actualManager = new StepsManager();

    @Test
    public void shouldThrowExceptionDay(){
        int inputDays = 366;
        int inputSteps = 366;
        Assertions.assertThrows(IllegalDayException.class, () -> {
            actualManager.add(inputDays, inputSteps);
        });
    }

    @Test
    public void shouldThrowExceptionSteps(){
        int inputDays = 23;
        int inputSteps = -23;
        Assertions.assertThrows(IllegalStepsException.class, () -> {
            actualManager.add(inputDays, inputSteps);
        });
    }
}
