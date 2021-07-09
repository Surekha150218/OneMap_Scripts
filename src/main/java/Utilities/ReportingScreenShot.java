package Utilities;

public class ReportingScreenShot {

	private boolean screenshotstatus;
	private Object screenShotObj;
	private int xcoord;
	private int ycoord;
	
	public void setX(int x) {
		this.xcoord = x;
	}
	public void setY(int y) {
		this.ycoord = y;
	}
	
	public int getX() {
		return xcoord;
	}
	public int getY() {
		return ycoord;
	}
	
	
	
	public boolean isStatus() {
		return screenshotstatus;
	}
	public void setStatus(boolean status) {
		this.screenshotstatus = status;
	}
	public Object getObject() {
		return screenShotObj;
	}
	public void setObject(Object retObject) {
		this.screenShotObj = retObject;
	}
	
}
