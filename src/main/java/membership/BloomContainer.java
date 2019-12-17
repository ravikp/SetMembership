package membership;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

class BloomContainer implements Container {

    private final BloomFilter<CharSequence> bag;
    private final int count;

    public BloomContainer(int count, double falsePositiveProbability) {
        this.count = count;
        Funnel<CharSequence> funnel = Funnels.stringFunnel(Charset.forName("US-ASCII"));
        bag = BloomFilter.create(funnel, count, falsePositiveProbability);
    }

    @Override
    public void add(String item) {
        bag.put(item);
    }

    @Override
    public boolean exists(String item) {
        return bag.mightContain(item);
    }

    @Override
    public int count() {
        return count;
    }
}
