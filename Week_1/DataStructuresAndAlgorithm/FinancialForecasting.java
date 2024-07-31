public class FinancialForecasting {

    public static double calculateFutureValue(double pastValue, double growthRate, int years) {
        if (years == 0) {
            return pastValue;
        }
        return calculateFutureValue(pastValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        double pastValue = 5000;
        double growthRate = 0.07;
        int years = 5;

        double futureValue = calculateFutureValue(pastValue, growthRate, years);

        System.out.printf("The future value after %d years is: %.2f%n", years, futureValue);
    }
}
