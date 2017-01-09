package datatypes6;

import java.util.Scanner;

public class StringPractice {
	static Scanner input;
	static String user;
	static int lineCount;
	
	public static void main(String[] args) {
		createAScanner();
		lineCount = 0;
		//demonstrateStringMethod();
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
		boolean inLoop = true;
		while(inLoop){
//			promptInput();
			print("Greetings, " + user +" How are you?");
			String response = getInput();
			if(response.indexOf("good")>= 0){
				print("I'm so happy you are good!");
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
	private static void createAScanner() {
		input = new Scanner(System.in);
		
	}
	public static void demonstrateStringMethod(){
		String text1 = "Hello World";
		String text2 = "Hello ";
		String text3 = "World";
		
		if(text1.equals(text2+text3)){
			System.out.println("These strings are equal.");
		}
	}
}