package com.back.shared.market.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class OrderDto {
    private int id;
    private LocalDateTime createDate;
    private LocalDateTime modifyDate;
    private int customerId;
    private String customerName;
    private long price;
    private long salePrice;
    private LocalDateTime requestPaymentDate;
    private LocalDateTime paymentDate;
}
