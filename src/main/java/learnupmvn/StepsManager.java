package learnupmvn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StepsManager {
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
        Set<Integer> days = stat.keySet();
        Integer[] arrDays = days.toArray(new Integer[days.size()]);
        for(int i = 0; i < arrDays.length; i++){
            if (stat.get(arrDays[i]) > maxSteps){
                maxSteps = stat.get(arrDays[i]);
            }
        }
        return maxSteps;
    }
}
