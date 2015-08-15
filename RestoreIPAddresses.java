package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string containing only digits, 
 * restore it by returning all possible valid IP address combinations.
 * For example: Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * @author yangfei
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
    	List<String> result = new ArrayList<String>();
    	if(s.length() < 4 || s.length() > 12)
    		return result;
    	String temp1, temp2, temp3;
    	int t = 0;
    	for(int i=1; i<=3 && i<=s.length()-3; i++) {
    		temp1 = "";
    		if(i>1 && s.charAt(0)=='0')
    			continue;
    		if(Integer.parseInt(s.substring(0, i)) > 255)
    			break;
    		temp1 = s.substring(0, i) + ".";
    		for(int j=i+1; j<=i+4 && j<=s.length()-2; j++) {
    			temp2 = temp1;
    			t = Integer.parseInt(s.substring(i, j));
    			if(t>255 || (j>i+1 && s.charAt(i)=='0'))
    				break;
    			temp2 += s.substring(i, j) + ".";
    			for(int m=j+1; m<=j+4 && m<=s.length()-1; m++) {
    				temp3 = temp2;
    				t = Integer.parseInt(s.substring(j, m));
    				if((t>255) || (m>j+1 && s.charAt(j)=='0'))
    					break;
    				temp3 += s.substring(j, m) + ".";
    				t = Integer.parseInt(s.substring(m));
    				if(t>255 || m<s.length()-1 && s.charAt(m)=='0')
    					continue;
    				result.add(temp3 + s.substring(m));
    			}
    		}
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		String s = "172162541";
		RestoreIPAddresses ri = new RestoreIPAddresses();
		List<String> result = ri.restoreIpAddresses(s);
		System.out.println(Arrays.toString(result.toArray()));
	}
}
