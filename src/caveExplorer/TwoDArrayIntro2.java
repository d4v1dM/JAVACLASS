package caveExplorer;

public class TwoDArrayIntro2 {
	public static void main(String[] args){
		boolean[][] mines = new boolean[6][6];
		createMines(mines,10);
		String[][] field = new String[mines.length][mines[0].length];
		matchValues(field,mines);
		printPic(field);
	}

	private static void printPic(String[][] field) {
		for(int i =0; i< field.length;i++){
			for(int j = 0; j<field[i].length;j++){
				System.out.print(field[i][j]);
			}
			System.out.println("");
		}
		
	}

	private static void matchValues(String[][] field, boolean[][] mines) {
		for(int row = 0; row < field.length; row++){
			for(int col = 0; col < field[0].length; col++){
				if(mines[row][col]){
					field[row][col] = "X";
				}
				else{
					field[row][col] = countAdjacent(mines, row, col);
				}
			}
		}
	}

	private static String countAdjacent(boolean[][] mines, 
			int r, int c) {
		//r and c represent coordinates of element 
		//we are providing a 
		//String for
		int count = 0;
		//loop through row above to row below
//		for(int row = r-1; row <= r+1; row++){
//			//loop through col left to col right
//			for(int col = c-1; col <= c+1; col++){
//				//exclude this element when counting
//				if(row !=r && col != c){ 
//					if(row >=0 && row < mines.length && col >= 0 && col < mines[row].length){
//						
//					}
//				}
//			}
//		}
//		for(int row = 0; row < mines.length; row++){
//			for(int col = 0; col < mines[row].length;col++){
//				if((Math.abs(row - r) + Math.abs(col - c ) == 1 && mines[row][col])){
//					count++;
//					
//				}
//			}
//		}
		count += validAndTrue(mines,r-1,c);
		count += validAndTrue(mines,r+1,c);
		count += validAndTrue(mines,r,c-1);
		count += validAndTrue(mines,r,c+1);
		
		
		return count + "";
	}

	private static int validAndTrue(boolean[][] mines, int i, int j) {
		//if mines[i][j] is put first, it will return error. make sure to check that it has valid index
		if(i >= 0 && i<mines.length && j>=0 && j < mines[i].length && mines[i][j]){
			return 1;
		}
		return 0;
	}

	private static void createMines(boolean[][] mines, int numberOfMines) {
		while(numberOfMines > 0){
			int row = (int)(Math.random() * mines.length);
			int col = (int)(Math.random() * mines[0].length);
			if(!mines[row][col]){
				mines[row][col] = true;
				numberOfMines--;
			}
		}
	}
	
}
