package com.aaronjoslinwangdu.money.payment.rest;

import com.aaronjoslinwangdu.money.payment.dto.PaymentDTO;
import com.aaronjoslinwangdu.money.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(path = "/{accountId}")
    public @ResponseBody List<PaymentDTO> getAllPaymentsByAccountId(@PathVariable(name = "accountId") Long accountId) {
        return paymentService.getPaymentsByAccountId(accountId);
    }

    @PostMapping(path = "/")
    public void addPayment(@RequestBody PaymentDTO request) {
        paymentService.addPayment(request);
    }
}
