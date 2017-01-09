package gui;

public class TestReview {
	private static boolean[][] arr;
	public static void main(String[] args){
		arr = new boolean[5][5];
		printArr(arr);
		buttonClick(3,3);
		printArr(arr);
		buttonClick(3,3);
		printArr(arr);
		buttonClick(3,3);
	}
	public static void printArr(boolean[][] arr){
		for(int i = 0; i < arr.length;i++){
			for(int j = 0; j <arr[i].length;j++){
				if(arr[i][j]){
					System.out.print("O ");
				}
				else{
					System.out.print("X ");
				}
			}
			System.out.println("\n");
		}
		System.out.println("- - - - - - - - - - - - ");
	}
	public static void switchRow(boolean[] row, int x){
		if(x >= 0 && x < row.length){
			for(int i = -1; i<2; i++){
				if(x + i >= 0 && x+i <row.length){
					row[x+i] = !row[x+i];
				}
			}
		}
	}
	public static void switchColumn(boolean[][] arr, int r, int c){
		switchIfValid(arr, r-1, c);
		switchIfValid(arr, r+1, c);
	}
	public static void switchIfValid(boolean[][] arr, int r, int c){
		if(r >=0 && r < arr.length && c>=0 && c < arr[r].length){
			arr[r][c] = !arr[r][c];
		}
	}
	public static void buttonClick(int r, int c){
		if(r>=0&&r<arr.length){
			switchRow(arr[r],c);
		}
		switchColumn(arr,r,c);
		//Check if any lights are on
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr[i].length; j++){
				if(arr[i][j]){
					break;
				}
			}
		}
		System.out.println("You have solved the puzzle.");
	}
	public static void printGrid(boolean[][] grid){
		
	}
}
