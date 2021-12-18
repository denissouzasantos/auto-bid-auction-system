package com.autobidauction.service;

import com.autobidauction.dto.AuctionDTO;
import com.autobidauction.dto.BidDTO;
import com.autobidauction.dto.WinnerAuctionDTO;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Setter
@Service
public class AuctionService {

    private Map<AuctionDTO, List<BidDTO>> auctions = new LinkedHashMap<>();

    /**
     * The method either adds a bid to the existing auction or creates an auction and adds the bid.
     * @param bidDTO of auction
     */
    public void addBidToAuction(BidDTO bidDTO){
        List<BidDTO> bidDTOS = new ArrayList<>();
        if(auctions.containsKey(bidDTO.getAuctionDTO())){
            bidDTOS = auctions.get(bidDTO.getAuctionDTO());
            bidDTOS.add(bidDTO);
            auctions.put(bidDTO.getAuctionDTO(), bidDTOS);
        }else {
            bidDTOS.add(bidDTO);
            auctions.put(bidDTO.getAuctionDTO(), bidDTOS);
        }
    }

    /**
     * The method find all winner of auctions informed
     * @return a list of winner bid the each auction
     */
    public List<WinnerAuctionDTO> getWinnerAuction(){
        List<WinnerAuctionDTO> result = new ArrayList<>();

        this.auctions.forEach((k, v) -> {
            v.forEach(System.out::println);
            BidDTO winnerBidDTO = findWinnerBidRound(v);
            System.out.println("winner bid: " + winnerBidDTO);
            WinnerAuctionDTO winnerAcution = new WinnerAuctionDTO();
            winnerAcution.setWinnerBid(winnerBidDTO.getStartingBid());
            winnerAcution.setBidder(winnerBidDTO.getBidderDTO().getName());
            winnerAcution.setAuction(winnerBidDTO.getAuctionDTO().getItem());
            result.add(winnerAcution);
        });

        return result;
    }

    /**
     * The method finding the winner bid of
     * @param bidDTOS List of bid
     * @return the winner bid of round
     */
    private BidDTO findWinnerBidRound(List<BidDTO> bidDTOS){
        BidDTO winnerBidDTORound = bidDTOS.stream()
                .max(Comparator.comparing(BidDTO::getStartingBid))
                .orElseThrow(NoSuchElementException::new);

        System.out.println("Winner: " + winnerBidDTORound);

        /** try finding there is anyone can be increment current bid*/
        boolean isThereIncrementAmount =  bidDTOS.stream().filter(b -> !b.equals(winnerBidDTORound))
                .anyMatch( bid -> {
                    int maxBidExceed =  bid.getMaxBid().compareTo(bid.getStartingBid().add(bid.getIncrementAmount()));
                    if(maxBidExceed >= 0)
                        return true;
                    else
                        return false;
                });

        /** check there is increment amount*/
        if(isThereIncrementAmount){
            List<BidDTO> bidDTOList = bidDTOS.stream()
                    .map( row -> {
                        if(!row.equals(winnerBidDTORound)){
                            int maxBidExceed =  row.getMaxBid().compareTo(row.getStartingBid().add(row.getIncrementAmount()));
                            if(maxBidExceed >= 0)
                                row.setStartingBid(row.getStartingBid().add(row.getIncrementAmount()));
                            return row;
                        }else
                            return row;
                    })
                    .collect(Collectors.toList());

            return findWinnerBidRound(bidDTOList);
        }

        return winnerBidDTORound;
    }

}
