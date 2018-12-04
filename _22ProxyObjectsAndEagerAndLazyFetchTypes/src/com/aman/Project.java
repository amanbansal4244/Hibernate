package com.aman;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Project {
	@Column(name = "PROJECT_NAME", nullable = false, length=250)
	private String projectName;
	
	public Project() {
	}
	
	public Project(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}
