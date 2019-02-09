public class Number implements Comparable {
    private Integer value;
    public Number (Integer number){
        this.value = number;
    }
    @Override
    public int compareTo(Object o) {
        int result;
        Number objectAsNumber = (Number)o;
        result = value.compareTo(objectAsNumber.getValue());
        return result;
    }

    public Integer getValue() {
        return value;
    }
}
