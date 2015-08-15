package com.leetcode;

/**
 * ԭ��ÿ��ȡ�������λ�����λ���бȽϣ������ͬ�ͼ����Ƚϣ�����ͬ�Ͳ��ǻ����֡�
 * ���ȣ��ж�x�ж���λ����ѭ�������Ҫѭ�����ٴβ��ܵõ����λ
 * ��Σ����ϻ�ȡx�����λ�����λ���ж������Ƿ���ͬ����ͬ����ѭ������ͬ�򷵻�false
 * ���ͨ������10�ࡱ�õ������λ��ʣ�����֣��Եõ������ֳ���10���õ������λ������
 * @author yangfei
 *
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if(x < 0)
        	return false;
        if(x == 0)
        	return true;
        
        int index = 1; 
        while(x/index >= 10) {
        	index *= 10;
        }
        
        while(x > 0) {
        	if(x/index != x%10)
        		return false;
        	x %= index;      //��ȥ���ֵ����λ    
        	index /= 100;    //ÿ�μ�ȥ��λ��
        	x /= 10;         //��ȥ���ֵ����λ 
        }
        return true;
    }
	
	public static void main(String[] args) {
		int x = 1221;
		PalindromeNumber pn = new PalindromeNumber();
		System.out.println(pn.isPalindrome(x));
	}
}
