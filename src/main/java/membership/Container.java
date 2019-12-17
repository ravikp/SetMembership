package membership;

abstract class Container {
    private int count;

    public Container(int count) {
        this.count = count;
    }

    public abstract void add(String item);
    public abstract boolean exists(String item);
    public int count(){
        return count;
    }
}
