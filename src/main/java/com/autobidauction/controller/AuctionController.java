package com.autobidauction.controller;

import com.autobidauction.dto.WinnerAuctionDTO;
import com.autobidauction.service.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/auction")
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    /**
     * The endpoint retrieve all winner of auctions informed
     * @return a list of winner bid the each auction
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WinnerAuctionDTO>> getWinnerAuction(){
        return new ResponseEntity<>( this.auctionService.getWinnerAuction(), HttpStatus.OK);
    }
}
