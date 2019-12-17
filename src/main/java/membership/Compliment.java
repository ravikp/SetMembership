package membership;

class Compliment implements Operator {
    @Override
    public boolean apply(boolean data) {
        return !data;
    }
}
