package learnupmvn;

import java.util.Map;
import java.util.Set;

public class StepBattle {
    private StepsManager playerFirst;
    private StepsManager playerSecond;

    public StepBattle(StepsManager playerFirst, StepsManager playerSecond){
        this.playerFirst = playerFirst;
        this.playerSecond = playerSecond;
    }

    public StepsManager getPlayerFirst() {
        return playerFirst;
    }

    public StepsManager getPlayerSecond() {
        return playerSecond;
    }

    public void addSteps(int player, int day, int steps){
        if (player == 1){
            playerFirst.add(day, steps);
        }
        else if (player == 2){
            playerSecond.add(day, steps);
        }
        else {
            return;
        }
    }

    int winner(){
        int sumStepsFirstPlayer = 0;
        int sumStepsSecondPlayer = 0;
        Map<Integer, Integer> statFirstPlayer = playerFirst.getStat();
        Map<Integer, Integer> statSecondPlayer = playerSecond.getStat();
        Set<Integer> daysFirstPlayer = statFirstPlayer.keySet();
        Set<Integer> daysSecondPlayer = statSecondPlayer.keySet();
        Integer[] arrDaysFirstPlayer = daysFirstPlayer.toArray(new Integer[daysFirstPlayer.size()]);
        Integer[] arrDaysSecondPlayer = daysSecondPlayer.toArray(new Integer[daysSecondPlayer.size()]);
        for(int i = 0; i < arrDaysFirstPlayer.length; i++){
            sumStepsFirstPlayer += statFirstPlayer.get(arrDaysFirstPlayer[i]);
        }
        for(int i = 0; i < arrDaysSecondPlayer.length; i++){
            sumStepsSecondPlayer += statSecondPlayer.get(arrDaysSecondPlayer[i]);
        }
        return (sumStepsFirstPlayer > sumStepsSecondPlayer) ? 1 : 2;
    }
}
