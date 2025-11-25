package Algorithm.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// leecode 17 电话号码的字母组合 TODO
public class leecode17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        // 数字到字母的映射
        Map<Character, String> digitToChar = new HashMap<>();
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");  // 修正：应该是 "pqrs" 不是 "qprs"
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");

        // 回溯函数
        if (!digits.isEmpty()) {
            backtrack(0, new StringBuilder(), digits, digitToChar, res);
        }

        return res;
    }

    private void backtrack(int i, StringBuilder curStr, String digits,
                           Map<Character, String> digitToChar, List<String> res) {
        // 如果当前字符串长度等于数字串长度，找到一个有效组合
        if (curStr.length() == digits.length()) {
            res.add(curStr.toString());
            return;
        }

        // 获取当前数字对应的字母
        String letters = digitToChar.get(digits.charAt(i));

        // 遍历所有可能的字母
        for (char c : letters.toCharArray()) {
            curStr.append(c);  // 选择当前字母
            backtrack(i + 1, curStr, digits, digitToChar, res);  // 递归
            curStr.deleteCharAt(curStr.length() - 1);  // 回溯，撤销选择
        }
    }
}
