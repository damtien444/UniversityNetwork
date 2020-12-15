class Pair<U, V>
{
    public final U first;       // first field of a Pair
    public final V second;      // second field of a Pair

    Pair(U first, V second)
    {
        this.first = first;
        this.second = second;
    }

    public static <U, V> Pair <U, V> of(U a, V b)
    {
        return new Pair<>(a, b);
    }
}