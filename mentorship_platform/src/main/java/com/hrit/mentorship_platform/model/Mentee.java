package com.hrit.mentorship_platform.model;

public class Mentee {
	    private int id;
	    private String name;
	    private String course;
	    private String bio;
	    private String contact_no;
	    private int userId;

	    

	    public Mentee() {
			super();
		}

		// Constructor
	    public Mentee(int id, String name, String course, String bio, String contact_no, int user_id) {
	        this.id = id;
	        this.name = name;
	        this.course = course;
	        this.bio = bio;
	        this.contact_no = contact_no;
	        this.userId=user_id;
	    }

	    // Getters and Setters
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

	    public String getCourse() {
	        return course;
	    }

	    public void setCourse(String course) {
	        this.course = course;
	    }

	    public String getBio() {
	        return bio;
	    }

	    public void setBio(String bio) {
	        this.bio = bio;
	    }

	    public Mentee(int id, String name, String course, String bio, String contact_no) {
			super();
			this.id = id;
			this.name = name;
			this.course = course;
			this.bio = bio;
			this.contact_no = contact_no;
		}

		public String getContact_no() {
	        return contact_no;
	    }

	    public void setContactNo(String contact_no) {
	        this.contact_no = contact_no;
	    }
	    
	    public int getUserId() {
	        return userId;
	    }
	    public void setUserId(int userId) {
	        this.userId = userId;
	    }

	}


