package com.leetcode;

/**
 * һ��������������Ԫ��ֻ����һ�Σ������ľ��������Σ��ҳ�������Ԫ�ء�
 * @author yangfei
 *
 */
public class FindTwoOnceElements {
	public int[] getOnceEle(int[] A) {
		if(A.length < 2)
			return A;
	
		int[] result = new int[2];  //Ҫ���صĽ��
		int res = A[0];  //��һ�ζ�����Ԫ�ؽ������������
		for(int i=1; i<A.length; i++) {
			res ^= A[i];
		}
		int bitIndex = 0;
		for(int i=0; i<32; i++) {  //�ҳ������Ϊ1��λ��
			if((res>>i & 1) == 1) {
				bitIndex = i;
				break;
			}
		}
		for(int i=0; i<A.length; i++) { //����bitIndexΪ1����Ԫ�ط�Ϊ����
			if((A[i] >> bitIndex & 1) == 1)
				result[0] ^= A[i];   //��ӦλΪ1�����õ��Ľ��
			else
				result[1] ^= A[i];   //��ӦλΪ0�����õ��Ľ��
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] A = {1,2,1,3,2,4};
		FindTwoOnceElements fe = new FindTwoOnceElements();
		int[] result = fe.getOnceEle(A);
		System.out.println(result[0] + "\t" + result[1]);
	}
}
