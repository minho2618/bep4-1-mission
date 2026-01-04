package com.back.shared.payout.event;

import com.back.shared.payout.dto.PayoutMemberDto;
import com.back.standard.event.HasEventName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PayoutMemberCreatedEvent implements HasEventName {
    private final PayoutMemberDto payoutMember;
}
