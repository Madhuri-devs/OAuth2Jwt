package com.security.model;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="Plan"
		+ "")
public class Plan {
    private String name;
    private Integer space;
    private Integer collaborators;
    @JsonProperty("private_repos")
    private Integer privateRepos;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getSpace() {
        return space;
    }
    public void setSpace(Integer space) {
        this.space = space;
    }
    public Integer getCollaborators() {
        return collaborators;
    }
    public void setCollaborators(Integer collaborators) {
        this.collaborators = collaborators;
    }
    public Integer getPrivateRepos() {
        return privateRepos;
    }
    public void setPrivateRepos(Integer privateRepos) {
        this.privateRepos = privateRepos;
    }
	@Override
	public String toString() {
		return "Plan [name=" + name + ", space=" + space + ", collaborators=" + collaborators + ", privateRepos="
				+ privateRepos + "]";
	}
}