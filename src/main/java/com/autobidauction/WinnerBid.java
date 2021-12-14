package com.autobidauction;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class WinnerBid {

    private String bidder;
    private BigDecimal winnerBid;
    private String auction;

}
