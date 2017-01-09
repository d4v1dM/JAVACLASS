package array;

public class ArrayMethods {

		public static void main(String[] args) {
			int[] test1 = {2,3,4,5,6,};
			testPrimes(50);
			
			
		     /**
		      * IMPORTANT NOTE: 
		      * This homework assignment will be weighted 4x.
		      * DO NOT ASSUME my tests are perfect! If you have code that you think should work, 
		      * but you keep failing the tests PLEASE bring it to my attention so that I can fix the tests
		      * DO NOT spend hours and hours trying to fix perfect code just because my test
		      * says that it isn't perfect!
		      * */
	    }
	    public static void testPrimes(int numberToTest){
	    	//Print out all prime #
	    	int lastToCheck = (int) Math.sqrt((numberToTest));
	    	boolean[] theNumbers = new boolean[numberToTest];
	    	
	    	for(int i = 0; i < numberToTest;i++){
	    		theNumbers[i] = true;
	    	}
	    	theNumbers[0] = false;
	    	theNumbers[1] = false;
	    	
	    	for(int prime = 2; prime <= lastToCheck;prime++){
	    		int increment = prime;
		    	if(theNumbers[prime]){
			    	for(int test = prime+prime; test < numberToTest; test = test + increment){
			    		theNumbers[test] = false;
			    		System.out.println(prime +" is prime. Crossing off: " + test);
			    	}
		    	}
	    	}
	    	for(int i = 0; i < theNumbers.length; i++){
	    		if(theNumbers[i]){
	    			System.out.println(i + " is prime.");
	    		}
	    	}
	    }
	    public static void print(boolean[] array){
	    	for(int i = 0; i < array.length; i++){
	    		System.out.println(array[i]);
	    	}
	    }
	    public static int searchUnsorted(int[] arrayToSearch, int key){
	    /**
	     * this method take an unsorted int array (arrayToSearch) and returns an 
	     * int corresponding to the index of a key, if it is in the array
	     * if the key is not in the array, this method returns -1
	     * */
	    	for(int i = 0; i < arrayToSearch.length; i++){
	    		if(arrayToSearch[i] == key){
	    			return i;
	    		}
	    	}
	    	
	     return -1;
	    }
	    public static int[] getSubArray(int[] arr, int startIndex, int endIndex){
	    	int[] test = new int[(endIndex-startIndex)+1];
	    		for(int i = startIndex; i < (endIndex-startIndex)+1;i++){
	    			test[i] = arr[i];
	    	 	}
	       	return test;
	    }
	    public static int searchSorted(int[] sortedArrayToSearch, int key){
	    /**
	     * this method is exactly like the one above, except the parameter sortedArrayToSearch will
	     * always be sorted in DESCENDING order. Again return the index of the key or return -1
	     * if the key is not in the array
	     * 
	     * Note: You should attempt to write a method that is more efficient that searchUnsorted
	     * */
	    	//Cannot get last #
	    	int low = sortedArrayToSearch.length-1;
	    	int high = 0;
	    	
	    	while(high <= low){
	    		int med = ((low + high)/2);
	    		if(sortedArrayToSearch[med] == key){
	    			return med;
	    		}
	    		else{
		    		if(sortedArrayToSearch[med] < key){
		    			low = med - 1;
		    		}
		    		if(sortedArrayToSearch[med] > key){
		    			high = med + 1;
		    		}
	    		}
	    	}
	    		
	    	return -1;
	    }
	    
