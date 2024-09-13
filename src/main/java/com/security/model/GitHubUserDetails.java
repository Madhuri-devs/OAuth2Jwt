package com.security.model;


import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="GitHubUserDetails")
public class GitHubUserDetails {
	private String login;
	private Integer id;
	@JsonProperty("node_id")
	private String nodeId;
	@JsonProperty("avatar_url")
	private String avatarUrl;
	@JsonProperty("gravatar_id")
	private String gravatarId;
	private String url;
	@JsonProperty("html_url")
	private String htmlUrl;
	@JsonProperty("followers_url")
	private String followersUrl;
	@JsonProperty("following_url")
	private String followingUrl;
	@JsonProperty("gists_url")
	private String gistsUrl;
	@JsonProperty("starred_url")
	private String starredUrl;
	@JsonProperty("subscriptions_url")
	private String subscriptionsUrl;
	@JsonProperty("organizations_url")
	private String organizationsUrl;
	@JsonProperty("repos_url")
	private String reposUrl;
	@JsonProperty("events_url")
	private String eventsUrl;
	@JsonProperty("received_events_url")
	private String receivedEventsUrl;
	private String type;
	@JsonProperty("site_admin")
	private Boolean siteAdmin;
	private String name;
	private Object company;
	private String blog;
	private Object location;
	private Object email;
	private Object hireable;
	private Object bio;
	@JsonProperty("twitter_username")
	private Object twitterUsername;
	@JsonProperty("public_repos")
	private Integer publicRepos;
	@JsonProperty("public_gists")
	private Integer publicGists;
	private Integer followers;
	private Integer following;
	@JsonProperty("created_at")
	private String createdAt;
	@JsonProperty("updated_at")
	private String updatedAt;
	@JsonProperty("private_gists")
	private Integer privateGists;
	@JsonProperty("total_private_repos")
	private Integer totalPrivateRepos;
	@JsonProperty("owned_private_repos")
	private Integer ownedPrivateRepos;
	@JsonProperty("disk_usage")
	private Integer diskUsage;
	private Integer collaborators;
	@JsonProperty("two_factor_authentication")
	private Boolean twoFactorAuthentication;
	private Plan plan;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getGravatarId() {
		return gravatarId;
	}

