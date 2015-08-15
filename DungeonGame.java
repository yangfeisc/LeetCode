package com.leetcode;

import java.util.Arrays;

public class DungeonGame {
	public int calculateMinimumHP(int[][] dungeon) {
		if(dungeon.length == 0)
			return 0;
		int row = dungeon.length;
		int col = dungeon[0].length;
		for(int i=row-1; i>=0; i--) {
			for(int j=col-1; j>=0; j--) {
				if(i==row-1 && j==col-1)
					dungeon[i][j] = dungeon[i][j]<0 ? -dungeon[i][j] : 0;
				else if(i==row-1 && j<col-1) 
					dungeon[i][j] = dungeon[i][j]-dungeon[i][j+1]>=0 ? 0 : dungeon[i][j+1]-dungeon[i][j];
				else if(i<row-1 && j==col-1)
					dungeon[i][j] = dungeon[i][j]-dungeon[i+1][j]>=0 ? 0 : dungeon[i+1][j]-dungeon[i][j];
				else {
					int right = dungeon[i][j]-dungeon[i][j+1]>=0 ? 0 : dungeon[i][j+1]-dungeon[i][j];
					int down = dungeon[i][j]-dungeon[i+1][j]>=0 ? 0 : dungeon[i+1][j]-dungeon[i][j];
					dungeon[i][j] = Math.min(right, down);
				}
			}
		}
		for(int i=0; i<dungeon.length; i++) {
			System.out.println(Arrays.toString(dungeon[i]));
		}
		return dungeon[0][0] + 1;
    }
		
	public static void main(String[] args) {
		int[][] dungeon = {{0}};
		DungeonGame dg = new DungeonGame();
		System.out.println(dg.calculateMinimumHP(dungeon));
	}
}
