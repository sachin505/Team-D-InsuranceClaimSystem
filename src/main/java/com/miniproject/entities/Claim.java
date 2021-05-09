package com.miniproject.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="claim")
public class Claim {
	
	@Id
	private int  claimNumber;
	private String claimReason;
	private String accidentLocationStreet;
	private String accidentCity;
	private String accidentState;
	private int accidentZip;
	private String claimType;
	private int policyNumber;
	
	public Claim() {
		
	}
	
	public Claim(int claimNumber, String claimReason, String accidentLocationStreet, String accidentCity,
			String accidentState, int accidentZip, String claimType, int policyNumber) {
		this.claimNumber = claimNumber;
		this.claimReason = claimReason;
		this.accidentLocationStreet = accidentLocationStreet;
		this.accidentCity = accidentCity;
		this.accidentState = accidentState;
		this.accidentZip = accidentZip;
		this.claimType = claimType;
		this.policyNumber = policyNumber;
	}
	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", claimReason=" + claimReason + ", accidentLocation="
				+ accidentLocationStreet + ", accidentCity=" + accidentCity + ", accidentState=" + accidentState
				+ ", accidentZip=" + accidentZip + ", claimType=" + claimType + ", policyNumber=" + policyNumber + "]";
	}
	public int getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(int claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getClaimReason() {
		return claimReason;
	}
	public void setClaimReason(String claimReason) {
		this.claimReason = claimReason;
	}
	public String getAccidentLocation() {
		return accidentLocationStreet;
	}
	public void setAccidentLocation(String accidentLocation) {
		this.accidentLocationStreet = accidentLocation;
	}
	public String getAccidentCity() {
		return accidentCity;
	}
	public void setAccidentCity(String accidentCity) {
		this.accidentCity = accidentCity;
	}
	public String getAccidentState() {
		return accidentState;
	}
	public void setAccidentState(String accidentState) {
		this.accidentState = accidentState;
	}
	public int getAccidentZip() {
		return accidentZip;
	}
	public void setAccidentZip(int accidentZip) {
		this.accidentZip = accidentZip;
	}
	public String getClaimType() {
		return claimType;
	}
	public void setClaimType(String claimType) {
		this.claimType = claimType;
	}
	public int getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(int policyNumber) {
		this.policyNumber = policyNumber;
	}
	
}
