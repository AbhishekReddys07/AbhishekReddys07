package power_OptiNew;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Single_app {
	public static void main(String[] args) {
		new thread().run();
	}

}

class thread extends Thread {
	static byte hour;
	static byte hour1;
	static byte min;
	static int count = 0;

	public void run() {
		// Thread t = new Thread();
		LocalTime localTime = LocalTime.now();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String time = localTime.format(timeFormatter);
		System.out.println("from timer line 23 -->" + " " + localTime.format(timeFormatter));
		String[] timeParts = time.split(":");
		hour = (byte) Integer.parseInt(timeParts[0]);
		hour1 = (byte) Integer.parseInt(timeParts[0]);
		min = (byte) Integer.parseInt(timeParts[1]);

		System.out.println("Hour : " + hour + "\t minute " + min);
		Minutes(min, hour1);
	}

	// Function for minutes, Entry Point
	static void Minutes(int min, int hour1) {
		// System.out.println(min);
		for (int i = 0; i < 60; i++) {
			if (min < 59) {
				try {
//					Thread.sleep(10);
					min++;

				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(hour1 + " " + min);
				gui(hour1, min);
			}
		}
		if (min < 60) {
			min = 0;
			++hour1;
			if (hour1 <= 24) {
				Minutes(min, hour1);
			} else {
				count++;
				System.out.println("count is : " + count);

				if (count == 1) {
					System.out.println("off");
//					shutdownPC();
				} else {
					Minutes(min = 0, hour1 = 0);
				}
			}
		}
	}

	static void gui(int hour1, int min2) {
		JFrame frame = new JFrame("Addition GUI");
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel, hour1, min2);

		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel, int hour12, int min2) {
		panel.setLayout(null);
		Object obj[] = { hour12, min2 };
		JLabel resultLabel = new JLabel(
				"hour : " + obj[0] + " " + "min : " + obj[1] + " " + "c" + count);
		resultLabel.setBounds(10, 80, 120, 250);
		resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(resultLabel);

	}

	static void shutdownPC() {
		String shutdownCommand;
		String operatingSystem = System.getProperty("os.name");

		try {
			if (operatingSystem.toLowerCase().contains("win")) {
				closeAll();
				shutdownCommand = "shutdown.exe -s -t 0";

			} else if (operatingSystem.toLowerCase().contains("nix") || operatingSystem.toLowerCase().contains("nux")
					|| operatingSystem.toLowerCase().contains("mac")) {
				closeAll();
				shutdownCommand = "shutdown -h now";

			} else {
				throw new UnsupportedOperationException("Unsupported operating system.");
			}

			Runtime.getRuntime().exec(shutdownCommand);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("sh down");
	}

	static void closeAll() {

		try {
			// Execute system command to end all tasks
			ProcessBuilder processBuilder = new ProcessBuilder("taskkill", "/F", "/IM", "*", "/T");
			Process process = processBuilder.start();
			process.waitFor(); // Wait for the process to complete

			// Execute system command to shut down the system
			processBuilder.command("shutdown", "/s", "/t", "0");
			process = processBuilder.start();
			process.waitFor(); // Wait for the process to complete
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}