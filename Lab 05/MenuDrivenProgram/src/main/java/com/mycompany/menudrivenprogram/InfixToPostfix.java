/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menudrivenprogram;

import java.util.Stack;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class InfixToPostfix {
    int precedence(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        }
        if (ch == '*' || ch == '/' || ch == '%') {
            return 2;
        }
        return 0;
    }

    String Infix_To_Postfix(String expression) {
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

}