	    public static boolean isSorted(int[] array){
	        /**
	         * This method takes an in array as a parameter and returns 'true' if the array is already sorted in DESCENDING order
	         * */
	    	for(int i = 0; i < array.length; i++){
	    		if(i == array.length-1){
	    			return true;
	    		}
	    		if(array[i]<array[i+1]){
	    			return false;
	    		}
	    	}
	        return false;
	    }
	    public static int[] swap(int[] array, int first, int second){
	    	int[] test = array;
	    	int save = test[first];
	    	test[first] = test[second];
	    	test[second] = save;
	    	return test;
	    }
	    public static double[] swap1(double[] array, int first, int second){
	    	double[] test = array;
	    	double save = test[first];
	    	test[first] = test[second];
	    	test[second] = save;
	    	return test;
	    }
	    public static double[] selectionSort(double[] array){	    	
	    	for (int i = 0; i < array.length - 1; i++){
	    	    int tempLowIndex = i;
	    	    for (int j = i + 1; j < array.length; j++){
	    	        if (array[j] < array[tempLowIndex]){
	    	            tempLowIndex = j;
	    	        }
	    	    }
	    	   if(tempLowIndex!=i){
	    	         swap1(array, tempLowIndex, i);
	    	   } 
	    	}
	    	return array;
	    }
	    public static boolean contains(int[] arr, int[] subArray){
	    	boolean b1 = true;
	    	for(int i = 0; i < arr.length; i++){
	    		if(arr[i] == subArray[0]){
//	    			int j=0;
//	    			while(j < arr.length){
//	    				if(arr[j] == subArray[j]){
//	    					
//	    				}
//	    			}
	    			for(int j = 0; j < subArray.length; j ++){
	    				if(arr[i+j] != subArray[j]){
	    					b1 = false;
	    				}
	    			}
	    		}
	    		if(b1 == true){
	    			return true;
	    		}
	    	}
	    	return false;
	    }
	    
	    public static double[] getStats(double[] array){
	        /** 
	         * This method return a double[] contain a WHOLE BUNCH of stats
	         * The double array must keep the following stats about the array parameter:
	         * index 0 = the mean
	         * index 1 = the max
	         * index 2 = the min
	         * index 3 = the median
	         * index 4 = the number of values greater than or equal to the mean
	         * index 5 = the number of values below the mean
	         * */
	    	//{4.33,4.22,4.11,4.55,3.99}
	    	 
	    	 double[] sortedList = selectionSort(array);
	         double[] stats = new double[6];
	         double sum = 0;
	         for(int i = 0; i< array.length;i++){
	        	sum += array[i];
	         }
	        
	         stats[0] = sum/array.length;
	         
	         stats[1] = sortedList[sortedList.length-1];
	       
	         stats[2] = sortedList[0];
	         
	         if(sortedList.length % 2 == 0){
	        	 double st = sortedList[(sortedList.length/2)-1];
	        	 double nd = sortedList[(sortedList.length/2)];
	        	 double x = (st+nd)/2;		        
	        	 stats[3] = x;
	        	 
	         }
	         else{
	        	 stats[3] = sortedList[(int)(sortedList.length/2)]; 
	         }
	        
	         int greater = 0;
	         for(int i = 0; i < array.length; i++){
	        	 if(sum/array.length <= array[i]){
	        		 greater+=1;
	        	 }
	         }
	         stats[4] = greater;
	         
	         int lesser = 0;
	         for(int i = 0; i < array.length; i++){
	        	 if(sum/array.length > array[i]){
	        		 lesser+=1;
	        	 }
	         }
	         stats[5] = lesser;
	         
	         
	         return stats;
	    }
	    public static int countUnderBound(double[] arr, int d){
	    	int ctr= 0;
	    	for(int i = 0; i < arr.length;i++){
	    		if(arr[i] < d){
	    			ctr++;
	    		}
	    	}
	    	return ctr;
	    }
	    public static void reverseOrder(int[] array){
	        /**
	         * this method reverses the order of the array passed to it.
	         * Not that this method does not have a return type. You do not need to copy the array first
	         * Furthermore, note that the array is not necessarily in any *particular* order. It may be 
	         * in a random order, though you still need to reverse whatever order it is in
	         * 
	         * Example:
	         * array = {5, 1, 9, 10, 16, -6}
	         * after calling this method
	         * array = {-6, 16, 10, 9, 1, 5}
	         * 
	         * */
	    	int var = array.length-1;
	    	for(int i = 0; i < (array.length/2); i++){
	    		array = swap(array,i,i+var);
	    		var-=2;
	    	}
	    }
	    
