package chatBot;

import java.util.Scanner;

public class DanielMain {

	static Scanner input;
	static String user;
	static int lineCount;
	static boolean inLoop;
	//declare group classes
	static Topic school;
	static Topic like;
	static Topic hello;
	
	public static void main(String[] args) {
		createTopics();
		promptName();
		talkForever();
	}
	public static String getInput(){
		return input.nextLine();
	}
	private static void promptName() {
		print("Hello, human. I am a board covered with "
				+ "semiconductors and other such electronic components. "
				+ "What is your name?");
		user = input.nextLine();
		print("Awesome, I will call you "+user+" until you terminate me.");
	}
	public static void talkForever(){
		inLoop = true;
		while(inLoop){
//			promptInput();
			print("Greetings, " + user +" How are you?");
			String response = getInput();
			if(findKeyword(response,"good",0)>= 0){
				print("I'm so happy you are good!");
			}
			else if (like.isTriggered(response)){
				inLoop = false;
				school.talk();
			}
			else{
				print("I'm sorry, I don't understand you.");
			}
		}
	}
	public static void promptInput() {
		print(user +" ,try inputing a String!");
		String userInput = input.nextLine();
		print("You typed: " + userInput);
	}
	public static void print (String s){
//		lineCount++;
		
		String printString = "";
		int cutOff = 35;
		while(s.length() > 0){
			String currentLine = "";
			String nextWord = "";
			//while the currentLine and nextWord are less than the cutioff. Do the following loop. ass
			while(currentLine.length() +nextWord.length() <= cutOff && s.length() > 0){
				currentLine += nextWord;
				s = s.substring(nextWord.length());
				int endOfWord = s.indexOf(" ");
				if(endOfWord == -1){
					endOfWord = s.length()-1;
				}
				nextWord = s.substring(0, endOfWord+1);
			}
			printString += currentLine +"\n";
		}
		
		System.out.println(printString);
	}
	private static void createTopics() {
		input = new Scanner(System.in);
		//initialize group topics
		school = new School();
		like = new DanielLike();
		hello = new DanielHello();
	}
	public static int findKeyword(String searchString, String key, int startIndex){
		//deletes white spaces
		String phrase = searchString.trim();
		phrase = phrase.toLowerCase();
		key = key.toLowerCase();
//		System.out.println("The phrase is " +phrase);
		
//		System.out.println("The key is " + key);
		//find position of key
		int psn = phrase.indexOf(key);
//		System.out.println("The position found is " + psn);
		//keeps looking for the word
		while(psn >= 0){
			String before = " ";
			String after = " ";
			if(psn + key.length() < phrase.length()){
				after = phrase.substring(psn + key.length(), psn + key.length()+1).toLowerCase();
//				System.out.println("The character after " + key + " is "+after);
			}
			if(psn >0){
				before = phrase.substring(psn-1, psn).toLowerCase();
//				System.out.println("The character before " + key + " is "+before);
			}
			if(before.compareTo("a")< 0 && after.compareTo("a") < 0){
//				System.out.println(key+" was found at " + psn);
				if(noNegations(phrase,psn)){
					return psn;
				}
			}
			
			psn = phrase.indexOf(key,psn+1);
//			System.out.println(key+" was not found. " + "Checking " + psn);
		}
		return -1;
	}
	private static boolean noNegations(String phrase, int index) {
		if(index - 3 >= 0 && phrase.substring(index-3,index).equals("no ")){
			return false;
		}	
		else{
			if(index - 4 >= 0 && phrase.substring(index-4,index).equals("not ") || phrase.substring(index-4,index).equals("n't ")){
				return false;
			}
			else{
				if(index - 6 >= 0 && phrase.substring(index-6,index).equals("never ")){
					return false;
				}
				else{
					return true;
				}
			}
		}
	}
	public boolean isTriggered(String userInput) {
		String[] triggers = {"school","class","teacher"};
		//Can loop to find the particular keyword;
		if(DanielMain.findKeyword(userInput, "school", 0)>= 0){
			return true;
		}
		if(DanielMain.findKeyword(userInput, "class", 0)>= 0){
			return true;
		}
		return false;
	}
}

