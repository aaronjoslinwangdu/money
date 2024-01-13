package com.aaronjoslinwangdu.money.common.dto;

import java.time.LocalDateTime;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class AbstractDTOAttributes {

	private String createdBy;
	
	private LocalDateTime createdOn;
	
	private String modifiedBy;
	
	private LocalDateTime modifiedOn;
	
	private String requestedBy;
	
}
