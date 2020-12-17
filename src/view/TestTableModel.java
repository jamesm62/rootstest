package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.TestEntry;

public class TestTableModel extends AbstractTableModel {
	
	List<TestEntry> entries = new LinkedList<TestEntry>();
	
	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "TESTER";
		case 1:
			return "CORRECT";
		case 2:
			return "INCORRECT";
			default:
				return "invalid";
		}
	}
	
	public void setData(List<TestEntry> entries) {
		this.entries = entries;
	}
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return entries.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		if(arg1 == 0) {
			return entries.get(arg0).getName();
		} else if(arg1 == 1) {
			return entries.get(arg0).getCorrect();
		} else {
			return entries.get(arg0).getIncorrect();
		}
	}
	
}
