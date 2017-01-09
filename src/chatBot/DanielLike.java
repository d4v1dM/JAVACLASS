package chatBot;

public class DanielLike extends DanielMain implements Topic{
	private boolean inLikeLoop;
	private String likeResponse;
	public void talk() {
		// TODO Auto-generated method stub
		DanielMain.print("What are some things you like?");
		inLikeLoop = true;
		while(inLikeLoop){
			likeResponse = DanielMain.getInput();
			
			int likePsn = DanielMain.findKeyword(likeResponse, "like", 0);
			if(likePsn >= 0){
				String thingsLiked = likeResponse.substring(likePsn+5);
				DanielMain.print("You are such an interesting person because you like "+ thingsLiked);
				inLikeLoop = false;
				DanielMain.talkForever();
				if(DanielMain.findKeyword(thingsLiked, "school", 0)>= 0){
					DanielMain.school.talk();
				}
			}
			else{
				DanielMain.print("I don't understand.");
			}
		}
	}
}
