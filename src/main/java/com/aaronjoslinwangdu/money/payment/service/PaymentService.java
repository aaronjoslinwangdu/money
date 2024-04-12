package com.aaronjoslinwangdu.money.payment.service;

import com.aaronjoslinwangdu.money.payment.domain.Payment;
import com.aaronjoslinwangdu.money.payment.dto.PaymentDTO;
import com.aaronjoslinwangdu.money.payment.mapper.PaymentMapper;
import com.aaronjoslinwangdu.money.payment.repository.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentService {

    @Autowired
    private final PaymentJpaRepository paymentJpaRepository;

    private final PaymentMapper paymentMapper;


    public List<PaymentDTO> getPaymentsByAccountId(Long accountId) {
        List<Payment> payments =  paymentJpaRepository.findAllByAccountDbky(accountId);
        return payments.stream().map(paymentMapper::domainToDTO).collect(Collectors.toList());
    }

    public void addPayment(PaymentDTO request) {
        Payment payment;
        payment = Payment.builder()
                .paymentTypeDbky(request.getPaymentTypeId())
                .accountDbky(request.getAccountId())
                .amount(request.getAmount())
                .build();
        payment.setPrincipal(request.getCreatedBy());
        paymentJpaRepository.save(payment);
    }

}
