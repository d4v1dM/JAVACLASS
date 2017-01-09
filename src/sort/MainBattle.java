package sort;

public class MainBattle {
	public static void main(String[] args) {
	Pokemon raticate = new Pokemon("Raticate",26);
	Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
	raticate.iChooseYou();
	bulbasaur.iChooseYou();
	System.out.println("Raticate is preparing to attack with super fang.");
	raticate.attack(bulbasaur, new Attack() {
		public void attack(Pokemon target) {
			System.out.println("Super fang is used!");
			int newHP = target.getHP()/2;
			target.setHP(newHP);
		}
	});
 
	bulbasaur.attack(raticate, new Attack() {
		public void attack(Pokemon target) {
			System.out.println("Posion Powder is used!");
			target.setPosioned(true);
		}
	});
 
 raticate.lapse();
 bulbasaur.lapse();
 printScore(raticate, bulbasaur);
	}

	private static void printScore(Pokemon raticate, Pokemon bulbasaur) {
		System.out.println(raticate.getName()+ " HP = " + raticate.getHP());
		System.out.println(bulbasaur.getName()+ " HP = " + bulbasaur.getHP());
	}
}
