//package assignment11.lambda;

/*
 *
 * Name: LambdaExample.java
 * Purpose: Tests two valid ways to return using
 *          a lambda expression
 * Author: grivera64
 * Date: 11/28/2021
 *
 */

import java.util.Scanner;

public class LambdaExample {

    public static void main(String[] args) {

        Addable ad1 = (a, b) -> a + b; //Equivalent of = Integer::sum;
        Addable ad2 = (a, b) -> {
            return a + b;
        };
        Scanner keyboard = new Scanner(System.in);

        int a, b;

        System.out.print("Please enter two integers: ");
        a = keyboard.nextInt();
        b = keyboard.nextInt();
        keyboard.nextLine();
        System.out.printf("Without return the sum is %d\n", ad1.add(a, b));

        System.out.print("Please enter two integers: ");
        a = keyboard.nextInt();
        b = keyboard.nextInt();
        keyboard.nextLine();
        System.out.printf("With return the sum is %d\n", ad2.add(a, b));

    }

}
