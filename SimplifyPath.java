package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * For example, path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * Did you consider the case where path = "/../"? In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, 
 * such as "/home//foo/". In this case, you should ignore redundant slashes and 
 * return "/home/foo".
 * @author yangfei
 *
 */
public class SimplifyPath {
	/**
	 * ·���򻯹�������'/.'�����ڵ�ǰ·����'/..'�˻ص���һ��
	 * @param path
	 * @return
	 */
	public String simplifyPath(String path) {
        if(path == null || path == " ")
        	return "";
        List<String> list = new ArrayList<>();
        String[] str = path.split("/+"); //��'/'��'//'Ϊ�ָ��������ַ����ָ�
        for(int i=0; i<str.length; i++) {
        	if(str[i].equals(".")) {  //���ڵ�ǰ·��
        		continue;
        	} else if(str[i].equals("..")) {  //�˻��ϼ�Ŀ¼
        		if(list.size() > 0)
        			list.remove(list.size()-1);
        	} else if(!str[i].isEmpty()){   //�����ӦĿ¼
        		list.add(str[i]);
        	}
        }
        if(list.size() == 0) 
        	return "/";
        StringBuilder result = new StringBuilder();
        for(String s : list) {
        	result.append("/" + s);
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		String path1 = "/home/";
		String path2 = "/a/./b/../../c/";
		String path3 = "/../";
		String path4 = "/home//foo/";
		String path5 = "/../abc/...";
		String path6 = "/...";
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath(path1));
		System.out.println(sp.simplifyPath(path2));
		System.out.println(sp.simplifyPath(path3));
		System.out.println(sp.simplifyPath(path4));
		System.out.println(sp.simplifyPath(path5));
		System.out.println(sp.simplifyPath(path6));
	}
}
