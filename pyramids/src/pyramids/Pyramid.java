package pyramids;

public class Pyramid {
	String pharaoh; 
	String modern_name; 
	String site; 
	float height;
	public Pyramid(String pharaoh, String modern_name, String site, float height){
		this.pharaoh=pharaoh; 
		this.modern_name=modern_name; 
		this.site=site; 
		this.height=height;
	}
	
					/*******************Getter methods********************/
	public float getHeight() {
		return this.height;
	}
	
	public String getModern_Name() {
		return this.modern_name;
	}
	
	public String getPharaoh() {
		return this.pharaoh;
	}
	
	public String getSite() {
		return this.site;
	}
	
						/*******************Setter methods********************/
	public void setHeight(float height) {
		this.height=height;
	}
	
	public void setModern_Name(String modern_name) {
		this.modern_name = modern_name;
	}
	
	public void setPharaoh(String pharaoh) {
		this.pharaoh = pharaoh;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	/*
	public String toString() {
		return ?
	}*/


}
