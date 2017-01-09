package caveExplorer;

import java.util.Scanner;

public class Connect4 {
	
	public static String[][] connect4;
	public static boolean[][] test;
	public static Scanner in;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		connect4 = new String[8][8];
		test = new boolean[8][8];

		printPic(connect4);
		placePiece();
	}
	public static void placePiece(){
		while(true){
			String input = in.nextLine();
			int result = Integer.parseInt(input);
			if(result > test.length-1 || result < 0){
				System.out.println("Please put a number between 0 and 7.");
			}
			else{
				for(int i = test.length-1; i >= 0; i--){
					if(test[i][result] == false){
						test[i][result] = true;
						i = -1;
					}
				}
				printPic(connect4);
			}
		}
	}
	private static void printTop(int i){
		for(int j = 0; j < i; j++){
			System.out.print(" __");
		}
	}
	public static void printPic(String[][] pic){
		for(int row = 0; row < pic.length; row++){
			if(row == 0){
				printTop(pic[0].length);
				System.out.println("");
			}
			for(int col = 0; col < pic[row].length;col++){
				if(col == 0){
					if(test[row][col]){
						printCell(0,0);
					}
					else{
						printCell(0,1);
					}
				}
				else{
					if(test[row][col]){
						printCell(1,0);
					}
					else{
						printCell(1,1);
					}
				}
			}
			System.out.println("");
		}
	}
	private static void printCell(int i, int o) {
		if(i == 0){
			System.out.print("|");
			if(o == 0){
				System.out.print(" X");
			}
			else{
				System.out.print("__");
			}
			System.out.print("|");
		}
		else{
			if(o == 0){
				System.out.print(" X");
			}
			else{
				System.out.print("__");
			}
			System.out.print("|");
		}
	}
}
