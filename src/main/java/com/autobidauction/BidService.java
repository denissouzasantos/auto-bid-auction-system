package com.autobidauction;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@ToString
@Service
public class BidService {

    private Map<Auction, Map<String, Bid>> auctionMap = new LinkedHashMap<>();

    public void addBidToAuction(Bidder bidder){
        Map<String, Bid> bidMap = new LinkedHashMap<>();
        bidMap.put(bidder.getName(), bidder.getBid());
        auctionMap.put(bidder.getAuction(), bidMap);
    }

    public List<WinnerBid> getWinner(){
        List<WinnerBid> result = new ArrayList<>();

        this.auctionMap.forEach((k, v) -> {
            WinnerBid winnerBid  = new WinnerBid();
            winnerBid.setAuction(k.getItem());

            winnerBid = findWinnerBid(v, winnerBid);
            result.add(winnerBid);
            System.out.println("key: " + k + " Value: " + v);
        });

        return result;
    }

    private WinnerBid findWinnerBid(Map<String, Bid> bids, WinnerBid winnerBid){

        bids.forEach((bidder, bid) -> {
            if(winnerBid.getWinnerBid() == null){
                winnerBid.setBidder(bidder);
                winnerBid.setWinnerBid(bid.getStartingBid());
            }else{
                if(winnerBid.getBidder().equals(bidder)){
                    return;
                }
                int result = (bid.getStartingBid().add(bid.getIncrementAmount())).compareTo(bid.getMaxBid());
                if(result <= 0 ){

                    if((bid.getStartingBid().compareTo(winnerBid.getWinnerBid()) == 1)){
                        winnerBid.setWinnerBid(bid.getStartingBid());
                        winnerBid.setBidder(bidder);
                    }
                }

            }
        });

      boolean exist =  bids.values().stream().anyMatch( bid -> {
          int result =  bid.getMaxBid().compareTo(bid.getStartingBid());
            return result == 1;
          });

      if(exist){
          findWinnerBid(bids, winnerBid);
      }

        return winnerBid;
    }


}
