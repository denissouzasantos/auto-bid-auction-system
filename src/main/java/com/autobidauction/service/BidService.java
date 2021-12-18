package com.autobidauction.service;

import com.autobidauction.dto.BidDTO;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Setter
@Service
public class BidService {

    @Autowired
    private AuctionService auctionService;


    /**
     * The method add a bid to an auction
     * @param bidDTO of auction
     */
    public void addBid(BidDTO bidDTO){
       this.auctionService.addBidToAuction(bidDTO);
    }



}
