package com.autobidauction;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Bidder implements Serializable {

    private String name;
    private Bid bid;
    private Auction auction;

}
