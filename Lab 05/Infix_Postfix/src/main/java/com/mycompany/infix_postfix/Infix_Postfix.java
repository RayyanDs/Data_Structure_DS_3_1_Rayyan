/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.infix_postfix;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class Infix_Postfix {
    int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        }
        return 0;
    }

    String InfixToPostfix(String expression) {
        Stack<Character> stack = new Stack<>();
        String postfix = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            // Ignore spaces
            if (ch == ' ') {
                continue;
            }
            // If operand
            if (Character.isLetterOrDigit(ch)) {
                postfix = postfix + ch + " ";
            }
            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }
            // Closing bracket
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.pop();
            }
            // Operator
            else {
                while (!stack.isEmpty() && stack.peek() != '(' && precedence(stack.peek()) >= precedence(ch)) {
                    postfix = postfix + stack.pop() + " ";
                }
                stack.push(ch);
            }
        }

        // Pop remaining operators
        while (!stack.isEmpty()) {
            postfix = postfix + stack.pop() + " ";
        }
        return postfix;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Infix_Postfix obj = new Infix_Postfix();

        System.out.println("Enter Infix Expression:");
        String expression = sc.nextLine();

        System.out.println("Infix Expression:");
        System.out.println(expression);

        System.out.println("Postfix Expression:");
        System.out.println(obj.InfixToPostfix(expression));
    }
}

