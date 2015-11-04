package dk.topdanmark.bidding.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Bid {

    private Date timestamp;

    private Double amount;

    private AccountId accountId;

}
