package com.autobidauction;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class BidServiceTest {

    @InjectMocks
    BidService bidService;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Bidder bidder1 = new Bidder();
        bidder1.setName("Alicia");
        bidder1.setBid(Bid.builder()
                        .startingBid(new BigDecimal(50))
                        .maxBid(new BigDecimal(80))
                        .incrementAmount(new BigDecimal(3))
                .build());
        bidder1.setAuction(Auction.builder()
                        .item("Skates")
                .build());

        Bidder bidder2 = new Bidder();
        bidder2.setName("Olivia");
        bidder2.setBid(Bid.builder()
                .startingBid(new BigDecimal(60))
                .maxBid(new BigDecimal(82))
                .incrementAmount(new BigDecimal(2))
                .build());
        bidder2.setAuction(Auction.builder()
                .item("Skates")
                .build());

        Bidder bidder3 = new Bidder();
        bidder3.setName("Alicia");
        bidder3.setBid(Bid.builder()
                .startingBid(new BigDecimal(50))
                .maxBid(new BigDecimal(80))
                .incrementAmount(new BigDecimal(3))
                .build());
        bidder3.setAuction(Auction.builder()
                .item("Skates")
                .build());
    }

    @Test
    public void getWinner() {

        bidService.getWinner();
    }
}