package introUnit;

public class Freshmen extends Student {

	private String sclass;
	
	public Freshmen(String name, String sclass) {
		super(name);
		this.sclass = sclass;
	}
	public void talk(){
		super.talk();
		System.out.println("I am a freshmen");
		System.out.println("... and I have " + this.sclass +".");
	}
}
