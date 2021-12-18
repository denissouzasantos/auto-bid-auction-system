package com.autobidauction.dto;


import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;


@Getter
@Setter
@ToString
public class BidDTO {

    /**
     * The Auction of bid
     */
    private AuctionDTO auctionDTO;
    /**
     * The Bidder of bid
     */
    private BidderDTO bidderDTO;
    /**
     * Starting bid
     */
    private BigDecimal startingBid;
    /**
     * Max bid
     */
    private BigDecimal maxBid;
    /**
     * Increment amount
     */
    private BigDecimal incrementAmount;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof BidDTO)) return false;
        BidDTO bidDTO = (BidDTO) o;
        return Objects.equals(getAuctionDTO(), bidDTO.getAuctionDTO()) && Objects.equals(getBidderDTO(), bidDTO.getBidderDTO());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuctionDTO(), getBidderDTO());
    }
}
