package com.aaronjoslinwangdu.money.payment.domain;

import com.aaronjoslinwangdu.money.common.domain.AbstractDomainAttributes;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "payment")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Payment extends AbstractDomainAttributes implements Serializable {

    @Serial
    private static final long serialVersionUID = 1123131412455L;

    @Id
    @Column(name = "dbky")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_dbky_seq")
    @SequenceGenerator(sequenceName = "payment_dbky_seq", allocationSize = 1, name = "payment_dbky_seq")
    private Long dbky;

    @Column(name = "payment_type_dbky")
    private Long paymentTypeDbky;

    @Column(name = "account_dbky")
    private Long accountDbky;

    @Column(name = "amount")
    private BigDecimal amount;

}
