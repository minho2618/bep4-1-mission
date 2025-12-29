package com.back.shared.market.dto;

import com.back.boundedContext.market.domain.Order;
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

    public OrderDto(Order order) {
        this(
                order.getId(),
                order.getCreateDate(),
                order.getModifyDate(),
                order.getBuyer().getId(),
                order.getBuyer().getNickname(),
                order.getPrice(),
                order.getSalePrice(),
                order.getRequestPaymentDate(),
                order.getPaymentDate()
        );
    }
}
