package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 通过两个变量记录左右括号剩余量，如果左边的剩余大于0，则可以直接将'('加入字符串，
 * 如果右括号剩余量大于0，则根据情况选择是否加入‘)’，如果左边剩余量大于右边，则无法产生合理的匹配，
 * 如果左边剩余量小于右边剩余量，则可以加入')'
 * @author yangfei
 *
 */
public class GenerateParentheses {
	private List<String> result = new ArrayList<String>();
	
	public List<String> generateParenthesis(int n) {
		generateOneParent(n, n, "");
        return result;
    }
	
	public void generateOneParent(int left, int right, String s) {
		if(left == 0 && right == 0) {
			result.add(s);
			return;
		}
		
		if(left > 0)
			generateOneParent(left-1, right, s + '(');
		if(right > 0 && right > left) {
			generateOneParent(left, right-1, s + ')');
		}
	}
	
	public static void main(String[] args) {
		int n = 2;
		GenerateParentheses gp = new GenerateParentheses();
		List<String> list = gp.generateParenthesis(n);
		for(String str : list) {
			System.out.println(str);
		}
	}
}
