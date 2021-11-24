package learnupmvn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Locale;

public class PersonalAccountTest {
    PersonalAccount client = new PersonalAccount();

    @ParameterizedTest
    @CsvSource({
            "150.0, 150.0",
            "0.0, 0.0",
            "-150.0, 0.0"
    })
    public void shouldWorkWithIncome(double income, double expectedTotalIncome){

        client.addIncome(income);

        double actual = client.getTotalIncome();

        Assertions.assertEquals(expectedTotalIncome, actual, "Некорректная работа с вводом доходов.");
    }

    @ParameterizedTest
    @CsvSource({
            "200.0, 100.0, 100.0",
            "150.0, 150.0, 150.0",
            "150.0, 0.0, 0.0",
            "0.0, 0.0, 0.0",
            "0.0, 150.0, 0.0",
            "-150.0, 0.0, 0.0",
            "0.0, -150.0, 0.0",
            "-150.0, -150.0, 0.0",
            "150.0, 200.0, 150.0"
    })
    public void shouldWorkWithExpenditure(double income, double expenditure, double expectedTotalExpenditure){

        client.addIncome(income);
        client.addExpenditure(expenditure);

        double actual = client.getTotalExpenditure();

        Assertions.assertEquals(expectedTotalExpenditure, actual, "Некорректная работа с вводом расходов.");
    }

    @ParameterizedTest
    @CsvSource({
            "150, 9",
            "0,0",
            "-150,0"
    })
    public void shouldWorkWithFirstTax(double income, double expectedTotalFirstTax){

        client.addIncome(income);

        double actual = client.firstTax();

        Assertions.assertEquals(expectedTotalFirstTax, actual, "Неправильная работа с первым налогом.");
    }

    @ParameterizedTest
    @CsvSource({
            "200.0, 100.0, 15.0",
            "150.0, 150.0, 0.0",
            "150.0, 0.0, 22.5",
            "0.0, 0.0, 0.0",
            "0.0, 150.0, 0.0",
            "-150.0, 0.0, 0.0",
            "0.0, -150.0, 0.0",
            "-150.0, -150.0, 0.0",
            "150.0, 200.0, 0.0"
    })
    public void shouldWorkWithSecondTax(double income, double expenditure, double expectedTotalSecondTax){

        client.addIncome(income);
        client.addExpenditure(expenditure);

        double actual = client.secondTax();

        Assertions.assertEquals(expectedTotalSecondTax, actual, "Неправильная работа со вторым налогом.");
    }
}
