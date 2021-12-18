package com.autobidauction.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@EqualsAndHashCode
@ToString
public class WinnerAuctionDTO {

    /**
     * The winner bidder name
     */
    private String bidder;
    /**
     * The winner bid value
     */
    private BigDecimal winnerBid;
    /**
     * The item name of auction
     */
    private String auction;

}
