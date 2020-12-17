package model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
	private List<Entry> entries = new LinkedList<Entry>();
	
	private List<TestEntry> tests = new LinkedList<TestEntry>();
	
	public List<Entry> getEntries() {
		return Collections.unmodifiableList(entries);
	}
	
	public void addEntry(Entry entry) {
		entries.add(entry);
	}
	
	public void deleteEntries() {
		entries.clear();
	}
	
	public void addTestEntry(TestEntry testEntry) {
		tests.add(testEntry);
	}
	
	public List<TestEntry> getTestEntries() {
		return Collections.unmodifiableList(tests);
	}
}
