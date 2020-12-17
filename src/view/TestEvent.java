package view;

import java.awt.event.ActionEvent;
import java.util.EventObject;
import java.util.Set;

public class TestEvent extends EventObject {
	private String root;
	private String def;
	private boolean status;
	private ActionEvent event;
	
	public TestEvent(Object arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
	
	public TestEvent(Object source, String root, String def, boolean status, ActionEvent e) {
		super(source);
		
		this.root = root;
		this.def = def;
		this.status = status;
		this.event = e;
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


	public boolean isStatus() {
		return status;
	}


	public void setStatus(boolean status) {
		this.status = status;
	}


	public ActionEvent getEvent() {
		return event;
	}


	public void setEvent(ActionEvent event) {
		this.event = event;
	}
	
	
}
