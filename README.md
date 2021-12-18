# Project Title

Auto-bid auction system

## Getting Started

git clone https://github.com/denissouzasantos/auto-bid-auction-system.git

cd auto-bid-auction-system

mvn spring-boot:run

### Pre-requisites

What things you need to install the software and how to install them

```
Java 11 or later
Maven
```

## Running the tests

```
mvn test
```

### Scenarios tests


```
## Scenarios
The following table includes test data you should use to test your solution.  Bidders are listed in the order they entered their information on the site. Should there be a tie between two or more bidders, the first person that entered their information wins. The amount of the winner's bidDTO should be the lowest amount possible while observing all the previous rules.
| Bidder           | Auction One: Skates | Auction Two: Unicycle | Auction Three: Hover Board |
|------------------|---------------------:|---------------------:|--------------------:|
| __Alicia__       |                      |                      |                     |
| Starting Bid     | $50.00               | $700.00              | $2,500              |
| Max Bid          | $80.00               | $725.00              | $3,000              |
| Increment amount | $3.00                | $2.00                | $500                |
| __Olivia__       |                      |                      |                     |
| Starting Bid     | $60.00               | $599.00              | $2,800              |
| Max Bid          | $82.00               | $725.00              | $3,100              |
| Increment amount | $2.00                | $15.00               | $201                |
| __Mason__        |                      |                      |                     |
| Starting Bid     | $55.00               | $625.00              | $2,501              |
| Max Bid          | $85.00               | $725.00              | $3,200              |
| Increment amount | $5.00                | $8.00                | $247                |
|                  |                      |                      |                     |
|                  |                      |                      |                     |
| __Winner__       | Mason                | Alicia               | Olivia              |
| __Winning Amt__  | $85.00               | $722.00              | $3001.00            |
```


