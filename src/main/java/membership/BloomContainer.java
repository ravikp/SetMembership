package membership;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

class BloomContainer extends Container {

    private final BloomFilter<CharSequence> bag;

    public BloomContainer(int numberOfItems, double falsePositiveProbability) {
        super(numberOfItems);
        Funnel<CharSequence> funnel = Funnels.stringFunnel(Charset.forName("US-ASCII"));
        bag = BloomFilter.create(funnel, numberOfItems, falsePositiveProbability);
    }

    @Override
    public void add(String item) {
        bag.put(item);
    }

    @Override
    public boolean exists(String item) {
        return bag.mightContain(item);
    }
}
