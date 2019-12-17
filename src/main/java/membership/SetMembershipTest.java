package membership;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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