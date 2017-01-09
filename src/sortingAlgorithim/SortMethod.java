package sortingAlgorithim;

public class SortMethod {

	public static void main(String[] args) {
		double[] test = {3.33, 5.67, 6.23, 5.14};
		long start = System.nanoTime();
//		System.out.println(getAverage(test));
//		3-4 Milliseconds
		
//		System.out.println(isPrime(3));
//		0-1 Milliseconds, 978 nanoseconds
		
//		System.out.println(isPrime2(3));
//		Around .33 milliseconds
		
//		System.out.println(isPrime3(3));
//		Around .31 milliseconds
		long end = System.nanoTime();
		System.out.println(end - start + " nanoseconds");
	}


	public static double getAverage(double[] values){
	     double sum=0.0;
	     for(int i = 0; i<values.length; i++){
	    	 sum+=values[i];
	     }
	    return sum/values.length;
	}
	public static boolean isPrime(int n){
		boolean prime = true;
	    for(int i = 2; i<n; i++){
	    	if(n%i==0) prime = false;   
		}
	    return prime;
	}
	public static boolean isPrime2(int n){
		boolean prime = true;
		for(int i = 2; i<Math.sqrt(n); i++){
			if(n%i==0) prime = false;   
	    }
	    return prime;
	 }
	public static boolean isPrime3(int n){
		boolean prime = true;
		double sqrt = Math.sqrt(n);
		for(int i = 2; i<sqrt; i++){
			if(n%i==0) prime = false;   
		}
     return prime;
	}
}