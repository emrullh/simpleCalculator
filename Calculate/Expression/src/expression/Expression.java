/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expression;

import java.util.*;
import java.util.Vector;

/**
 *
 * @author user
 */
class Operand  {

    private int operand[];

    public Operand() {

    }

    public void setOperand(int[] op) {
        operand = op.clone();
    }

    public int[] getOperand() {
        return operand;
    }
}

class Operator  {

    private char operators[];

    public void setOperator(char[] ch) {

        operators = ch.clone();

    }

    public char[] getOperator() {
        return operators;
    }

    public void print() {
        
        for (int i = 0; i < operators.length; ++i) {
            System.out.println(operators[i]);
        }

    }

}

/////////////////////////////////////////////////

public class Expression {

    private Vector Express;

    public Expression() {

    }

    public Expression(Vector exp) {
        Express = exp;

    }

    public void setExp(Vector exp) {

        Express = exp;
    }

    public Vector getExp() {
        return Express;
    }

    public int computeExp() {

        Operand and = new Operand();
        Operator or = new Operator();

        int size = Express.size() / 2;
        int[] operand = new int[size];
        char[] operator = new char[size];//decrement
        int[] arr;
        char[] ch;

        int n = 0, m = 0;

        for (int i = 0; i < Express.size(); ++i) {

            if (i % 2 == 0) {
                operand[m] = (Integer) Express.elementAt(i);
                ++m;
            } else {
                operator[n] = (Character) Express.get(i);
                ++n;
            }

        }

        and.setOperand(operand);
        or.setOperator(operator);

        char opt;
        int j;
        int result = 0;
        try {
            for (int i = 0; or.getOperator()[0] != '='; ++i) {
                System.out.printf("step %d ",i);
                for (int s = 0; s < and.getOperand().length; ++s) {
                    System.out.printf(" %d %c", and.getOperand()[s], or.getOperator()[s]);
                }

                System.out.printf("\n");

                opt = priorty(or.getOperator());//Find priorty operator

                for (j = 0; j < or.getOperator().length; ++j) {
                    if (or.getOperator()[j] == opt) {
                        break;
                    }

                }

                operand[j] = result(opt, and.getOperand()[j], and.getOperand()[j + 1]);
                result = operand[j];

                arr = new int[and.getOperand().length - 1];
                ch = new char[or.getOperator().length - 1];
                int l = 0;
                for (int k = 0; k < arr.length && l < and.getOperand().length; ++k, ++l) {
                    if (k == j) {
                        arr[k] = operand[j];
                        l = j + 1;

                    } else {
                        arr[k] = and.getOperand()[l];
                    }

                }
                l = 0;
                for (int c = 0; c < ch.length && l < or.getOperator().length; ++c, ++l) {
                    if (or.getOperator()[c] == opt) {
                        l = c + 1;
                    }
                    ch[c] = or.getOperator()[l];
                }

                and.setOperand(arr);
                or.setOperator(ch);

            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            System.out.println("exception3 " + e1);
        }
        

        return result;
    }
    //Find Priorty Operator
    public char priorty(char[] chr) {

        for (int j = 0; j < chr.length; ++j) {
            if (chr[j] == '*') {
                return chr[j];
            }
        }

        for (int j = 0; j < chr.length; ++j) {
            if (chr[j] == '/') {
                return chr[j];
            }
        }

        for (int j = 0; j < chr.length; ++j) {
            if (chr[j] == '+') {
                return chr[j];
            }
        }

        for (int j = 0; j < chr.length; ++j) {
            if (chr[j] == '-') {
                return chr[j];
            }
        }

        return '=';

    }

    public int result(char op, int num1, int num2) {
       
        int result = 0;//temprary
        if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            result = num1 / num2;
        } else if (op == '+') {
            result = num1 + num2;
        } else if (op == '-') {
            result = num1 - num2;
        } else {
            System.err.println("Not operator");
        }
        return result;
    }

}
