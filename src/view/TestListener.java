package view;

public interface TestListener {
	public void testStarted();
	public void testPaused();
	public void testEnded();
	public void dataSubmitted(TestEvent event);
}
