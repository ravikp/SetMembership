package membership;

import java.util.HashSet;

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
