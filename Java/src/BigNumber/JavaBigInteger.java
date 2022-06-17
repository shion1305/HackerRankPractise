package BigNumber;

import java.math.BigInteger;
import java.util.Scanner;

public class JavaBigInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger i1 = scanner.nextBigInteger();
        BigInteger i2 = scanner.nextBigInteger();
        System.out.println(i1.add(i2));
        System.out.println(i1.multiply(i2));
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}