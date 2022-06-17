package BigNumber;

import java.util.*;

class BigDecimal {

    public static void main(String[] args) {
        //Input
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] s = new String[n + 2];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        sc.close();

        //code starts from here
        Arrays.sort(s, (o1, o2) -> {
            if (o1 == null || o2 == null) return 0;
            return new java.math.BigDecimal(o2).compareTo(new java.math.BigDecimal(o1));
        });
        //code ends here

        //Output
        for (int i = 0; i < n; i++) {
            System.out.println(s[i]);
        }
    }

}