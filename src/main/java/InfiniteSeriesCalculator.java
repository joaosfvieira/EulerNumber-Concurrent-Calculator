import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class InfiniteSeriesCalculator {
    public static BigDecimal calculateSeriesSum(List<Future<BigDecimal>> terms) throws ExecutionException, InterruptedException {
        BigDecimal infiniteSeriesSum = BigDecimal.ZERO;
        for (Future<BigDecimal> term : terms)
            infiniteSeriesSum = infiniteSeriesSum.add(term.get());

        return infiniteSeriesSum;
    }

    public static List<Future<BigDecimal>> calculateTermsOfSeries(int numberOfTerms, ExecutorService executorService){
        List<Future<BigDecimal>> terms = new ArrayList<>();
        for (int i=numberOfTerms; i>=0; i--) {
            Callable<BigDecimal> factorialTask = new FactorialCalculator(i);
            Future<BigDecimal> term = executorService.submit(factorialTask);
            terms.add(term);
        }
        return terms;
    }
}