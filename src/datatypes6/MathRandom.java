package datatypes6;

//import java.util.Random;

public class MathRandom {

//	public static void main(String[] args){
//		int totalRolls = 10000;
//		int[] results = new int[6];
//		for(int index = 0; index<totalRolls;index++){
//			int roll = rollUnfairDie();
//			System.out.println("Roll #"+(index+1)+" Die is "+ roll);
//			results[roll-1]++;
//		}
//		for(int i = 0; i < results.length; i++){
//			System.out.println((i+1) + " was rolled "+(double)100*results[i]/totalRolls+"% of the time.");
//		}
//
//	}
	public static int rollFairDie(){
//		Random gen = new Random();
//		return gen.nextInt(6)+1;
		double rand = Math.random();//double between (0,1)
		int roll = (int)(6*rand);
		return roll+1;
	}
	public static int rollUnfairDie(){
		int roll = rollFairDie();
		if (roll == 1){
			return rollFairDie();
		}
		else{
			return roll;
		}
		
	}
}
