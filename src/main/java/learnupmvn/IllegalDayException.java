package learnupmvn;

public class IllegalDayException extends  IllegalArgumentException {

    public IllegalDayException(int input) {
        super("Номер дня должен быть от 1 до 365, а у вас " + input);
    }
}
