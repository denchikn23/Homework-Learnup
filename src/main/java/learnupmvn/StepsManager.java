package learnupmvn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StepsManager implements Comparable <StepsManager>{
    public int maxSteps;

    private Map<Integer, Integer> stat = new HashMap<>();

    public Map<Integer, Integer> getStat() {
        return stat;
    }

    public int add(int day, int steps) {
        if (stat.containsKey(day)){
            stat.put(day, stat.get(day) + steps);
        }
        else{
            stat.put(day, steps);
        }

        setMaxSteps();
        return maxSteps - stat.get(day) + 1;
    }

    public int setMaxSteps(){
        for (Integer i : stat.keySet()){
            if (stat.get(i) > maxSteps){
                maxSteps = stat.get(i);
            }
        }
        return maxSteps;
    }


    @Override
    public int compareTo(StepsManager playerSecond) {
        int sumStepsFirstPlayer = 0;
        int sumStepsSecondPlayer = 0;

        Map<Integer, Integer> statSecondPlayer = playerSecond.getStat();

        for (Integer i : stat.keySet()){
            sumStepsFirstPlayer += stat.get(i);
        }

        for(Integer i : statSecondPlayer.keySet()){
            sumStepsSecondPlayer += statSecondPlayer.get(i);
        }

        return sumStepsFirstPlayer - sumStepsSecondPlayer;
    }
}
