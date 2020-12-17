package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CheatSheet extends JPanel {
	CheatSheetTableModel model = new CheatSheetTableModel();
	JTable sheet = new JTable(model);
	
	public CheatSheet() {
		setLayout(new BorderLayout());
		
		add(new JScrollPane(sheet), BorderLayout.CENTER);
	}
}
