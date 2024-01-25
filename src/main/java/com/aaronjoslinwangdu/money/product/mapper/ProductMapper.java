package com.aaronjoslinwangdu.money.product.mapper;

import java.io.Serializable;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.aaronjoslinwangdu.money.account.domain.Account;
import com.aaronjoslinwangdu.money.account.dto.AccountDTO;
import com.aaronjoslinwangdu.money.product.domain.Product;
import com.aaronjoslinwangdu.money.product.dto.ProductDTO;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	
	/**
	 * Convert Product Domain Object to DTO
	 * 
	 * @param product
	 * @return
	 */
	@Mappings({
		@Mapping(source = "dbky", target = "id")
	})
	ProductDTO convertSalesOrderDomainToDto(Product product);
	
	
	/**
	 * Updates fields from Product DTO to Entity
	 * 
	 * @param request
	 * @param account
	 */
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
	void updateValuesToAccountEntity(ProductDTO request, @MappingTarget Product product);
	
}
