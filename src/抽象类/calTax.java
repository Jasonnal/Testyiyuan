package 抽象类;

public class calTax {
    public static void main(String[] args) {
        Income[] incomes = new Income[]{new SalaryIncome(7500), new RoyaltyIncome(12000)};
        double total = 0;
        total = totalTax(incomes);
        System.out.println(total);
    }

    public static double totalTax(Income... incomes) {
        double total = 0;
        for (Income income : incomes) {
            total = total + income.getTax();
        }
        return total;
    }
}

abstract class Income {
    protected double income;

    public abstract double getTax();
}

class RoyaltyIncome extends Income {
    public RoyaltyIncome(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        return income * 0.2;
    }

}

class SalaryIncome extends Income {
    public SalaryIncome(double income) {
        this.income = income;
    }

    @Override
    public double getTax() {
        if (income <= 5000) {
            return 0;
        }
        return (income - 5000) * 0.2;
    }
}
