package gauravkumar.cucumber;

import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;
import org.junit.runners.model.RunnerScheduler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ParallelSuite extends Suite {

    public ParallelSuite(Class<?> class1, RunnerBuilder builder) throws InitializationError {

        super(class1, builder);

        setScheduler(new RunnerScheduler() {

            private final ExecutorService service = Executors.newFixedThreadPool(5);

            public void schedule(Runnable childStatement) {
                service.submit(childStatement);
            }

            public void finished() {
                try {
                    while (!service.awaitTermination(600, TimeUnit.SECONDS)) {
                        service.shutdownNow();
                    }
                } catch (InterruptedException ie) {
                    service.shutdownNow();
                    Thread.currentThread().interrupt();
                }
            }
        });
    }
}
