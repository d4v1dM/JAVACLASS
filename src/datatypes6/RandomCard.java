package datatypes6;

public class RandomCard {

	public static void main(String[] args) {
		String[] numbers = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
		String[] suits = {"Diamond","Clubs","Hearts","Spades"};
		
//		for(int i = 0; i < 100; i++){
//			System.out.println(numbers[PickNumber(numbers.length)-1] + " of " + suits[PickSuit(suits.length)-1]);
//		}
		for(int i = 0; i < numbers.length;i++){
			for(int a = 0; a < suits.length; a++){
				System.out.println(numbers[i] + " of " + suits[a]);
			}
		}
	}
	public static int PickNumber(int par){
		double rand = Math.random();
		int result = (int)(rand*par);
		return result+1;
	}
		
	public static int PickSuit(int par){
			return PickNumber(par);
	}
}
