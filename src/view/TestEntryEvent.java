package view;

public class TestEntryEvent {
	String name;
	int correct;
	int incorrect;
	
	public TestEntryEvent(String name, int correct, int incorrect) {
		this.name = name;
		this.correct = correct;
		this.incorrect = incorrect;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCorrect() {
		return correct;
	}

	public void setCorrect(int correct) {
		this.correct = correct;
	}

	public int getIncorrect() {
		return incorrect;
	}

	public void setIncorrect(int incorrect) {
		this.incorrect = incorrect;
	}
	
}
