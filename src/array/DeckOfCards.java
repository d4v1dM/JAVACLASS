package array;

public class DeckOfCards {
	static int[] check = {0,0,0,0,0,0,0,0,0,0,0};
	static int[] results = {0};
	public static void main(String[] args) {
//		int[] x = oneTofifty();
//		int[] y = randomInt();
//		int z = randomDice();
//		for(int i = 0; i < 10; i++){
//			System.out.println(randomDice());
//		}
		verifyRandomDice();
//		listCards();
	}
	
	public static int PickNumber(int par){
		double rand = Math.random();
		int result = (int)(rand*par);
		return result+1;
	}
	public static void verifyRandomDice(){
			for(int i = 0; i < 100; i++){
				int x = randomDice();
				check[x-2]+=1;
			}
		for(int w = 0; w < check.length; w++){
			double temp = check[w];
			System.out.println(temp);
		}
	}
	
	public static int PickSuit(int par){
			return PickNumber(par);
	}
	public static int[] oneTofifty(){
		int[] test1 = new int[50];
		for(int b = 0; b < test1.length; b++){
			test1[b] = (b+1);
		}
		return test1;
	}
	public static int[] randomInt(){
		int[] test2 = new int[10];{
			for(int c = 0; c < test2.length; c++){
				test2[c] = PickNumber(4);
			}
		}
		return test2;
	}
	public static int randomDice(){
		int val = 0;
		for(int i = 0; i < 2; i++){
			val += PickNumber(6);
		}
		return val;
	}
	public static void populateResultsArray(int[] array){
		for(int d = 0; d< check.length;d++){
			results[check[d]-2]++;
		}
	}
	public static void listCards(){
		String[] numbers = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
		String[] suits = {"Diamond","Clubs","Hearts","Spades"};
		
		for(int i = 0; i < numbers.length;i++){
			for(int a = 0; a < suits.length; a++){
				System.out.println(numbers[i] + " of " + suits[a]);
			}
		}
	}
}
