package com.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="policy")
public class Policy {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int policy_id;
	private String policy_name;
	private String policy_status;
	private String policy_amount;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;

	public int getPolicy_id() {
		return policy_id;
	}

	public void setPolicy_id(int policy_id) {
		this.policy_id = policy_id;
	}

	public String getPolicy_name() {
		return policy_name;
	}

	public void setPolicy_name(String policy_name) {
		this.policy_name = policy_name;
	}

	public String getPolicy_status() {
		return policy_status;
	}

	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}

	public String getPolicy_amount() {
		return policy_amount;
	}

	public void setPolicy_amount(String policy_amount) {
		this.policy_amount = policy_amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Policy(String policy_name, String policy_status, String policy_amount, Customer customer) {
		super();
		this.policy_name = policy_name;
		this.policy_status = policy_status;
		this.policy_amount = policy_amount;
		this.customer = customer;
	}

	
	

}
