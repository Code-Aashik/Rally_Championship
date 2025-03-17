package week9;

import java.util.List;

public interface RaceResult {
    void recordResult(Driver driver, int position, double points);
    List<String> getResults();
}


