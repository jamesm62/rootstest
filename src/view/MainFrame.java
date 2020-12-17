package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Control;

public class MainFrame extends JFrame {
	TestPanel panel;
	TestBar bar;
	ResultPanel results;
	TestTable testTable;
	Control control;
	CheatSheet sheet;
	private long startTime;
	private long endTime;
	private JCheckBoxMenuItem cheatSheet;
	private JCheckBoxMenuItem tableTest;
	private JMenuItem start = new JMenuItem("Start Test");
	private JMenuItem pause = new JMenuItem("Pause Test");
	private JMenuItem end = new JMenuItem("End Test");
	private String name = new String("");
	public static List<String> roots = new LinkedList<String>();
	public static Map<String, Set<String>> rootsAndDefs = new LinkedHashMap<String, Set<String>>();
	private boolean testing = false;
	private Map<String, Boolean> rootsMap;

	public MainFrame() {

		super("Test");
		
		setJMenuBar(createMenuBar());
		
		panel = new TestPanel();
		results = new ResultPanel();
		bar = new TestBar();
		control = new Control();
		sheet = new CheatSheet();
		testTable = new TestTable();
		
		panel.setVisible(false);
		results.setVisible(false);
		sheet.setPreferredSize(new Dimension(0, 698));
		bar.setVisible(true);
		sheet.setVisible(false);
		testTable.setVisible(false);
		
		panel.setTestListener(new TestListener() {

			@Override
			public void testStarted() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void testEnded() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void dataSubmitted(TestEvent event) {
				if(panel.getTotalCount() < panel.word.getArray().length) {
					control.addEntry(event);
					results.refresh();
				} else {
					JOptionPane.showMessageDialog(MainFrame.this, "You have reached the end of the test!", "Test Completed", JOptionPane.INFORMATION_MESSAGE);
					
					bar.getEnd().actionPerformed(event.getEvent());
				}
			}

			@Override
			public void testPaused() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		results.setData(control.getEntries());
		testTable.setData(control.getTestEntries());
		
		bar.setTestListener(new TestListener() {

			@Override
			public void testStarted() {
				start.setEnabled(false);
				pause.setEnabled(true);
				end.setEnabled(true);
				panel.setVisible(true);
				results.setVisible(true);
				cheatSheet.setEnabled(false);
				tableTest.setEnabled(false);
				rootsMap = new HashMap<String, Boolean>();
				for(int i = 0; i < panel.word.getArray().length; i++) {
					rootsMap.put(panel.word.getArray()[i][0], true);
				}
				
				while(roots.size() != 158) {
					panel.word.setRoot();
					if(rootsMap.get(panel.word.getRoot()) == true) {
						roots.add(panel.word.getRoot());
						rootsMap.remove(panel.word.getRoot());
						rootsMap.put(panel.word.getRoot(), false);
					}
				}
				panel.rootField.setText(roots.get(panel.getTotalCount()));
				panel.defField.setText("");
				if(testing != true) {
					name = JOptionPane.showInputDialog(MainFrame.this, "Please enter your name: ", "Test", JOptionPane.INFORMATION_MESSAGE);
					if(name == null) {
						name = "Not Recorded";
					}
				}
				
			}

			@Override
			public void testEnded() {
				start.setEnabled(true);
				pause.setEnabled(false);
				end.setEnabled(false);
				results.setVisible(false);
				panel.setVisible(false);
				cheatSheet.setEnabled(true);
				tableTest.setEnabled(true);
				if(panel.getTotalCount() == 158) {
					JOptionPane.showMessageDialog(MainFrame.this, "This test has been completed with " + panel.getCorrectCount() + " questions correct!", "Test Completed", JOptionPane.INFORMATION_MESSAGE);
					
					TestEntryEvent event = new TestEntryEvent(name, panel.getCorrectCount(), panel.getIncorrectCount());
					
					control.addTestEntry(event);
					testTable.refresh();
				}
				
				if(panel.getTotalCount() < 158) {
					JOptionPane.showMessageDialog(MainFrame.this, "You did not complete all questions on the test!", "Test Incomplete", JOptionPane.INFORMATION_MESSAGE);
				}
				
				panel.setCorrectCount(0);
				panel.setIncorrectCount(0);
				panel.setTotalCount(0);
				
				panel.setCorrectLabel("Correct: " + panel.getCorrectCount());
				panel.setIncorrectLabel("Incorrect: " + panel.getIncorrectCount());
				
				testing = false;
				
				roots.clear();
			}

			@Override
			public void dataSubmitted(TestEvent event) {
				control.addEntry(event);
				results.refresh();
				
			}

			@Override
			public void testPaused() {
				start.setEnabled(true);
				pause.setEnabled(false);
				end.setEnabled(true);
				results.setVisible(true);
				panel.setVisible(false);
				cheatSheet.setEnabled(false);
				tableTest.setEnabled(false);
				testing = true;
				
			}
			
		});
		
		bar.setTableListener(new TableListener() {

			@Override
			public void rowsDeleted() {
				control.deleteEntries();
				results.refresh();
				
			}
			
		});

		setLayout(new BorderLayout());

		add(panel, BorderLayout.WEST);
		add(results, BorderLayout.CENTER);
		add(bar, BorderLayout.NORTH);
		add(sheet, BorderLayout.SOUTH);
		add(testTable, BorderLayout.EAST);
		
		setVisible(true);
		setSize(1280, 760);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JMenuBar createMenuBar() {
		JMenuBar menu = new JMenuBar();
		
		JMenu file = new JMenu("File");
		start = new JMenuItem("Start Test");
		pause = new JMenuItem("Pause Test");
		end = new JMenuItem("End Test");
		JMenuItem exit = new JMenuItem("Exit");
		
		JMenu window = new JMenu("Window");
		JMenu show = new JMenu("Show");
		JCheckBoxMenuItem showBar = new JCheckBoxMenuItem("Show Test Menu");
		cheatSheet = new JCheckBoxMenuItem("Show Cheatsheet");
		tableTest = new JCheckBoxMenuItem("Show Tests");
		
		JMenu timer = new JMenu("Timer");
		JMenuItem startTimer = new JMenuItem("Start Timer");
		JMenuItem stopTimer = new JMenuItem("Stop Timer");
		
		
		menu.add(file);
		file.add(start);
		start.setEnabled(true);
		file.add(pause);
		pause.setEnabled(false);
		file.add(end);
		end.setEnabled(false);
		file.addSeparator();
		file.add(exit);
		
		menu.add(window);
		window.add(show);
		show.add(showBar);
		show.add(cheatSheet);
		show.add(tableTest);
		showBar.setSelected(true);
		cheatSheet.setSelected(false);
		tableTest.setSelected(false);
		
		menu.add(timer);
		timer.add(startTimer);
		startTimer.setEnabled(true);
		timer.add(stopTimer);
		stopTimer.setEnabled(false);
		
		start.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setEnabled(false);
				pause.setEnabled(true);
				end.setEnabled(true);
				cheatSheet.setEnabled(false);
				bar.getStart().actionPerformed(e);
				
			}
			
		});
		
		pause.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setEnabled(true);
				pause.setEnabled(false);
				end.setEnabled(true);
				cheatSheet.setEnabled(false);
				bar.getPause().actionPerformed(e);
				
			}
			
		});
		
		end.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				start.setEnabled(true);
				pause.setEnabled(false);
				end.setEnabled(false);
				cheatSheet.setEnabled(true);
				bar.getEnd().actionPerformed(e);
				
			}
			
		});
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrame.this, "Are you sure you want to exit the application?", "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				
			}
			
		});
		
		showBar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bar.setVisible(showBar.isSelected());
				
			}
			
		});
		
		startTimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startTimer.setEnabled(false);
				stopTimer.setEnabled(true);
				startTime = System.currentTimeMillis();
				
			}
			
		});
		
		stopTimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				startTimer.setEnabled(true);
				stopTimer.setEnabled(false);
				endTime = System.currentTimeMillis();
				
				JOptionPane.showMessageDialog(MainFrame.this, "Time taken: " + ((endTime - startTime)/1000) + " seconds.", "Timer", JOptionPane.INFORMATION_MESSAGE);
			}
			
		});
		
		cheatSheet.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if(cheatSheet.isSelected() == true) {
					showBar.setSelected(false);
					tableTest.setSelected(false);
					showBar.setEnabled(false);
					tableTest.setEnabled(false);
					start.setEnabled(false);
					pause.setEnabled(false);
					end.setEnabled(false);
					bar.setVisible(false);
					testTable.setVisible(false);
				} else {
					showBar.setEnabled(true);
					tableTest.setEnabled(true);
					showBar.setSelected(true);
					tableTest.setSelected(false);
					start.setEnabled(true);
					bar.setVisible(true);
					testTable.setVisible(false);
				}
				
				sheet.setVisible(cheatSheet.isSelected());
				
			}
			
		});
		
		tableTest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(tableTest.isSelected() == true) {
					showBar.setSelected(false);
					cheatSheet.setSelected(false);
					showBar.setEnabled(false);
					cheatSheet.setEnabled(false);
					start.setEnabled(false);
					pause.setEnabled(false);
					end.setEnabled(false);
					bar.setVisible(false);
					sheet.setVisible(false);
				} else {
					showBar.setEnabled(true);
					cheatSheet.setEnabled(true);
					showBar.setSelected(true);
					cheatSheet.setSelected(false);
					start.setEnabled(true);
					bar.setVisible(true);
					sheet.setVisible(false);
				}
				
				testTable.setVisible(tableTest.isSelected());
				
			}
			
		});
		
		exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		start.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		pause.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		end.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		showBar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
		cheatSheet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		tableTest.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		startTimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		stopTimer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		file.setMnemonic(KeyEvent.VK_F);
		exit.setMnemonic(KeyEvent.VK_X);
		start.setMnemonic(KeyEvent.VK_S);
		pause.setMnemonic(KeyEvent.VK_P);
		end.setMnemonic(KeyEvent.VK_E);
		
		window.setMnemonic(KeyEvent.VK_W);
		show.setMnemonic(KeyEvent.VK_S);
		showBar.setMnemonic(KeyEvent.VK_M);
		cheatSheet.setMnemonic(KeyEvent.VK_C);
		tableTest.setMnemonic(KeyEvent.VK_T);
		
		timer.setMnemonic(KeyEvent.VK_T);
		startTimer.setMnemonic(KeyEvent.VK_S);
		stopTimer.setMnemonic(KeyEvent.VK_P);
		
		return menu;
		
	}

	public static Map<String, Set<String>> getRootsAndDefs() {
		return rootsAndDefs;
	}

	public static void setRootsAndDefs(Map<String, Set<String>> rootsAndDefs) {
		MainFrame.rootsAndDefs = rootsAndDefs;
	}
	
}
