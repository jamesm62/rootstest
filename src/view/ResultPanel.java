package view;
import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Entry;


public class ResultPanel extends JPanel {
	
	ResultsTableModel rm;
	JTable table;
	public ResultPanel() {
		rm = new ResultsTableModel();
		table = new JTable(rm);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<Entry> entries) {
		rm.setData(entries);
	}
	
	public void refresh() {
		rm.fireTableDataChanged();
	}
}
