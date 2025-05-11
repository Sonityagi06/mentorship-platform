package com.hrit.mentorship_platform.model;

public class Mentor {

	private int id;
    private String name;
    private String expertise;
    private String bio;
    private String contact_no;
    private int experienceYears;
    private int userId;
    
    
	
	public Mentor() {
		super();
	}
	public Mentor(int id, String name, String expertise, String bio, String contact_no, int experienceYears) {
		super();
		this.id = id;
		this.name = name;
		this.expertise = expertise;
		this.bio = bio;
		this.contact_no = contact_no;
		this.experienceYears = experienceYears;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpertise() {
		return expertise;
	}
	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getContact_no() {
		return contact_no;
	}
	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}
	public int getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(int experienceYears) {
		this.experienceYears = experienceYears;
	}
	
	public int getUserId() {
	    return userId;
	}
	public void setUserId(int userId) {
	    this.userId = userId;
	}
	
    
}
