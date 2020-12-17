package view;

import java.util.LinkedList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Entry;

public class ResultsTableModel extends AbstractTableModel {

	private List<Entry> entries = new LinkedList<Entry>();
	
	private String[] colNames = {"STATUS", "ROOT", "DEFINITION"};
	
	
	public void setData(List<Entry> list) {
		this.entries = list;
	}
	
	@Override
	public String getColumnName(int column) {
		return colNames[column];
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
		Entry entry = entries.get(arg0);
		
		switch(arg1) {
		case 0:
			return entry.getStatus();
		case 1:
			return entry.getRoot();
		case 2:
			return entry.getDef();
		default:
			return "Invalid index";
		}
	}
}
