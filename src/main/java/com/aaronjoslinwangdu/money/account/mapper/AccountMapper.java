package com.aaronjoslinwangdu.money.account.mapper;

import java.io.Serializable;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.dto.AccountDTO;

@Mapper(componentModel = "spring")
public interface AccountMapper {
	
	@Mappings({
		@Mapping(source = "dbky", target = "id")
	})
	AccountDTO convertSalesOrderDomainToDto(Account account);
	
}
