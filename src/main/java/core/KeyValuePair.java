package core;

public class KeyValuePair<T> {
    private T first;
    private T second;

    public KeyValuePair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    // return getFirst element
    public T getFirst() {
        return first;
    }

    // return getSecond element
    public T getSecond() {
        return second;
    }
}
