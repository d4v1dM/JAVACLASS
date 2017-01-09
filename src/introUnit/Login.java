package introUnit;

import java.util.Scanner;	

public class Login {

	static Scanner input = new Scanner(System.in);
	
	public static String waitForEntry(){
		return input.nextLine();
	}
	
	private static String username = "test_user";
	private static String password = "test";
	
	public static void main(String[] args) {
		System.out.println("Please input your username");
		if(correctUser()){
			askPassword();
		}else{
			System.out.println("Unknown Username, please contact network admin.");
		}
	}

	private static boolean correctUser() {
		if(waitForEntry().equals(username)){
			return true;
		}
		return false;
	}
	private static boolean correctPass() {
		if(waitForEntry().equals(password)){
			return true;
		}
		return false;
	}

	private static void askPassword() {
		System.out.println("Please input the password. You have 3 tries.");
		for(int i = 1; i < 4; i++){
			if(correctPass()){
				i = 5;
				System.out.println("Correct Password. Welcome.");
			}else{
				if(i == 3){
					System.out.print("You failed");
				}else{
					System.out.print("Unknown password. You have "+(3-i)+" attempts left.");
				}
			}
		}
	}
	

}
