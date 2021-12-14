package com.autobidauction;


import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Builder
public class Bid {

    private BigDecimal startingBid;
    private BigDecimal maxBid;
    private BigDecimal incrementAmount;
}
