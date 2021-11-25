package learnupmvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepsManagerTest {
    StepsManager actualManager = new StepsManager();

    @Test
    public void creatingStepManager(){

        actualManager.add(5, 30);
        actualManager.add(3, 40);
        actualManager.add(2, 10);
        actualManager.add(2, 40);
        actualManager.add(1, 40);
        actualManager.add(3, 10);

        Map<Integer, Integer> expectedManager = Map.of(1,40,2,50,3,50,5,30);

        Assertions.assertEquals(expectedManager, actualManager.getStat());
    }

    @Test
    public void changeStepManager(){

        List<Integer> actualSteps = new ArrayList<>();
        actualSteps.add(actualManager.add(5, 30));
        actualSteps.add(actualManager.add(3, 40));
        actualSteps.add(actualManager.add(2, 10));
        actualSteps.add(actualManager.add(2, 40));
        actualSteps.add(actualManager.add(1, 40));
        actualSteps.add(actualManager.add(3, 10));

        List<Integer> expectedSteps = List.of(1, 1, 31, 1, 11, 1);

        Assertions.assertEquals(expectedSteps, actualSteps);
    }

}
