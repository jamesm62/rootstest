package view;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class CheatSheetTableModel extends AbstractTableModel {
	
	Words word = new Words();
	
	
	@Override
	public String getColumnName(int arg0) {
		switch(arg0) {
		case 0:
			return "ROOT";
		case 1:
			return "DEFINITION";
			default:
				return "Invalid";
		}
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public int getRowCount() {
		return word.array.length;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		return word.array[arg0][arg1];
	}
	
}
