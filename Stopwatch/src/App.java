public class App {
	
	static TimeKeeper timeKeeper;
	static Window window;
	
	public static void main(String[] args) {
		timeKeeper = new TimeKeeper();
		window = new Window();
		window.launchWindow();
		
	}
}