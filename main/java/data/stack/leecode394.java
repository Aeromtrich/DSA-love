package com.data.stack;

import java.util.*;

public class leecode394 {
    // leecode 394 字符串解码
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c != ']') {
                stack.push(String.valueOf(c));
            } else {
                // 取出被 [] 包裹的字符串
                StringBuilder substr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    substr.insert(0, stack.pop());
                }
                stack.pop(); // 弹出 '['

                // 取出重复次数
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    k.insert(0, stack.pop());
                }

                int count = Integer.parseInt(k.toString());
                String repeated = substr.toString().repeat(count);
                stack.push(repeated);
            }
        }

        // 拼接所有内容
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }
        return result.toString();
    }


}
