package com.app.messdeck.model.dto;

import com.app.messdeck.entity.EmailID;
import com.app.messdeck.entity.Gender;
import com.app.messdeck.entity.Name;

import net.sf.oval.constraint.MatchPattern;

public class PersonDTO {

	private Name name;

	@MatchPattern(pattern = "^[789]\\d{9}$",message="Invalid Mobile Number:Number should start with 7,8 or 9 & must be 10 digits")
	private String mobileNo;

	private EmailID emailID;
	private Gender gender;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public EmailID getEmailID() {
		return emailID;
	}

	public void setEmailID(EmailID emailID) {
		this.emailID = emailID;
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emailID == null) ? 0 : emailID.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDTO other = (PersonDTO) obj;
		if (emailID == null) {
			if (other.emailID != null)
				return false;
		} else if (!emailID.equals(other.emailID))
			return false;
		return true;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", mobileNo=" + mobileNo + ", emailID=" + emailID + ", gender=" + gender + "]";
	}
}
