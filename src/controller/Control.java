package controller;

import java.util.List;

import model.Database;
import model.Entry;
import model.Status;
import model.TestEntry;
import view.TestEntryEvent;
import view.TestEvent;

public class Control {
	Database db = new Database();
	
	public void addEntry(TestEvent event) {
		Status status;
		if(event.isStatus() == true) {
			status = Status.correct;
		} else {
			status = Status.incorrect;
		}
		
		Entry entry = new Entry(event.getRoot(), event.getDef(), status);
		
		db.addEntry(entry);
	}
	
	public void deleteEntries() {
		db.deleteEntries();
	}
	
	public List<Entry> getEntries() {
		return db.getEntries();
	}
	
	public List<TestEntry> getTestEntries() {
		return db.getTestEntries();
	}
	
	public void addTestEntry(TestEntryEvent event) {
		TestEntry entry = new TestEntry(event.getName(), event.getCorrect(), event.getIncorrect());
		
		db.addTestEntry(entry);
	}
}
