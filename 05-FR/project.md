# Auction system

## Introduction

Specification of functional requirements as part of computerisation of the product sale process based on the auction mechanism.

## Business processes

---
<a id="bc1"></a>
### BC1: Auction sale

**Actors:** [Seller](#ac1), [Buyer](#ac2)

**Description:** Business process describing a sale by the auction mechanism.

**Main scenario:**
1. [Seller](#ac1) offers the product at an auction. ([UC1](#uc1))
2. [Buyer](#ac2) offers a bid for the product that is higher than the currently highest bid. ([BR1](#br1) / [UC2](#uc2))
3. [Buyer](#ac2) wins the auction ([BR2](#br2))
4. [Buyer](#ac2) transfers the amount due to the Seller. ([UC3](#uc3))
5. [Seller](#ac1) transfers the product to the Buyer. ([UC4](#uc4))

**Alternative scenarios:** 

2.A. Buyer's bid has been outbid and [Buyer](#ac2) wants to outbid the current highest bid.
* 2.A.1. Continue at step 2.

3.A. Auction time has elapsed and [Buyer](#ac2) has lost the auction. ([BR2](#br2))
* 3.A.1. End of use case.

---

## Actors

<a id="ac1"></a>
### AC1: Seller

A person offering goods at an auction.

<a id="ac2"></a>
### AC2: Buyer

A person intending to purchase a product at an auction..


## User level use cases

### Actors and their goals 

[Seller](#ac1):
* [UC1](#uc1): Offering a product at an auction
* [UC4](#uc4): Transfering item to the buyer

[Buyer](#ac2):
* [UC2](#uc2): Making a bid on a given auction
* [UC3](#uc3): Transfering money for a won auction to the seller

---
<a id="uc1"></a>
### UC1: Offering a product at an auction

**Actors:** [Seller](#ac1)

**Main scenario:**
1. [Seller](#ac1) reports to the system the willingness to offer the product up at an auction.
2. System asks for the product data and initial price.
3. [Seller](#ac1) provides product data and the initial price.
4. System verifies data correctness.
5. System informs that the product has been successfully put up for auction.

**Alternative scenarios:** 

4.A. Incorrect or incomplete product data has been entered.
* 4.A.1. informs about incorrectly entered data.
* 4.A.2. Continue at step 2.

---

<a id="uc2"></a>
### UC2: Making a bid on a given auction

**Actors:** [Buyer](#ac2)

**Main scenario:**
1. [Buyer](#ac2) selects which item he wants to bid on
2. System asks for the amount of money to bid
3. [Buyer](#ac2) provides the number
4. System checks whether that value abides by [BR1](#br1)
5. System informs that the bid has been succesffuly booked

**Alternative scenarios:** 

4.A. The amount of money is not correct
* 4.A.1. System informs about incorrectness
* 4.A.2 Continue to step 2

---

<a id="uc3"></a>
### UC3: Transfering money for a won auction to the seller

**Actors:** [Buyer](#ac2)

**Main scenario:**
1. [Buyer](#ac2) selects which item he wants to pay for
2. System checks who the seller of that item is
3. System asks for the method of payment
4. [Buyer](#ac2) chooses the desired method
5. System asks for appropriate data
6. [Buyer](#ac2) provides all the neccessary data
7. Systems checks the validity of the data
8. System adds the money to the account of previously determined seller
9. System informs the [Buyer](#ac2) that the payment has been confirmed

**Alternative scenarios:** 

2.A. Could not find the appropriate [Seller](#ac1)
* 2.A.1. System informs that the item is no longer available
* 2.A.2. End of the use case

7.A. The data provided is incorrect
* 7.A.1. System informs about incorrectness
* 7.A.2. Continue to step 5


---

## Business objects (also known as domain or IT objects)

### BO1: Auction

The auction is a form of concluding a sale and purchase transaction in which the Seller specifies the starting bid of the product, while the Buyers may offer their own purchase offer, each time proposing a bid higher than the currently offered bid. The auction ends after a specified period of time. If at least one purchase offer has been submitted, the product is purchased by the Buyer who offered the highest bid. 

### BO2: Product

A physical or digital item to be auctioned.

## Business rules

<a id="br1"></a>
### BR1: Bidding at auction

Bidding at auction requires submitting an amount higher than current by a minimum of EUR 1.00

<a id="br2"></a>
### BR2: Winning an auction

Auction is won by [Buyer](#ac2) who submitted the highest bid before the end of the auction (time expires).


## CRUDL Matrix


| Use case                                  | Auction | Product |
| ----------------------------------------- | ------- | ------- |
| UC1: Offering a product at an auction     |    C    |    C    |
| UC2: Making a bid on a given auction                                       |   RU   |   R   |
| UC3: Transfering money for a won auction to the seller| RD| R |

