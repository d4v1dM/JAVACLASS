package chatBot;

public class School implements Topic {
	private boolean inSchoolLoop;
	private String schoolResponse;
	
	public School(){
		
	}
	
	public void talk() {
		inSchoolLoop = true;
		while(inSchoolLoop){
			DanielMain.print("Tell me about school.");
			schoolResponse = DanielMain.getInput();
			if(schoolResponse.indexOf("stop")>= 0){
				inSchoolLoop = false;
				DanielMain.talkForever();
			}
			DanielMain.print("That's my favorite part about school too");
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
