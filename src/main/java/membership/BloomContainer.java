package membership;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

class BloomContainer implements Container {

    private final BloomFilter<CharSequence> bag;
    private final int count;

    public BloomContainer(int count) {
        this.count = count;
        Funnel<CharSequence> funnel = Funnels.stringFunnel();
        bag = BloomFilter.create(funnel, count, 0.01);
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
