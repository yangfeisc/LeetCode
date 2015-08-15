package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * ͨ������������¼��������ʣ�����������ߵ�ʣ�����0�������ֱ�ӽ�'('�����ַ�����
 * ���������ʣ��������0����������ѡ���Ƿ���롮)����������ʣ���������ұߣ����޷����������ƥ�䣬
 * ������ʣ����С���ұ�ʣ����������Լ���')'
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
