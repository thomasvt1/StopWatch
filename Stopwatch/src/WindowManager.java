import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class WindowManager {
	
	FrameTools ft;
	Frame frame;
	
	public WindowManager(JFrame frame) {
		this.frame = frame;
		ft = new FrameTools(frame);
	}
	
	public void setMainTime(long min, long sec, long milis) {
		JLabel lblTime = (JLabel) ft.getComponentByName("lblMainTime");
		
		if (lblTime == null)
			System.out.println("lblMainTime is NULL");
		
		lblTime.setText(min + ":" + sec + ":" + milis);
	}
	
	public void setLapTime(long min, long sec, long milis) {
		JLabel lblTime = (JLabel) ft.getComponentByName("lblLapTime");
		
		if (lblTime == null)
			System.out.println("lblLapTime is NULL");
		
		lblTime.setText(min + ":" + sec + ":" + milis);
	}
	
	public void setProgressBar(int perc) {
		JProgressBar progressBar = (JProgressBar) ft.getComponentByName("progressBar");
		progressBar.setValue(perc);
	}
	
	public void clearLapTime() {
		JLabel lblTime = (JLabel) ft.getComponentByName("lblLapTime");
		
		lblTime.setText("0:00:000");
	}
}