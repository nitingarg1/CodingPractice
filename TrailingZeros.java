import java.math.BigDecimal;

public class TrailingZeros {

    public static void main(String[] args) {
    System.out.println(new TrailingZeros().trailingZeroes(1313));
    }

    public int trailingZeroes(int n) {
    BigDecimal factorial = fact(new BigDecimal(n));
    int zeroCount=0;
    while(factorial.remainder(BigDecimal.TEN).equals(BigDecimal.ZERO) && !factorial.equals(BigDecimal.ZERO)){
        factorial=factorial.divide(BigDecimal.TEN);
        zeroCount++;
    }
    return zeroCount;
    }

    public BigDecimal fact(BigDecimal n){
        if(n.equals(BigDecimal.ONE) || n.compareTo(BigDecimal.ZERO)<=0)
            return BigDecimal.ONE;
            return n.multiply(fact(n.subtract(BigDecimal.ONE)));
    }
}
