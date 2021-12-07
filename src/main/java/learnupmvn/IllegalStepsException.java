package learnupmvn;

public class IllegalStepsException extends  IllegalArgumentException {

    public IllegalStepsException(int input) {
        super("Количество шагов должно быть положительным, а у вас " + input);
    }
}
