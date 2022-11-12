import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<BigDecimal> {
    private final int term;

    public FactorialCalculator(int term) {
        this.term = term;
    }

    @Override
    public BigDecimal call() {
        System.out.println("Number of active Threads: " + Thread.activeCount());
        return this.infiniteSeriesTermCalculator(this.term);
    }

    private BigDecimal infiniteSeriesTermCalculator(int term) {
        return BigDecimal.valueOf(1.0 / factorial(term));
    }

    private int factorial(int term) {
        int factorialOfTerm = 1;
        for (int i = term; i > 1; i--)
            factorialOfTerm *= i;

        return factorialOfTerm;
    }
}