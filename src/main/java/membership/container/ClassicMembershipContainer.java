package membership.container;

import java.util.HashSet;

public class ClassicMembershipContainer extends Container {

    private final HashSet<String> bag;

    public ClassicMembershipContainer(int count) {
        super(count);
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
}
