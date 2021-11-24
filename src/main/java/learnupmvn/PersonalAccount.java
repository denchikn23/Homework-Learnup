package learnupmvn;

public class PersonalAccount {
    private double income;
    private double expenditure;

    public void addIncome(double income){
        if (income < 0.0) {
            return;
        }
        this.income += income;
        }
    public void addExpenditure(double expenditure){
        if (expenditure < 0.0) {
            return;
        }
        this.expenditure+= (expenditure > income)?income:expenditure;
    }

    public double getTotalIncome() {
        return income;
    }

    public double getTotalExpenditure() {
        return expenditure;
    }

    public double firstTax(){
        return income * 6 /100;
    }

    public double secondTax(){
        return (income - expenditure) * 15 /100;
    }
}
