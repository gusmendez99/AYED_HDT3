public class Number implements Comparable {
    private Integer value;
    public Number (Integer number){
        this.value = number;
    }
    @Override
    public int compareTo(Object o) {
        int result;
        result = value.compareTo((Integer)o);
        return result;
    }
}
