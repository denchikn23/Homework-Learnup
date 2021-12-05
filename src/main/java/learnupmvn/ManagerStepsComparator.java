package learnupmvn;

import java.util.Comparator;
import java.util.Map;

public class ManagerStepsComparator implements Comparator<StepsManager>  {
    private int minSteps;

    public ManagerStepsComparator(int minSteps) {
        this.minSteps = minSteps;
    }

    @Override
    public int compare(StepsManager playerFirst, StepsManager playerSecond) {
        int countPlayerFirst = 0;
        int countPlayerSecond = 0;

        Map<Integer, Integer> statFirstPlayer = playerFirst.getStat();
        Map<Integer, Integer> statSecondPlayer = playerSecond.getStat();

        for (Integer i : statFirstPlayer.keySet()){
            if (statFirstPlayer.get(i) > minSteps){
                countPlayerFirst++;
            }
        }

        for (Integer i : statSecondPlayer.keySet()){
            if (statSecondPlayer.get(i) > minSteps){
                countPlayerSecond++;
            }
        }

        return countPlayerFirst - countPlayerSecond;
    }
}
