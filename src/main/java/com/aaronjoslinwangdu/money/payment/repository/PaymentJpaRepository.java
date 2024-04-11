package com.aaronjoslinwangdu.money.payment.repository;

import com.aaronjoslinwangdu.money.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long>, JpaSpecificationExecutor<Payment>{

    List<Payment> findAllByAccountDbky(Long accountDbky);
}
