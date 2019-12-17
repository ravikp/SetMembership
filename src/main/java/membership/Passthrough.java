package membership;

class Passthrough implements Operator {

    @Override
    public boolean apply(boolean data) {
        return data;
    }
}
