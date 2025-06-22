import java.util.Scanner;

public class FinancialForecasting {
    public static double futureValue(double presentValue, double rate, int years) {
        if (years == 0)
            return presentValue;
        return (1 + rate) * futureValue(presentValue, rate, years - 1); // recursive case
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Present Value (PV): ");
        double pv = sc.nextDouble();
        System.out.print("Enter Annual Growth Rate (as %): ");
        double rate = sc.nextDouble() / 100.0;
        System.out.print("Enter Number of Years: ");
        int n = sc.nextInt();
        double result = futureValue(pv, rate, n);
        System.out.printf("Future Value after %d years: $%.2f\n", n, result);
        sc.close();
    }
}
