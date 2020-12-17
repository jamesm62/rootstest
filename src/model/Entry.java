package model;

public class Entry {
	private String root;
	private String def;
	private Status status;
	
	public Entry(String root, String def, Status status) {
		this.root = root;
		this.def = def;
		this.status = status;
	}
	public String getRoot() {
		return root;
	}
	public void setRoot(String root) {
		this.root = root;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
}
