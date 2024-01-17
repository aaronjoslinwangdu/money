package com.aaronjoslinwangdu.money.product.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.aaronjoslinwangdu.money.common.dto.AbstractDTOAttributes;

public class ProductDTO extends AbstractDTOAttributes implements Serializable {

	private static final long serialVersionUID = 4L;
	
	private Long id;
	
	private Long productType;
	
	private String name;
	
	private String description;
	
	private BigDecimal price;
	
}
