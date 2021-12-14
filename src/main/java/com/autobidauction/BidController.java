package com.autobidauction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveBid(@RequestBody Bidder request){
        this.bidService.addBidToAuction(request);

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WinnerBid>> getWinner(){

        return new ResponseEntity<>( this.bidService.getWinner(), HttpStatus.OK);
    }


}
