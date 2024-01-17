package com.aaronjoslinwangdu.money.account.mapper;

import java.io.Serializable;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.dto.AccountDTO;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	
	/**
	 * Convert Account Domain Object to DTO
	 * 
	 * @param account
	 * @return
	 */
	@Mappings({
		@Mapping(source = "dbky", target = "id")
	})
	AccountDTO convertSalesOrderDomainToDto(Account account);
	
	
	/**
	 * Updates fields from Account DTO to Entity
	 * 
	 * @param request
	 * @param account
	 */
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
	void updateValuesToAccountEntity(AccountDTO request, @MappingTarget Account account);
	
}
