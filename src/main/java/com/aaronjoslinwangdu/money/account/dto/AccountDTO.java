package com.aaronjoslinwangdu.money.account.dto;

import java.io.Serializable;

import com.aaronjoslinwangdu.money.common.dto.AbstractDTOAttributes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO extends AbstractDTOAttributes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String location;
	
}
