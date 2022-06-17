package Advanced;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;


public class CanYouAccess {

    public static void main(String[] args) throws Exception {
        DoNotTerminate.forbidExit();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int num = Integer.parseInt(br.readLine().trim());
            Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private

            //code starts from here
            o = new Inner().new Private();
            System.out.printf("%d is ", num);
            System.out.println(((Inner.Private) o).powerof2(num));
            //code ends here

            /**
             * Helpful comments I found for this code.
             *
             *
             * (From cor_johnson)
             * (Sean is the name of person who posted sample answer.)
             * Sean is assigning the object o to a new instance of Private.
             * However Private has a private access modifier, which means it can't be called via Solution,
             * so you need to create a new Inner object in order to create a new Private object.
             * Then in the line for printing, he casts Object o to (Solution.Inner.Private) so he can call powerof2.
             *
             *
             * (From oncepice1)
             * But "powerof2" is private methods. Why can an object of (Solution.Inner.Private) call powerof2 method?
             * As I know private means the method can only be called inside of the Class in which it is defined.
             * Can you explain more clearly? Thanks!!!
             *
             *
             * (From Almeidayoel)
             * class Solution is the containing class of class Inner which is the containing class of class Private.
             * The outer class ( containing class ) can call even the private methods of the inner class.
             */

            System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");

        }//end of try

        catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }//end of main

    static class Inner {
        private class Private {
            private String powerof2(int num) {
                return ((num & num - 1) == 0) ? "power of 2" : "not a power of 2";
            }
        }
    }//end of Inner

}//end of Solution

class DoNotTerminate { //This class prevents exit(0)

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1L;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}

