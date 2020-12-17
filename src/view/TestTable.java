package view;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.TestEntry;

public class TestTable extends JPanel {
	
	TestTableModel model = new TestTableModel();
	JTable table = new JTable(model);
	
	public TestTable() {
		setLayout(new BorderLayout());
		
		add(new JScrollPane(table), BorderLayout.CENTER);
	}
	
	public void setData(List<TestEntry> list) {
		model.setData(list);
	}
	
	public void refresh() {
		model.fireTableDataChanged();
	}
}
