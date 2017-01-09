package caveExplorer;

public class GameStartEvent implements Event {

	public static final String[] SEQ_1 = {"A spiky haired guy with orange pants flies up to you.","Have you arrived to save"
			+ "us from the treacherous Buu?","We need your help."};
	public static final String[] SEQ_2 = {"Great, I will be busy meditating on my super yellow version while you figure out"
			+ "where Buu","*insert generic action quote here*","By the way, here's a map"};
	public GameStartEvent() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void play() {
		readSequence(SEQ_1);
		CaveExplorer.print("Will you help us?");
		while(CaveExplorer.in.nextLine().indexOf("yes")<0){
			CaveExplorer.print("Please say yes.");
		}
		readSequence(SEQ_2);
		CaveExplorer.inventory.setHasMap(true);
	}

	private void readSequence(String[] seq) {
		for(int i = 0; i < seq.length;i++){
			CaveExplorer.print(seq[i]);
			CaveExplorer.print(" - - - Press enter - - -");
			CaveExplorer.in.nextLine();
		}
		
	}

}
