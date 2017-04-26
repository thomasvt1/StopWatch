
public class ThreadManager extends Thread {

	boolean loop = true;
	
	public void run() {
		System.out.println("Thread run!");
		
		loop();
	}
	
	
	private void loop() {
		while (loop)
			App.timeKeeper.updateUI();
	}
}