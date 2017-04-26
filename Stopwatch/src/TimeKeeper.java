import javax.swing.JFrame;

public class TimeKeeper {
	
	private boolean init = false;
	ThreadManager tm;
	WindowManager wm;
	JFrame frame;
	
	long startTime = 0;
	long lapTime = 0;

	boolean JFrameSet() {
		return frame != null;
	}
	
	void setJFrame(JFrame frame) {
		this.frame = frame;
		wm = new WindowManager(frame);
		init = true;
	}
	
	public void startTime() {
		startTime = System.currentTimeMillis();
		lapTime = -1;
		
		tm = new ThreadManager();
		tm.start();
	}
	
	public void lapButtonHandler() {
		lapTime = System.currentTimeMillis();
	}
	
	public void stopTime() {
		tm.loop = false;
	}
	
	public long getTime() {
		return startTime;
	}

	
	public void updateUI() {
		if (!isInit())
			return;
		
		if (startTime == 0) {
			startTime = System.currentTimeMillis();
			System.out.println("startTime == 0");
		}
			
		
		TimeTools tt1 = new TimeTools(startTime);
		wm.setMainTime(tt1.getMinutes(), tt1.getSeconds(), tt1.getMilis());
		
		if (lapTime == -1) {
			wm.clearLapTime();
			lapTime = 0;
		}
		
		else if (lapTime != 0) {
			TimeTools tt2 = new TimeTools(lapTime);
			
			wm.setLapTime(tt2.getMinutes(), tt2.getSeconds(), tt2.getMilis());
		}
	}
	
	private boolean isInit() {
		if (init)
			return true;
		System.out.println("Error! Not initialized");
		return false;
	}
}