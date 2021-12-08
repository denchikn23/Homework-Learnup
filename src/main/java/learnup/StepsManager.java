package learnup;

import java.util.*;

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

    void getAllAbove(int steps) {
        stat.entrySet().stream()
                .filter(s -> s.getValue() > steps)
                .map(s -> s.getKey())
                .forEach(System.out::println);
    }



    public static void main(String[] args) {
        StepsManager actualManager = new StepsManager();


        actualManager.add(5, 30);
        actualManager.add(3, 40);
        actualManager.add(2, 10);
        actualManager.add(2, 40);
        actualManager.add(1, 40);
        actualManager.add(3, 10);
        actualManager.add(4, 10);
        actualManager.add(7, 40);
        actualManager.add(8, 20);
        actualManager.add(9, 60);

        actualManager.getAllAbove(30);
    }
}
