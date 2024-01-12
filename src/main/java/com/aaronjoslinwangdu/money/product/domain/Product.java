package com.aaronjoslinwangdu.money.product.domain;

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
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Product implements Serializable {

	private static final long serialVersionUID = 2L;
	
	@Id
	@Column(name = "dbky")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_dbky_seq")
	@SequenceGenerator(sequenceName = "account_dbky_seq", allocationSize = 1, name = "account_dbky_seq")
	private Long dbky;
	
	@Column(name = "product_type_dbky")
	private String productType;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "price")
	private String price;
	
}
