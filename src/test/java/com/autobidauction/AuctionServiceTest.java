package com.autobidauction;

import com.autobidauction.dto.AuctionDTO;
import com.autobidauction.dto.BidDTO;
import com.autobidauction.dto.BidderDTO;
import com.autobidauction.dto.WinnerAuctionDTO;
import com.autobidauction.service.AuctionService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AuctionServiceTest {

    private static final String SKATES = "Skates";
    private static final String BIDDER_1 = "Alicia";
    private static final String BIDDER_2 = "Olivia";
    private static final String BIDDER_3 = "Mason";

    private static final BigDecimal LASTWINNERBID = new BigDecimal("85.00");
    private static final BigDecimal FIRSTWINNERBID = new BigDecimal("722.00");
    private static final BigDecimal MIDDLEWINNERBID = new BigDecimal("3001.00");
    public static final String HOVER_BOARD = "Hover Board";
    public static final String UNICYCLE = "Unicycle";

    private Map<AuctionDTO, List<BidDTO>> auctions = new LinkedHashMap<>();
    private List<BidDTO> bidDTOS = new ArrayList<>();

    @InjectMocks
    AuctionService auctionService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getWinnerTheLastBidWinnerAuction() {
        createBidsToAuctionSkates();
        List<WinnerAuctionDTO> winnerAuctionDTOS = auctionService.getWinnerAuction();
        Assert.assertEquals(BIDDER_3, winnerAuctionDTOS.get(0).getBidder());
        Assert.assertEquals(LASTWINNERBID, winnerAuctionDTOS.get(0).getWinnerBid());
    }

    @Test
    public void getWinnerTheFirstBidWinnerAuction() {
        createBidsToAuctionUnicycle();
        List<WinnerAuctionDTO> winnerAuctionDTOS = auctionService.getWinnerAuction();
        Assert.assertEquals(BIDDER_1, winnerAuctionDTOS.get(0).getBidder());
        Assert.assertEquals(FIRSTWINNERBID, winnerAuctionDTOS.get(0).getWinnerBid());
    }

    @Test
    public void getWinnerTheMiddleBidWinnerAuction() {
        createBidsToAuctionHoverBoard();
        List<WinnerAuctionDTO> winnerAuctionDTOS = auctionService.getWinnerAuction();
        Assert.assertEquals(BIDDER_2, winnerAuctionDTOS.get(0).getBidder());
        Assert.assertEquals(MIDDLEWINNERBID, winnerAuctionDTOS.get(0).getWinnerBid());
    }



    private void createBidsToAuctionSkates() {
        AuctionDTO auctionDTO = new AuctionDTO(SKATES);
        BidderDTO bidderDTO1 = new BidderDTO(BIDDER_1);
        BidderDTO bidderDTO2 = new BidderDTO(BIDDER_2);
        BidderDTO bidderDTO3 = new BidderDTO(BIDDER_3);

        BidDTO bidDTO1 = new BidDTO();

        bidDTO1.setBidderDTO(bidderDTO1);
        bidDTO1.setStartingBid(new BigDecimal("50.00"));
        bidDTO1.setMaxBid(new BigDecimal("80.00"));
        bidDTO1.setIncrementAmount(new BigDecimal("3.00"));
        bidDTO1.setAuctionDTO(auctionDTO);

        BidDTO bidDTO2 = new BidDTO();
        bidDTO2.setBidderDTO(bidderDTO2);
        bidDTO2.setStartingBid(new BigDecimal("60.00"));
        bidDTO2.setMaxBid(new BigDecimal("82.00"));
        bidDTO2.setIncrementAmount(new BigDecimal("2.00"));
        bidDTO2.setAuctionDTO(auctionDTO);


        BidDTO bidDTO3 = new BidDTO();
        bidDTO3.setBidderDTO(bidderDTO3);
        bidDTO3.setStartingBid(new BigDecimal("55.00"));
        bidDTO3.setMaxBid(new BigDecimal("85.00"));
        bidDTO3.setIncrementAmount(new BigDecimal("5.00"));
        bidDTO3.setAuctionDTO(auctionDTO);

        bidDTOS.add(bidDTO1);
        bidDTOS.add(bidDTO2);
        bidDTOS.add(bidDTO3);
        auctions.put(auctionDTO, bidDTOS);

        this.auctionService.setAuctions(auctions);
    }


    private void createBidsToAuctionUnicycle() {
        AuctionDTO auctionDTO = new AuctionDTO(UNICYCLE);
        BidderDTO bidderDTO1 = new BidderDTO(BIDDER_1);
        BidderDTO bidderDTO2 = new BidderDTO(BIDDER_2);
        BidderDTO bidderDTO3 = new BidderDTO(BIDDER_3);

        BidDTO bidDTO1 = new BidDTO();

        bidDTO1.setBidderDTO(bidderDTO1);
        bidDTO1.setStartingBid(new BigDecimal("700.00"));
        bidDTO1.setMaxBid(new BigDecimal("725.00"));
        bidDTO1.setIncrementAmount(new BigDecimal("2.00"));
        bidDTO1.setAuctionDTO(auctionDTO);

        BidDTO bidDTO2 = new BidDTO();
        bidDTO2.setBidderDTO(bidderDTO2);
        bidDTO2.setStartingBid(new BigDecimal("599.00"));
        bidDTO2.setMaxBid(new BigDecimal("725.00"));
        bidDTO2.setIncrementAmount(new BigDecimal("15.00"));
        bidDTO2.setAuctionDTO(auctionDTO);


        BidDTO bidDTO3 = new BidDTO();
        bidDTO3.setBidderDTO(bidderDTO3);
        bidDTO3.setStartingBid(new BigDecimal("625.00"));
        bidDTO3.setMaxBid(new BigDecimal("725.00"));
        bidDTO3.setIncrementAmount(new BigDecimal("8.00"));
        bidDTO3.setAuctionDTO(auctionDTO);

        bidDTOS.add(bidDTO1);
        bidDTOS.add(bidDTO2);
        bidDTOS.add(bidDTO3);
        auctions.put(auctionDTO, bidDTOS);

        this.auctionService.setAuctions(auctions);
    }


    private void createBidsToAuctionHoverBoard() {
        AuctionDTO auctionDTO1 = new AuctionDTO(HOVER_BOARD);
        BidderDTO bidderDTO1 = new BidderDTO(BIDDER_1);
        BidderDTO bidderDTO2 = new BidderDTO(BIDDER_2);
        BidderDTO bidderDTO3 = new BidderDTO(BIDDER_3);

        BidDTO bidDTO1 = new BidDTO();

        bidDTO1.setBidderDTO(bidderDTO1);
        bidDTO1.setStartingBid(new BigDecimal("2500.00"));
        bidDTO1.setMaxBid(new BigDecimal("3000.00"));
        bidDTO1.setIncrementAmount(new BigDecimal("500.00"));
        bidDTO1.setAuctionDTO(auctionDTO1);

        BidDTO bidDTO2 = new BidDTO();
        bidDTO2.setBidderDTO(bidderDTO2);
        bidDTO2.setStartingBid(new BigDecimal("2800.00"));
        bidDTO2.setMaxBid(new BigDecimal("3100.00"));
        bidDTO2.setIncrementAmount(new BigDecimal("201.00"));
        bidDTO2.setAuctionDTO(auctionDTO1);


        BidDTO bidDTO3 = new BidDTO();
        bidDTO3.setBidderDTO(bidderDTO3);
        bidDTO3.setStartingBid(new BigDecimal("2501.00"));
        bidDTO3.setMaxBid(new BigDecimal("3200.00"));
        bidDTO3.setIncrementAmount(new BigDecimal("247.00"));
        bidDTO3.setAuctionDTO(auctionDTO1);

        bidDTOS.add(bidDTO1);
        bidDTOS.add(bidDTO2);
        bidDTOS.add(bidDTO3);
        auctions.put(auctionDTO1, bidDTOS);

        this.auctionService.setAuctions(auctions);
    }
}