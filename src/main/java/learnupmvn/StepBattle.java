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
        return (playerFirst.compareTo(playerSecond) > 0) ? 1 : 2;
    }

    public static void main(String[] args) {

    }
}
