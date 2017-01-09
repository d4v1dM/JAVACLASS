package caveExplorer;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArrayIntro {

	public static String[][] arr2D;
	public static String[][] pic;
	public static String[][] connect4;
	public static boolean[][] test;
	public static int i;
	public static int j;
	public static Scanner in;
	public static void main(String[] args) {
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
	private static void printCellC4(int i, int o) {
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
	private static void startExploring(){
		while(true){
			printPic(pic);
			System.out.println("You are in room "+  arr2D[i][j]);
			System.out.println("What do you want to do?");
			String input = in.nextLine();
			while(!isValid(input)){
				System.out.println("Please type w, a, s or d.");
				input = in.nextLine();
			}
			interpretInput(input);
		}
	}
	private static void interpretInput(String input) {
		int iOrig = i;
		int jOrig = j;
		if(input.equals("w") && i>0)i--;
		else if(input.equals("a") && j>0)j--;
		else if(input.equals("s") && i+1<arr2D.length)i++;
		else if(input.equals("d") && j+1<arr2D[i].length)j++;
		if(iOrig == i && jOrig == j){
			System.out.println("You are at the edge");
		}
	}
	private static boolean isValid(String input) {
		String lc = input.toLowerCase();
		String[] keys = {"w","a","s","d"};
		for(String key:keys){
			if(key.equals(lc)){
				return true;
			}
		}
		return false;
	}
	public static int rand(int low, int high){
			return (int) (Math.random()*high)+low;
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
						printCellC4(0,0);
					}
					else{
						printCellC4(0,1);
					}
				}
				else{
					if(test[row][col]){
						printCellC4(1,0);
					}
					else{
						printCellC4(1,1);
					}
				}
			}
			System.out.println("");
		}
	}
	private static void store(){
//		for(String[] row: arr2D){
//			for(String s: row){
//				System.out.println(s);
//			}
//		}
		
		//[(0,0),(0,1),(0,2)]
		//[(1,0),(1,1),(1,2)]
		//[(2,0),(2,1),(2,2)]
		//[(3,0),(3,1),(3,2)]
		//rows = 4, columns = 3
		//rows = arr2D.length column = arr2D[0].length
//		String[][] pic = new String[10][12];
//		for(int row = 0; row < pic.length; row++){
//			for(int col = 0; col < pic[row].length;col++){
//				pic[row][col] = ".";
//				
//			}
//		}
//		for(int row = 7; row < pic.length; row++){
//			for(int col = 0; col < pic[row].length;col++){
//				pic[row][col] = "M";
//				
//			}
//		}
//		pic[1][2] = "O";
//		pic[0][2] = "|";
//		pic[2][2] = "|";
//		pic[1][1] = "-";
//		pic[1][3] = "-";
//		pic[0][1] = "\\";
//		pic[2][3] = "\\";
//		pic[0][3] = "/";
//		pic[2][1] = "/";
//		
//		for(int i = 0; i < 4; i++){
//			for(int j = 5; j < 11;j++){
//				if(rand(0,5)== 4){
//					pic[i][j] = "v";
//				}
//			}
//		}
//		
//		
//		System.out.println(rand(0,3));
//		//top row is "_
//		for(int col = 1; col < pic[0].length; col++){
//			pic[0][col] = "_";
//			pic[pic.length-1][col] = "_";
//		}
//		for(int row = 1; row < pic.length; row++){
//			pic[row][0] = "|";
//			pic[row][pic[0].length-1] = "|";
//		}
//		printPic(pic);
		
//		int[] arr = {0,1,2,3,4,5,6,7};
//		//rows, columns
//		arr2D = new String[5][4];
//		pic = new String[5][4];
//		for(int i = 0; i < arr2D.length; i++){
//			for(int j = 0; j < arr2D[i].length;j++){
//				arr2D[i][j] = "(" + i + "," + j + ")";
//			}
//		}
//		
//		i = 2;
//		j = 3;
//		
//		startExploring();
	}
}
