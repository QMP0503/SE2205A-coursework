public class Pair <Y,N> {
    private Y key;
    private N value;

    public Pair() {
    }

    public Pair(Y key, N value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "[YR: " + key + ",NM: " + value + "]";
    }
}