/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import java.util.Scanner;
import java.util.*;

/**
 *
 * @author user
 */
public class ExpressionTest {

    public static void main(String[] args) {
        // TODO code application logic here

        Vector exp = new Vector();

        Scanner in = new Scanner(System.in);
        Expression opExp = new Expression();
        System.out.println("Enter your expression,"
                + "after each operator oroperand press enter,"
                + "to end the expression press enter");
        char chr = 'h';
        int num;
        try {
            while (chr != '=') {

                System.out.println("Enter your expression element");
                num = in.nextInt();
                exp.add(new Integer(num));
                System.out.println("Enter your expression element");
                chr = in.next().charAt(0);

                exp.add(new Character(chr));
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("exception1 " + e1);
        } catch (InputMismatchException e2) {
            System.out.println("exception2 " + e2);
        }

        opExp.setExp(exp);

        int result=opExp.computeExp();
        System.out.println("result : " + result);
    }

}
