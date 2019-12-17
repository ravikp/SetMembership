package membership;

interface Container {
    void add(String item);

    boolean exists(String item);

    int count();
}
