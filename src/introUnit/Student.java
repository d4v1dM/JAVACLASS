package introUnit;

public class Student {
	private String name;
	//A constructor, because it is the same name as the class.
	public Student(String name){
		this.name = name;
	}
	public void talk(){
		System.out.println("Hi, my name is "+this.name);
	}
}