	public void setGravatarId(String gravatarId) {
		this.gravatarId = gravatarId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getFollowersUrl() {
		return followersUrl;
	}

	public void setFollowersUrl(String followersUrl) {
		this.followersUrl = followersUrl;
	}

	public String getFollowingUrl() {
		return followingUrl;
	}

	public void setFollowingUrl(String followingUrl) {
		this.followingUrl = followingUrl;
	}

	public String getGistsUrl() {
		return gistsUrl;
	}

	public void setGistsUrl(String gistsUrl) {
		this.gistsUrl = gistsUrl;
	}

	public String getStarredUrl() {
		return starredUrl;
	}

	public void setStarredUrl(String starredUrl) {
		this.starredUrl = starredUrl;
	}

	public String getSubscriptionsUrl() {
		return subscriptionsUrl;
	}

	public void setSubscriptionsUrl(String subscriptionsUrl) {
		this.subscriptionsUrl = subscriptionsUrl;
	}

	public String getOrganizationsUrl() {
		return organizationsUrl;
	}

	public void setOrganizationsUrl(String organizationsUrl) {
		this.organizationsUrl = organizationsUrl;
	}

	public String getReposUrl() {
		return reposUrl;
	}

	public void setReposUrl(String reposUrl) {
		this.reposUrl = reposUrl;
	}

	public String getEventsUrl() {
		return eventsUrl;
	}

	public void setEventsUrl(String eventsUrl) {
		this.eventsUrl = eventsUrl;
	}

	public String getReceivedEventsUrl() {
		return receivedEventsUrl;
	}

	public void setReceivedEventsUrl(String receivedEventsUrl) {
		this.receivedEventsUrl = receivedEventsUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Boolean getSiteAdmin() {
		return siteAdmin;
	}

	public void setSiteAdmin(Boolean siteAdmin) {
		this.siteAdmin = siteAdmin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getCompany() {
		return company;
	}

	public void setCompany(Object company) {
		this.company = company;
	}

	public String getBlog() {
		return blog;
	}

	public void setBlog(String blog) {
		this.blog = blog;
	}

	public Object getLocation() {
		return location;
	}

	public void setLocation(Object location) {
		this.location = location;
	}

	public Object getEmail() {
		return email;
	}

	public void setEmail(Object email) {
		this.email = email;
	}

	public Object getHireable() {
		return hireable;
	}

	public void setHireable(Object hireable) {
		this.hireable = hireable;
	}

	public Object getBio() {
		return bio;
	}

	public void setBio(Object bio) {
		this.bio = bio;
	}

	public Object getTwitterUsername() {
		return twitterUsername;
	}

	public void setTwitterUsername(Object twitterUsername) {
		this.twitterUsername = twitterUsername;
	}

	public Integer getPublicRepos() {
		return publicRepos;
	}

	public void setPublicRepos(Integer publicRepos) {
		this.publicRepos = publicRepos;
	}

	public Integer getPublicGists() {
		return publicGists;
	}

	public void setPublicGists(Integer publicGists) {
		this.publicGists = publicGists;
	}

	public Integer getFollowers() {
		return followers;
	}

	public void setFollowers(Integer followers) {
		this.followers = followers;
	}

	public Integer getFollowing() {
		return following;
	}

	public void setFollowing(Integer following) {
		this.following = following;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Integer getPrivateGists() {
		return privateGists;
	}

	public void setPrivateGists(Integer privateGists) {
		this.privateGists = privateGists;
	}

	public Integer getTotalPrivateRepos() {
		return totalPrivateRepos;
	}

	public void setTotalPrivateRepos(Integer totalPrivateRepos) {
		this.totalPrivateRepos = totalPrivateRepos;
	}

	public Integer getOwnedPrivateRepos() {
		return ownedPrivateRepos;
	}

	public void setOwnedPrivateRepos(Integer ownedPrivateRepos) {
		this.ownedPrivateRepos = ownedPrivateRepos;
	}

	public Integer getDiskUsage() {
		return diskUsage;
	}

	public void setDiskUsage(Integer diskUsage) {
		this.diskUsage = diskUsage;
	}

	public Integer getCollaborators() {
		return collaborators;
	}

	public void setCollaborators(Integer collaborators) {
		this.collaborators = collaborators;
	}

	public Boolean getTwoFactorAuthentication() {
		return twoFactorAuthentication;
	}

	public void setTwoFactorAuthentication(Boolean twoFactorAuthentication) {
		this.twoFactorAuthentication = twoFactorAuthentication;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@Override
	public String toString() {
		return "GitHubUserDetails [login=" + login + ", id=" + id + ", nodeId=" + nodeId + ", avatarUrl=" + avatarUrl
				+ ", gravatarId=" + gravatarId + ", url=" + url + ", htmlUrl=" + htmlUrl + ", followersUrl="
				+ followersUrl + ", followingUrl=" + followingUrl + ", gistsUrl=" + gistsUrl + ", starredUrl="
				+ starredUrl + ", subscriptionsUrl=" + subscriptionsUrl + ", organizationsUrl=" + organizationsUrl
				+ ", reposUrl=" + reposUrl + ", eventsUrl=" + eventsUrl + ", receivedEventsUrl=" + receivedEventsUrl
				+ ", type=" + type + ", siteAdmin=" + siteAdmin + ", name=" + name + ", company=" + company + ", blog="
				+ blog + ", location=" + location + ", email=" + email + ", hireable=" + hireable + ", bio=" + bio
				+ ", twitterUsername=" + twitterUsername + ", publicRepos=" + publicRepos + ", publicGists="
				+ publicGists + ", followers=" + followers + ", following=" + following + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", privateGists=" + privateGists + ", totalPrivateRepos="
				+ totalPrivateRepos + ", ownedPrivateRepos=" + ownedPrivateRepos + ", diskUsage=" + diskUsage
				+ ", collaborators=" + collaborators + ", twoFactorAuthentication=" + twoFactorAuthentication
				+ ", plan=" + plan + "]";
	}
}