package com.leetcode;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 
 * return -1, otherwise return 0.
 * You may assume that the version strings are non-empty 
 * and contain only digits and the "." character. The "." 
 * character does not represent a decimal point and is 
 * used to separate number sequences. For instance, 2.5 
 * is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second 
 * first-level revision.
 * @author yangfei
 *
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		//根据"."实现对于字符串的分割
		String[] ver1 = version1.split("\\.");
        String[] ver2 = version2.split("\\.");
        int i = 0;
        int e1, e2;
        while((i<ver1.length) && (i<ver2.length)) {
        	e1 = Integer.parseInt(ver1[i]);
        	e2 = Integer.parseInt(ver2[i]);
        	if(e1 > e2) 
        		return 1;
        	else if(e1 < e2)
        		return -1;
        	i++;
        }
        //判断是否遍历结束
        for(; i<ver1.length; i++) {
        	e1 = Integer.parseInt(ver1[i]);
        	if(e1 > 0)
        		return 1;
        }
       	for(; i<ver2.length; i++) {
       		e2 = Integer.parseInt(ver2[i]);
       		if(e2 > 0)
       			return -1;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		String v1 = "1.00";
		String v2 = "1";
		CompareVersionNumbers cv = new CompareVersionNumbers();
		int result = cv.compareVersion(v1, v2);
		System.out.println(result);
	}
}
