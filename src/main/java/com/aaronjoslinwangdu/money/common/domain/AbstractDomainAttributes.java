package com.aaronjoslinwangdu.money.common.domain;

import java.time.DateTimeException;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import lombok.Data;
import lombok.experimental.SuperBuilder;

/**
 * This class is used to generate audit data.
 */
@Data
@MappedSuperclass
public class AbstractDomainAttributes {

	@Column(name = "created_by", updatable = false)
	private String createdBy;
	
	@Column(name = "created_on", updatable = false)
	private LocalDateTime createdOn;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	
	@Column(name = "modified_on")
	private LocalDateTime modifiedOn;
	
	
	/**
	 * On create method
	 */
	@PrePersist
	public void onCreate() {
		try {
			modifiedOn = createdOn = LocalDateTime.now();
		} catch (DateTimeException e) {
			modifiedOn = createdOn = null;
		}
		
		createdBy = modifiedBy = principal;
	}
	
	
	/**
	 * On update method
	 */
	@PreUpdate
	public void onUpdate() {
		try {
			modifiedOn = LocalDateTime.now();
		} catch (DateTimeException e) {
			modifiedOn = null;
		}
		
		modifiedBy = principal;
	}
	
	
	@Transient
	private String principal;
	
}
