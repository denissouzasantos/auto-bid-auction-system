package com.autobidauction.controller;

import com.autobidauction.dto.BidDTO;
import com.autobidauction.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bid")
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveBid(@RequestBody BidDTO request){
        this.bidService.addBid(request);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
