package caveExplorer;

public class Door {
	
	private boolean locked;
	private boolean open;
	private String description;
	private String details;
		
	public Door(){
		locked = false;
		open = true;
		description = "Passage";
		details = "";
		
		
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public void setLocked(boolean b){
		locked = b;
	}
	public boolean isLocked(){
		return locked;
	}
	public String getDescription() {
		return description;
	}
	public String getDetails() {
		return details;
	}
	
	
}
