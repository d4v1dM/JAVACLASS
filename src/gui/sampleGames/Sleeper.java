package gui.sampleGames;

public class Sleeper implements Runnable{
	private int number;
	private int sleepTime;
	private Sleeper guy;
	public static void main(String[] args){
		Thread one = new Thread(new Sleeper(1));
		Thread two = new Thread(new Sleeper(2));
		Thread three = new Thread(new Sleeper(3));
		Thread four = new Thread(new Sleeper(4));
		
		one.start();
		two.start();
		three.start();
		four.start();
	}
	public Sleeper(int number) {
		this.number = number;
		this.sleepTime = (int)(Math.random()*1000);
	}
	public void run() {
		try {
			System.out.println("Thread # " + number +" will sleep for "+sleepTime +"milliseconds.");
			Thread.sleep(sleepTime);
			System.out.println("Thread # "+number + " woke up.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
