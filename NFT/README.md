## NFT Exchange
# Problem Statement

Design an NFT exchange (Non Fungible Token Exchange) that orchestrates the sale and purchase of
NFT, using crypto currency (flipcoin) as a payment option.
An artist is considered to be a person who owns the NFT initially and creates NFT in the exchange.
The NFT artist may or may not charge a royalty on selling price for every transaction made on the
NFT, by specifying the royalty amount at the time of creation of the NFT.
Users (including artists) can come and buy/sell the NFTs on the exchange. The exchange charges a
fixed commission of 10% of the selling price (even if the buying price is higher) from both buyer as
well as seller for every transaction made on the NFT (buyer pays 10%, seller pays 10% as well). This
is deducted from their wallet, when a buy order is executed, without any explicit mention. The buyer
cannot buy NFT at less than the quoted selling price.
The NFT can be sold multiple times, post listing i.e once the NFT is bought by a user, ownership of
NFT will be transferred to the buyer. The buyer may choose to sell the same NFT again.
Capabilities expected from this system :
1. create_artist ( name, initial_money) -> This will create an artist, who can create, buy or sell
NFT.
a. ( Money can be added at the time of artist creation only )
2. create_user(name, initial_money) -> This will create a user, who can buy or sell NFT.
a. ( Money can be added at the time of user creation)
3. create_NFT(art_work, artist , royalty_in_percent) -> This will create an NFT on the exchange.
4. place_sell_order(nft_id, selling_price) -> this will list the NFT for sale on the exchange.
5. buy _NFT(nft_id, buyer_Id, buying_price) -> This will try to place the NFT purchase order, and
the order will be successful subject to conditions mentioned in the subsequent sections.
6. list_all_NFT() -> this will list all the NFTs registered with exchange.If item is not put up for sale,
selling price will not be applicable
a.
NFT ID Artist Art Selling Price
7. list_all_users() -> this should list all users along with their flipcoin balance. This should also
display the flip coin amount present with the exchange.
a.
User Id Flip coin balance
8. describe_NFT( nft_id) -> this should list the chain of possession of the NFT since creation with
the following details.
a.
NFT
Creation
date
Artist Art Date of
Transaction
Owner Selling
Price
Buying
Price
Following constraints need to be taken care while performing a transaction of the NFT during / post
registration
1. The exchange charges a creation fee for each new NFT ( say 100 flipcoins ), which needs to be
paid to the exchange, by the artist
2. The royalty should be debited from the buyer and credit to the artist, and not from the seller.
3. Exchange commission on selling price should be charged equally from both the buyer and
seller.
4. Buy orders cannot be placed if respective users don't have sufficient balance.
Expectations:
1. Make sure that you have working and demonstrable code for all the above requirements.
2. Feature requirements should be strictly followed. Work on the expected output first and then add
good-to-have features of your own.
3. Use of proper abstraction, separation of concerns is required.
4. Code should easily accommodate new requirements with minimal changes.
5. Proper exception handling is required.
6. Code should be modular, readable and unit-testable.

Important Notes:
- Do not use any database store, use in-memory data structure.
- Focus on code completion, before adding checks for edge cases.
- Do not create any UI for the application.
- Do not build a Command line interface, Executing test cases or simple Main function ●
should be sufficient
- Do not make any assumption, please ask it out.

## Test Samples ( This is for demo purposes only. Feel free to define your own methods with
required arguments.)

### Test Case 1: Sell the NFT created
1. create_exchange( )
2. create_artist(name = "A", initial flipcoin in wallet = 1000)
3. create_user(name = "B", initial flipcoin in wallet = 2000)
4. create_NFT(id of artist = “A”, artwork = "Temp Art Work", royalty = 5% )
i. output : NFT created successfully
5. place_sell_order(id of seller = “A”, selling price = 1000, NFT_id) <- This is placing the order for
sell, not successfully selling the NFT
i. Output : NFT successfully listed for sale
6. buy_NFT(id of buyer = “B”, buying price = 1000, NFT_id) <- This is buying the NFT, which is
listed for sale.
i. Output: NFT successfully bought
7. list_all_users()
i. output
1. Exchange , flipcoin = 300
2. Id = “A”, flipcoin = 1850
3. Id = “B”, flipcoin = 850
8. Explanation for above
i.
E( 0 ) A, artist ( 1000 ) B, buyer ( 2000 ) Comment
100 -100 Registration
200 -100 -100 Commission on
sell
50 -50 Royalty
1000 -1000 Selling price
9. place_sell_order(id of seller = “B”, selling price = 2000, NFT_id = 1 ) <- This is placing the order
for sell, not successfully selling the NFT
i. Output : NFT successfully listed for sale
10. list_all_NFT()
i.
NFT ID Artist Art Selling Price
1 A Temp Art Work 2000
11. create_user(name = "C", initial flipcoin in wallet = 4000)
12. buy_NFT(id of buyer = “C”, buying price = 2000, NFT_Id = 1)
i. Output: NFT successfully bought
13. list_all_users()
i. output
1. Exchange, flipcoin = 700
2. Id = “A”, flipcoin = 1950
3. Id = “B”, flipcoin = 2650
4. Id = “C”, flipcoin = 1700

### Test Case 2: Sell the NFT created
1. create_exchange( )
2. create_artist(name = "A", initial flipcoin in wallet = 1000)
3. create_user(name = "B", initial flipcoin in wallet = 1000)
4. create_NFT(id of artist = “A”,artwork = "Temp Art Work", royalty = 5% )
a. output : NFT created successfully
5. place_sell_order(id of seller = “A”, selling price = 1000, nft_id = 1) <- This is placing the order
for sell, not successfully selling the NFT
a. Output : NFT successfully listed for sale
6. buy_NFT(id of buyer = “B”, buying price = 1000, nft_id =1 ) <- This is buying the NFT, which is
listed for sale.
a. Output: Unable to buy NFT, not enough balance to pay commision
7. listAllUsers()
a. output
i. Exchange, flipcoin = 100
ii. Id = “A”, flipcoin = 900
iii. Id = “B”, flipcoin = 1000

### Test Case 3: Sell the NFT created above selling price
1. create_exchange( )
2. create_artist(name = "A", initial flipcoin in wallet = 1000)
3. create_user(name = "B", initial flipcoin in wallet = 4000)
4. create_NFT(id of artist = “A”,artwork = "Temp Art Work", royalty = 5% )
a. output : NFT created successfully
5. place_sell_order(id of seller = “A”, selling price = 1000, nft_id =1 ) <- This is placing the order for
sell, not successfully selling the NFT
a. Output : NFT successfully listed for sale
6. buy_NFT(id of buyer = “B”, buying price = 3000, nft_id =1 ) <- This is buying the NFT, which is
listed for sale.
a. Output: NFT successfully bought
7. listAllUsers()
a. output
i. Exchange, flipcoin = 300
ii. Id = “A”, flipcoin = 3950
iii. Id = “B”, flipcoin = 750
