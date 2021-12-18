package com.autobidauction.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class BidderDTO implements Serializable {

    /**
     * name of bidder
     */
    private String name;

}
