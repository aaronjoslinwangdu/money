package com.aaronjoslinwangdu.money.payment.mapper;


import com.aaronjoslinwangdu.money.payment.domain.Payment;
import com.aaronjoslinwangdu.money.payment.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    @Mappings({
            @Mapping(source = "dbky", target = "id")
    })
    PaymentDTO domainToDTO(Payment payment);

    @Mappings({
            @Mapping(source = "id", target = "dbky")
    })
    Payment dtoToDomain(PaymentDTO paymentDTO);

}