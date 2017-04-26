import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.util.HashMap;
import java.awt.Component;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class Window {

	JFrame frame;
	
	private boolean start = true;
	
	private JButton btnLap;
	
	public HashMap<String, Component> componentMap = new HashMap<String, Component>();
	

	/**
	 * Launch the application.
	 */
	public void launchWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 518, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.info);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnStartStop = new JButton("START");
		btnStartStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (!App.timeKeeper.JFrameSet())
					App.timeKeeper.setJFrame(frame);
				
				
				
				if (start) {
					btnStartStop.setText("STOP");
					System.out.println("START button pressed");
					btnLap.setEnabled(true);
					App.timeKeeper.startTime();
				}
					
				else {
					btnStartStop.setText("START");
					System.out.println("STOP button pressed");
					btnLap.setEnabled(false);
					App.timeKeeper.stopTime();
				}
					
				
				
				
				start = !start;
			}
		});
		btnStartStop.setBounds(391, 253, 97, 47);
		panel.add(btnStartStop);
		
		btnLap = new JButton("LAP");
		btnLap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO: Lap button
				App.timeKeeper.lapButtonHandler();
			}
		});
		btnLap.setEnabled(false);
		btnLap.setBounds(282, 253, 97, 47);
		panel.add(btnLap);
		
		JLabel lblNewLabel = new JLabel("0:00:000");
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 31));
		lblNewLabel.setBounds(12, 121, 476, 55);
		lblNewLabel.setName("lblLapTime");
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("0:00:000");
		label.setName("lblMainTime");
		label.setFont(new Font("Monospaced", Font.BOLD, 31));
		label.setBounds(12, 13, 476, 55);
		panel.add(label);
		
		JLabel lblLap = new JLabel("Lap");
		lblLap.setBounds(12, 109, 56, 16);
		panel.add(lblLap);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(12, 253, 258, 47);
		progressBar.setName("progressBar");
		panel.add(progressBar);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(12, 13, 56, 16);
		panel.add(lblTime);
		
	}
}