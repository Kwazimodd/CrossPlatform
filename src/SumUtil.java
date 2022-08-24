import java.math.BigDecimal;

public class SumUtil {
    private SumUtil() {
    }

    public static String getHarmonicSum(int size) {
        if (size <= 0) throw new IllegalArgumentException("Size must be greater then 0");
        if (size > 15) {
            BigDecimal sum = new BigDecimal("0.");
            for(int i = 1; i <= size; i++) {
                sum = sum.add(new BigDecimal(1./i));
            }
            return sum.toString();
        }
        else {
            double sum = 0.;
            for(int i = 1; i <= size; i++) {
                sum +=  1. / i;
            }
            return String.valueOf(sum);
        }
    }
}
