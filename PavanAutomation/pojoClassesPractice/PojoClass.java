package pojoClassesPractice;

public class PojoClass {

	private String instructor;
	private String url;
	private String service;
	private String linkdIn;
	private String expertise;
	private courses courses;
	
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getService() {
		return service;
	}
	public void setService(String service) {
		this.service = service;
	}
	public String getLinkdIn() {
		return linkdIn;
	}
	public void setLinkdIn(String linkdIn) {
		this.linkdIn = linkdIn;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public pojoClassesPractice.courses getCourses() {
		return courses;
	}
	public void setCourses(pojoClassesPractice.courses courses) {
		this.courses = courses;
	}
	
}
