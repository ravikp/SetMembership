package hello;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;

import java.util.*;

public class SetMembershipTest {

    public static void testClassicMembership(int no_of_items) {
        final SetContainer container = new SetContainer(no_of_items);
        testMembership(container);
    }

    public static void testScalableMembership(int no_of_random_items) {
        final BloomContainer container = new BloomContainer(no_of_random_items);
        testMembership(container);
    }

    private static void testMembership(Container container) {
        List<String> in_set = new ArrayList<>();
        List<String> not_in_set = new ArrayList<>();

        for (int i = 0; i < container.count(); i++) {
            String random = UUID.randomUUID().toString();

            if (i % 10_000 == 0) {
                not_in_set.add(random);
                continue;
            }

            container.add(random);

            if (i % 5_000 == 0) {
                in_set.add(random);
            }
        }

        printSuccessRate("Items in set", container, in_set, new Passthrough());
        printSuccessRate("Items not in set", container, not_in_set, new Compliment());
    }

    private static void printSuccessRate(String message, Container container, List<String> in_set, Operator operator) {
        int count = 0;
        for (String item : in_set) {
            if (operator.apply(container.exists(item)))
                count++;
        }

        double passPercentage = count * 100.0 / in_set.size();
        System.out.println(message + " Success rate: " + passPercentage + "%");
    }
}

interface Operator {
    boolean apply(boolean data);
}

class Passthrough implements Operator {

    @Override
    public boolean apply(boolean data) {
        return data;
    }
}

class Compliment implements Operator {
    @Override
    public boolean apply(boolean data) {
        return !data;
    }
}

interface Container {
    void add(String item);

    boolean exists(String item);

    int count();
}

class SetContainer implements Container {

    private final HashSet<String> bag;
    private int count;

    public SetContainer(int count) {
        this.count = count;
        bag = new HashSet<String>();
    }

    @Override
    public void add(String item) {
        bag.add(item);
    }

    @Override
    public boolean exists(String item) {
        return bag.contains(item);
    }

    @Override
    public int count() {
        return count;
    }
}

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