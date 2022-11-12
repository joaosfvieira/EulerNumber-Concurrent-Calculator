import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class WorkStealingThreads {
    public static void main(String[] args) throws Exception {
        if(args.length != 1)
            throw new Exception("Number of terms is required as an argument");

        int numberOfTerms = Integer.parseInt(args[0]);
        ExecutorService executorService = Executors.newWorkStealingPool();

        List<Future<BigDecimal>> calculatedTerms = InfiniteSeriesCalculator.calculateTermsOfSeries(numberOfTerms, executorService);

        BigDecimal result = InfiniteSeriesCalculator.calculateSeriesSum(calculatedTerms);
        System.out.println("Euler number calculated using " + numberOfTerms + " terms and a Work Stealing Thread Pool: " + result);

        executorService.shutdown();
    }
}