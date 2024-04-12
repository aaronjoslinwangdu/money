package com.aaronjoslinwangdu.money.account.dto;

import java.io.Serializable;

import com.aaronjoslinwangdu.money.common.dto.AbstractDTOAttributes;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AccountDTO extends AbstractDTOAttributes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String email;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String location;
	
}
