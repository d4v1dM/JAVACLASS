package introUnit;

public class Junior extends Student{

	private String sat;
	
	public Junior(String name, String sat) {
		super(name);
		this.sat = sat;
	}
	public void talk(){
		super.talk();
		System.out.println("I am a Junior and I have taken the " + this.sat + ".");
	}
}
