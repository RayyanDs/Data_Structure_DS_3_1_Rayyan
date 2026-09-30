/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bonustask;
import java.util.Stack;
import java.util.Scanner;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class BonusTask {
    int evaluate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] parts = expression.split(" ");
        for (int i = 0; i < parts.length; i++) {
            String item = parts[i];
            if (item.matches("\\d+")) {
                stack.push(Integer.parseInt(item));
            }else {
                int second = stack.pop();
                int first = stack.pop();
                if (item.equals("+")) {
                    stack.push(first + second);
                }else if (item.equals("-")) {
                    stack.push(first - second);
                }else if (item.equals("*")) {
                    stack.push(first * second);
                }else if (item.equals("/")) {
                    stack.push(first / second);
                }
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BonusTask p = new BonusTask();
        System.out.print("Enter Postfix Expression: ");
        String expression = sc.nextLine();

        System.out.println("Postfix Expression:");
        System.out.println(expression);

        System.out.println("Result:");
        System.out.println(p.evaluate(expression));
    }
}

