package membership.container;

import com.github.mgunlogson.cuckoofilter4j.CuckooFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class CuckooContainer extends Container {
    private final CuckooFilter<String> filter;

    public CuckooContainer(int numberOfItems, double falsePositiveRate) {
        super(numberOfItems);
        filter = new CuckooFilter.Builder<String>(Funnels.stringFunnel(Charset.forName("US-ASCII")), count())
                .withFalsePositiveRate(falsePositiveRate)
                .build();
    }

    @Override
    public void add(String item) {
        filter.put(item);
    }

    @Override
    public boolean exists(String item) {
        return filter.mightContain(item);
    }
}
