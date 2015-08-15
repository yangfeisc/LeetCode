package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, 
 * G, and T, for example: "ACGAATTCCG". When studying DNA, it is 
 * sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) 
 * that occur more than once in a DNA molecule.
 * For example, Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return: ["AAAAACCCCC", "CCCCCAAAAA"].
 * @author yangfei
 *
 */
public class RepeatedDNASequences {
	/**
	 * ��ʱ��
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences1(String s) {
        List<String> result = new ArrayList<String>();
        for(int i=0; i<s.length()-10; i++) {
        	String sub = s.substring(i, i+10);
        	if(result.contains(sub))  //�ж�����Ӵ��ǲ��ǳ�����result�����С�
        		continue;
        	if(s.substring(i+1).contains(sub))
        		result.add(sub);
        }
        return result;
    }
	
	/**
	 * ��ÿ���ַ�ʹ��ASCII����λ��ʾ��Ȼ��10���ַ��Ϳ������һ��30λ�����У������������Ϊ����ַ���key��
	 * Ȼ�����key����map���̶��ж�map���Ƿ������Ӧ��key��
	 * @param s
	 * @return
	 */
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		int key = 0;
		for(int i=0; i<s.length(); i++) {
			key = (key<<3 | (s.charAt(i) & 0x7)) & 0x3fffffff;
			if(i < 9)
				continue;
			if(!map.containsKey(key))
				map.put(key, 1);
			else if(map.get(key) == 1) { //ֻ�е���1��ʱ��żӣ�������Щ���л��ظ�����
				result.add(s.substring(i-9, i+1));
				map.put(key, 2);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String s = "GATGGATACTGCATTCGAACCAGAGCCGGCTTTTGCGGGACTAGCATGAGGGACTTGGCTGTTGAGGCTGTACGAGGTCAGTCCTCCGGCAGTGCTATCGCAGGAATTTTTGCAACTCCACTGCTTATAATCCACCAAGTCCAGACTCAAAGCTCAACTCGGGGATCGCACGGTATGGTCACTGTCGCGCATGCAGTAATAGTCCAGACGAACGCACATTGGTCGTCCCCTGAGCCCGTGCCAGCCTAATACTTCTTATGCCTGCGTAAGTAGACTTTGCCAACGTAATCTCATCCTTATGCCAGATTATTAGTTCATTGA";
		RepeatedDNASequences rds = new RepeatedDNASequences();
		List<String> list1 = rds.findRepeatedDnaSequences1(s);
		System.out.println(Arrays.toString(list1.toArray()));
		List<String> list = rds.findRepeatedDnaSequences(s);
		System.out.println(Arrays.toString(list.toArray()));
	}
}
