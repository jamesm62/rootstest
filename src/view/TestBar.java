package view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

public class TestBar extends JToolBar {
	
	private TestListener listener;
	private JButton startTest;
	private JButton pauseTest;
	private JButton endTest;
	private TableListener tableListener;
	
	private ActionListener start = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			startTest.setEnabled(false);
			pauseTest.setEnabled(true);
			endTest.setEnabled(true);
			listener.testStarted();
			
		}
		
	};
	
	private ActionListener pause = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			startTest.setEnabled(true);
			pauseTest.setEnabled(false);
			endTest.setEnabled(true);
			listener.testPaused();
			
		}
		
	};
	
	private ActionListener end = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			startTest.setEnabled(true);
			pauseTest.setEnabled(false);
			endTest.setEnabled(false);
			tableListener.rowsDeleted();
			listener.testEnded();
			
		}
		
	};
	public TestBar() {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		startTest = new JButton("Start Test");
		pauseTest = new JButton("Pause Test");
		endTest = new JButton("End Test");
		
		startTest.setEnabled(true);
		pauseTest.setEnabled(false);
		endTest.setEnabled(false);
		
		startTest.addActionListener(start);
		pauseTest.addActionListener(pause);
		endTest.addActionListener(end);
		
		add(startTest);
		add(pauseTest);
		add(endTest);
	}
	
	public void setTestListener(TestListener listener) {
		this.listener = listener;
	}
	
	public ActionListener getStart() {
		return start;
	}
	
	public ActionListener getPause() {
		return pause;
	}
	
	public ActionListener getEnd() {
		return end;
	}
	
	public void setTableListener(TableListener listener) {
		this.tableListener = listener;
	}
}