	    public static int countDifferences(int[] array1, int[] array2){
	        /**Here, you will write an method that returns the number of values in two arrays 
	         * that are NOT the same (either in value OR location).
	         * The arrays ALWAYS have the same length
	         * Examples:
	         * countDifferences({1,2,3},{1,2,3}) returns 0, since these arrays are exactly the same
	         * countDifferences({3,2,3,4},{3,2,5,4}) returns 1, since '3','2', and '4' are same value, same location, but the 3 and 5 are different
	         * countDifferences({4,4,4,4},{1,2,3,4}) returns 3, since '4' is only at the same index ONE time and three others are not
	         * countDifferences({1,2,3},{1,3,2}) returns 2, since '2' and '3' are both present, but different locations
	         * 
	         * */
	    	int errors = 0;
	    	for(int i = 0; i < array1.length; i++){
	    		if(array1[i] != array2[i]){
	    			errors++;
	    		}
	    	}
	         return errors;
	    }
	    

	    public static int longestConsecutiveSequence(int[] array1){
	        /**This method counts the longest consequtive sequence in an array.
	         * It does not matter where the sequence begins
	         * If there are no consecutive numbers, the method should return '1'
	         * 
	         * Examples:
	         * longestSequence({1,2,3,4,5,8,9}) returns '5', since the sequence '1,2,3,4,5' is 5 integers long 
	         * longestSequence({0,9,10,11,4,3,8,9}) returns '3', since '9,10,11' is 3 integers long
	         * longestSequence({0,9,8,11,4,3,7,9}) returns '1', since there are no consecutive integers
	         * */
	    	int longest = 1;
	    	int pos = 1;
	        for(int i = 0; i < array1.length-1; i++){
	        	if(array1[i]+1 == array1[i+1]){	
	        		pos++;	        		
	        	}
	        	else{
	        		pos = 1;
	        	}
	        	if(pos >= longest){	
	        		longest = pos;	
	        	}
	        }
	        return longest;
	    }

	    public static int longestSharedSequence(int[] array1, int[] array2){
	        /**This method counts the longest unbroken, shared sequence in TWO arrays.
	         * The sequence does NOT have to be a consecutive sequence
	         * It does NOT matter where the sequence begins, the arrays might not be the same length
	         * 
	         * Examples:
	         * longestSequence({9,6,3,4,3,8,9}, {9,6,3,4,3,6,7}) returns '5', since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long 
	         * longestSequence({0,9,6,3,4,3,8,9}, {1,2,9,6,3,4,3,6,7}) returns '5', 
	         *          since the sequence '9,6,3,4,3' is in both arrays and is 5 integers long, it doesn't matter that the sequence begins at different indices 
	         * longestSequence({9,6,1,4,3,6,7,9}, {9,6,5,8,3,6,7,0}) returns '3', since the sequence '3,6,7' is in both arrays and is 3 integers long
	         **/
	    	//{0,9,6,3,4,3,8,9}
	    	//{1,2,9,6,3,4,3,6,9}
	    	//0,1,2,3
	    	
	        int ctr = 0;
	        int longest = 0;
	        for(int i = 0; i < array1.length; i++){
	        	for(int j = 0; j < array2.length; j++){
	        		if((i + ctr) < array1.length){
	        			if(array1[i+ctr] == array2[j]){
		        			ctr++;
		        		}
		        		else{
		        			ctr = 0;
		        		}
		        		if(ctr > longest){
			        		longest = ctr;
			        	}
		        	}
	        	}	
	        }
	        return longest;
	    }

	    public static int[] generateDistinctItemsList(int n){
	        /**
	         * This method needs to generate an int[] of length n that contains distinct, random integers
	         * between 1 and 2n 
	         * The method will be tested by verifying that the array you return is n items long,
	         * contains only entries between 1 and 2n (inclusive) and has no duplicates
	         * 
	         * */
	    	int max = 2*n;
	    	int[] array = new int[n];
	    	int[] filler = new int[max];
	    	for(int i = 1; i < max+1; i++){
	    		filler[i-1] = i;
	    	}
	    	for(int i = 0; i < array.length; i++){
	    		int idx = generateNumber(0,filler.length);
	    		array[i] = filler[idx];
	    		filler[idx]=0;
	    		filler = removeZeroes(filler);
	    	}
	        return array; 
	    }
	    
