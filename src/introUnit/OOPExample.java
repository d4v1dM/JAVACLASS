/**
 * 
 */
package introUnit;

/**
 * @author Student 6
 *
 */
public class OOPExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Student jillian = new Senior("Jillian", "programmer");
		Student joseph = new Freshmen("Joseph", "DDP");
		Student jordan = new Junior("Jordan", "Regular SAT");
		Student craig = new Student("Craig");
		
//		Student[] students = {jillian, joseph};
		
		
		((Student)jillian).talk();
		joseph.talk();
		jordan.talk();
		craig.talk();

	}

}
