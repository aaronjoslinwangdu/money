package com.aaronjoslinwangdu.money.payment.dto;

import com.aaronjoslinwangdu.money.common.dto.AbstractDTOAttributes;
import lombok.*;


import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PaymentDTO extends AbstractDTOAttributes implements Serializable {

    @Serial
    private static final long serialVersionUID = 1214131412515512L;

    private Long id;

    private Long paymentTypeId;

    private Long accountId;

    private BigDecimal amount;

}
