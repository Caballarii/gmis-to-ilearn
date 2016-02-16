package com.llce.gmis.entity;

import java.util.Date;

/**
 * Represents a user instance.
 * @author xapphiron@vip.qq.com
 */
public class User {

	/**
	 * System id of the user.
	 */
	private int userId;
	
	/**
	 * Login name of the user.
	 */
	private String userName;
	
	/**
	 * Password hash code of the user.
	 */
	private String passwordHash;
	
	/**
	 * Email of the user.
	 */
	private String email;
	
	/**
	 * Password recovery question.
	 */
	private String passwordQuestion;
	
	/**
	 * Password recovery question's answer.
	 */
	private String passwordAnswer;
	
	/**
	 * Creation date and time.
	 */
	private Date createDate;
	
	/**
	 * Last modification date and time.
	 */
	private Date updateDate;
	
	/**
	 * The login key.
	 */
	private String loginKey;
	
	/**
	 * Last login date and time.
	 */
	private Date lastLoginDate;
	
	/**
	 * Last activity date and time.
	 */
	private Date lastActivityDate;
	
	private UserRole role;
	
	/**
	 * Is this user disabled by administrator. 
	 * (or not yet enabled by the administrator after register)
	 */
	private boolean isDisabled;
	
	/**
	 * Is this user deleted by administrator.
	 */
	private boolean isDeleted;
	
	/**
	 * The last login attempt date and time. 
	 */
	private Date lastLoginAttemptDate;
	
	/**
	 * Login attempt counter. 
	 */
	private int loginAttemptionCount;

	private String headPicB;
	
	private String headPicS;
	
	private int points; 
	
	private int rank; 
	
	private int voLevel;
	private int voNextLevel;
	private double voNextLevelImg;
	
	
	/**
	 * Get system id of the user.
	 * @return
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Set system id of the user.
	 * @param id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Get login name of the user.
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Set login name of the user.
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * Get password hash code of the user.
	 * @return
	 */
	public String getPasswordHash() {
		return passwordHash;
	}

	/**
	 * Set password hash code of the user.
	 * @param passwordHash
	 */
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	/**
	 * Get email of the user.
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email of the user.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get password recovery question.
	 * @return
	 */
	public String getPasswordQuestion() {
		return passwordQuestion;
	}

	/**
	 * Set password recovery question.
	 * @param passwordQuestion
	 */
	public void setPasswordQuestion(String passwordQuestion) {
		this.passwordQuestion = passwordQuestion;
	}

	/**
	 * Get password recovery question's answer.
	 * @return
	 */
	public String getPasswordAnswer() {
		return passwordAnswer;
	}

	/**
	 * Set password recovery question's answer.
	 * @param passwordAnswer
	 */
	public void setPasswordAnswer(String passwordAnswer) {
		this.passwordAnswer = passwordAnswer;
	}

	/**
	 * Get creation date and time.
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * Set creation date and time.
	 * @param createDate
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * Get last modification date and time.
	 * @return
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * Set last modification date and time.
	 * @param updateDate
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * Get last login date and time.
	 * @return
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * Set last login date and time.
	 * @param lastLoginDate
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	/**
	 * Get last activity date and time.
	 * @return
	 */
	public Date getLastActivityDate() {
		return lastActivityDate;
	}

	/**
	 * Set last activity date and time.
	 * @param lastActivityDate
	 */
	public void setLastActivityDate(Date lastActivityDate) {
		this.lastActivityDate = lastActivityDate;
	}

	/**
	 * Get whether this user is disabled by administrator. 
	 * @return
	 */
	public boolean isDisabled() {
		return isDisabled;
	}

	/**
	 * Set whether this user is disabled by administrator. 
	 * @param isDisabled
	 */
	public void setDisabled(boolean isDisabled) {
		this.isDisabled = isDisabled;
	}

	/**
	 * Get whether this user is deleted by administrator.
	 * @return
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * Set whether this user is deleted by administrator.
	 * @param isDeleted
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * Get the last login attempt date and time. 
	 * @return
	 */
	public Date getLastLoginAttemptDate() {
		return lastLoginAttemptDate;
	}

	/**
	 * Set the last login attempt date and time. 
	 * @param lastLoginAttemptDate
	 */
	public void setLastLoginAttemptDate(Date lastLoginAttemptDate) {
		this.lastLoginAttemptDate = lastLoginAttemptDate;
	}

	/**
	 * Get the login attempt counter. 
	 * @return
	 */
	public int getLoginAttemptionCount() {
		return loginAttemptionCount;
	}

	/**
	 * Set the login attempt counter. 
	 * @param loginAttemptionCount
	 */
	public void setLoginAttemptionCount(int loginAttemptionCount) {
		this.loginAttemptionCount = loginAttemptionCount;
	}

	/**
	 * Get the login key.
	 * @return
	 */
	public String getLoginKey() {
		return loginKey;
	}

	/**
	 * Set the login key.
	 * @param loginKey
	 */
	public void setLoginKey(String loginKey) {
		this.loginKey = loginKey;
	}

	public String getHeadPicB() {
		return headPicB;
	}

	public void setHeadPicB(String headPicB) {
		this.headPicB = headPicB;
	}

	public String getHeadPicS() {
		return headPicS;
	}

	public void setHeadPicS(String headPicS) {
		this.headPicS = headPicS;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	
	public int getVoLevel() {
		return voLevel;
	}

	
	public void setVoLevel(int voLevel) {
		this.voLevel = voLevel;
	}

	
	public int getVoNextLevel() {
		return voNextLevel;
	}

	
	public void setVoNextLevel(int voNextLevel) {
		this.voNextLevel = voNextLevel;
	}

	public double getVoNextLevelImg() {
		return voNextLevelImg;
	}

	public void setVoNextLevelImg(double voNextLevelImg) {
		this.voNextLevelImg = voNextLevelImg;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

}
