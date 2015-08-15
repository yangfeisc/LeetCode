package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line has 
 * exactly L characters and is fully (left and right) justified. You should pack your 
 * words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. If the number 
 * of spaces on a line do not divide evenly between words, the empty slots on the left 
 * will be assigned more spaces than the slots on the right. For the last line of text, 
 * it should be left justified and no extra space is inserted between words.
 * For example, words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * ["This    is    an",
 *  "example  of text",   
 *  "justification.  "
 * ]
 * @author yangfei
 *
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length) {
                if (words[last].length() + count + 1 > L) 
                	break;
                count += words[last].length() + 1;  //+1�ǵ��ʼ�ո�
                last++;
            }

            StringBuilder builder = new StringBuilder();
            int diff = last - index - 1;
            //��һ��˵�����е��ʳ���С��L���ڶ���˵��������ֻ��һ������
            if (last == words.length || diff == 0) {
                for (int i = index; i < last; i++) {
                    builder.append(words[i] + " ");
                }
                builder.deleteCharAt(builder.length() - 1);  //ɾ�����һ���ո�
                for (int i = builder.length(); i < L; i++) {
                    builder.append(" ");
                }
            } else {
                int spaces = (L - count) / diff;  //ƽ���ո���
                int r = (L - count) % diff;   //ƽ����ʣ��ո���
                for (int i = index; i < last; i++) {
                    builder.append(words[i]);
                    if (i < last - 1) {  //�������һ�����ʼ��˺��ּ��Ͽո�
                        for (int j = 0; j <= (spaces + ((i - index) < r ? 1 : 0)); j++) {
                            builder.append(" ");
                        }
                    }
                }
            }
            result.add(builder.toString());
            index = last;
        }
        return result;
    }
	
	public static void main(String[] args) {
		String[] str = {"Listen","to","many,","speak","to","a","few."};
//		String[] str = {"This", "is", "an", "example", "of", "text", "justification."};
		TextJustification tf = new TextJustification();
		List<String> result = tf.fullJustify(str, 10);
//		System.out.println("result: ");
		for(String s : result)
			System.out.println(s);
	}
}
