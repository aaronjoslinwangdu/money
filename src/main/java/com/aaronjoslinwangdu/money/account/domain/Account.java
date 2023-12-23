package com.aaronjoslinwangdu.money.account.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "dbky")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_dbky_seq")
	@SequenceGenerator(sequenceName = "account_dbky_seq", allocationSize = 1, name = "account_dbky_seq")
	private Long dbky;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "location")
	private String location;
	
}
