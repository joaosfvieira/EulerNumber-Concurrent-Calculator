import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FixedThreads {
    public static void main(String[] args) throws Exception {
        if(args.length != 2)
            throw new Exception("Number of terms and number of threads are both required as arguments");

        int numberOfTerms = Integer.parseInt(args[0]);
        int numberOfThreads = Integer.parseInt(args[1]);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<BigDecimal>> calculatedTerms = InfiniteSeriesCalculator.calculateTermsOfSeries(numberOfTerms, executorService);

        BigDecimal result = InfiniteSeriesCalculator.calculateSeriesSum(calculatedTerms);
        System.out.println("Euler number calculated using " + numberOfTerms + " terms and a Fixed Thread Pool " + result);

        executorService.shutdown();
    }
}