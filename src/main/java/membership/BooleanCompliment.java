package membership;

class BooleanCompliment implements Operator {
    @Override
    public boolean apply(boolean data) {
        return !data;
    }
}
