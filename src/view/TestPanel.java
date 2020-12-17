package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TestPanel extends JPanel {
	Words word = new Words();
	private JLabel rootLabel;
	JLabel rootField;
	private JLabel defLabel;
	JTextField defField;
	private JButton ok;
	TestListener listener;
	private JLabel correctLabel;
	private JLabel incorrectLabel;
	private int correctCount = 0;
	private int incorrectCount = 0;
	private int totalCount = correctCount + incorrectCount;
	ActionListener okListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!(defField.getText().equals(""))) {
				String root = MainFrame.roots.get(totalCount);
				Set<String> def = word.getDefForRoot(root);
				String defReal = word.getDefForRootList(root).get(0);
				
				boolean status;
				if (def.contains(defField.getText())) {
					totalCount++;
					correctCount++;
					correctLabel.setText("Correct: " + correctCount);
					status = true;
				} else {
					totalCount++;
					incorrectCount++;
					incorrectLabel.setText("Incorrect: " + incorrectCount);
					status = false;
				}
	
				defField.setText("");
				if(totalCount < 158) {
					rootField.setText(MainFrame.roots.get(totalCount));
				}
				
				TestEvent event = new TestEvent(ok, root, defReal, status, e);
				listener.dataSubmitted(event);
				
			}

		}

	};

	public TestPanel() {
		word = new Words();
		rootLabel = new JLabel("Root: ");
		rootField = new JLabel();
		defLabel = new JLabel("Definition: ");
		defField = new JTextField(20);
		ok = new JButton("OK");
		correctLabel = new JLabel("Correct: " + correctCount);
		incorrectLabel = new JLabel("Incorrect: " + incorrectCount);
		
		ok.setMnemonic(KeyEvent.VK_O);

		setBorder(BorderFactory.createTitledBorder("Test"));

		ok.addActionListener(okListener);
		defField.addActionListener(okListener);

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// First row

		gc.weightx = 1;
		gc.weighty = 0.2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);

		add(rootLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);

		add(rootField, gc);

		// Next row

		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);

		add(defLabel, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);

		add(defField, gc);

		// Next row

		gc.weighty = 2;
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(ok, gc);

		// Next row

		gc.weighty = 0.1;
		gc.weightx = 1;
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 20);

		add(correctLabel, gc);

		gc.weighty = 0.1;
		gc.weightx = 1;
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 20);

		add(incorrectLabel, gc);
	}

	public void setTestListener(TestListener listener) {
		this.listener = listener;
	}

	public int getCorrectCount() {
		return correctCount;
	}
	
	public int getIncorrectCount() {
		return incorrectCount;
	}

	public void setCorrectCount(int correctCount) {
		this.correctCount = correctCount;
	}

	public void setIncorrectCount(int incorrectCount) {
		this.incorrectCount = incorrectCount;
	}
	
	public void setCorrectLabel(String text) {
		correctLabel.setText(text);
	}
	
	public void setIncorrectLabel(String text) {
		incorrectLabel.setText(text);
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
}