	    public static int[] removeZeroes(int[] array){
	    	int[] test = new int[array.length - 1];
	    	int idx = 0;
	    	for(int i = 0; i < array.length; i++){
	    		if(array[i] != 0){
	    			test[idx] = array[i];
	    			idx++;
	    		}
	    	}
	    	
	    	return test;
	    }
	    public static int generateNumber(int min, int max){
			double rand = Math.random();
			int result = (int)(rand*max)+min;
			return result;
		}
	    
	    public static void cycleThrough(int[] array, int n){
	        /** This problem represents people moving through a line.
	         * Once they get to the front of the line, they get what they've been waiting for, then they 
	         * immediately go to the end of the line and "cycle through" again.
	         * 
	         * This method reorders the array so that it represents what the array would look like
	         * after it had been cycled through an n number of times.
	         * For example, cycleThrough({2,1,5,6}}, 1) after executing, array == {1,5,6,2} 
	         * because '2' (the person at the front of the line) cycled through and is now at the end of the line
	         * 
	         * cycleThrough({3,7,4,2,8,6,2,9}}, 2) after executing, array == {4,2,8,6,2,9,3,7} 
	         * because '3' and '7' (the TWO people at the front of the line) cycled through and are now at the end of the line
	         * 
	         * Likewise,
	         * cycleThrough({3,7,4,2,8,6,2,9}}, 0) after executing, array == {3,7,4,2,8,6,2,9}  (no movement)
	         * and the most interesting case, 
	         * cycleThrough({3,7,4,2,8,6,2,9}}, 49) after executing, array == {7,4,2,8,6,2,9,3}  
	         * Because after cycling through 49 times, everyone had a chance to go through 6 times, but '3'
	         * was able to go through one more time than anyone else
	         * 
	         * CHALLENGE
	         * For extra credit, make your method handle NEGATIVE n
	         * */
	    	//- 0,1,2,3,4,5
	    	//5,1,2,3,4,0
	    	//4,1,2,3,5,0
	    	//3,1,2,4,5,0
	    	//2,1,3,4,5,0
	    	//- 1,2,3,4,5,0
	    	if(n < 0){
	    		n = n*-1;
	    		for(int i = 0; i < n; i++){
		    		cycleBackOne(array);
		    	}
	    	}
		    else{
		    	for(int i = 0; i < n; i++){
		    		cycleOne(array);
		    	}
	    	}
	    }
	    public static void cycleOne(int[] array){
	    	for(int i = 0; i < array.length-1;i++){
	    		int save = array[i+1];
	    		array[i+1] = array[i];
	    		array[i] = save;
	    	}
	    	
	    }
	    
	    public static int[] cycleBackOne(int [] array){
	    	// - 0,1,2,3,4,5 swap 0 5
	    	// 5,1,2,3,4,0 swap 1 5
	    	// 5,0,2,3,4,1 swap 2 5
	    	// 5,0,1,3,4,2 swap 3 5
	    	// 5,0,1,2,4,3 swap 4 5
	    	// 5,0,1,2,3,4 
	    	// - 5,0,1,2,3,4 
	    	// swap (0,
	    	for(int i = 0; i < array.length-1; i++){
	    		swap(array,i,array.length-1);
	    	}
	    	return array;
	    
	    }

	    public static void popArr(int[] arr){
	    	int[]randArr = new int[arr.length-1];
	    	for(int i = 0; i < randArr.length; i++){
	    		int toAdd = arr[generateNumber(0, arr.length)];
	    		while(indexOf(randArr,toAdd)> -1){
	    			toAdd = arr[1];
	    		}
	    		randArr[i]=toAdd;
	    	}
	    }

		private static int indexOf(int[] randArr, int toAdd) {
			// TODO Auto-generated method stub
			return 0;
		}
}