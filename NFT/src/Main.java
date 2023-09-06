import com.nft.service.NFTExchange;
import com.nft.service.impl.NFTExchangeServiceImpl;

/**
 * Test Case 1: Sell the NFT created
 * 1. create_exchange( )
 * 2. create_artist(name = "A", initial flipcoin in wallet = 1000)
 * 3. create_user(name = "B", initial flipcoin in wallet = 2000)
 * 4. create_NFT(id of artist = “A”, artwork = "Temp Art Work", royalty = 5% )
 * i. output : NFT created successfully
 * 5. place_sell_order(id of seller = “A”, selling price = 1000, NFT_id) <- This is placing the order for
 * sell, not successfully selling the NFT
 * i. Output : NFT successfully listed for sale
 * 6. buy_NFT(id of buyer = “B”, buying price = 1000, NFT_id) <- This is buying the NFT, which is
 * listed for sale.
 * i. Output: NFT successfully bought
 * 7. list_all_users()
 * i. output
 * 1. Exchange , flipcoin = 300
 * 2. Id = “A”, flipcoin = 1850
 * 3. Id = “B”, flipcoin = 850
 * 8. Explanation for above
 * i.
 * E( 0 ) A, artist ( 1000 ) B, buyer ( 2000 ) Comment
 * 100 -100 Registration
 * 200 -100 -100 Commission on
 * sell
 * 50 -50 Royalty
 * 1000 -1000 Selling price
 * 9. place_sell_order(id of seller = “B”, selling price = 2000, NFT_id = 1 ) <- This is placing the order
 * for sell, not successfully selling the NFT
 * i. Output : NFT successfully listed for sale
 * 10. list_all_NFT()
 * i.
 * NFT ID Artist Art Selling Price
 * 1 A Temp Art Work 2000
 * 11. create_user(name = "C", initial flipcoin in wallet = 4000)
 * 12. buy_NFT(id of buyer = “C”, buying price = 2000, NFT_Id = 1)
 * i. Output: NFT successfully bought
 * 13. list_all_users()
 * i. output
 * 1. Exchange, flipcoin = 700
 * 2. Id = “A”, flipcoin = 1950
 * 3. Id = “B”, flipcoin = 2650
 * 4. Id = “C”, flipcoin = 1700
 */
public class Main {
    public static void main(String[] args) {
        NFTExchange nftExchange = new NFTExchangeServiceImpl();

        nftExchange.createArtist("A", 1000.0);
        nftExchange.createUser("B", 2000.0);

        nftExchange.createNFT("Temp Art Work","A", 5.0);

//        5. place_sell_order(id of seller = “A”, selling price = 1000, NFT_id) <- This is placing the order for
// * sell, not successfully selling the NFT
// * i. Output : NFT successfully listed for sale
//                * 6. buy_NFT(id of buyer = “B”, buying price = 1000, NFT_id) <- This is buying the NFT, which is
//                * listed for sale.
//                * i. Output: NFT successfully bought
//                * 7. list_all_users()


        nftExchange.placeSellOrder("Temp Art Work", 1000.0);
        nftExchange.placeBuyOrder("Temp Art Work", "B",1000.0 );

        nftExchange.listAllUser();
        //place_sell_order(id of seller = “A”, selling price = 1000, NFT_id) <- This is placing the order for

        //9
        nftExchange.placeSellOrder("Temp Art Work", 2000.0);

        //10
        nftExchange.listAllNFTs();

        //11
        nftExchange.createUser("C", 4000.0);

        //12
        nftExchange.placeBuyOrder("Temp Art Work", "C", 2000.0);

        System.out.println("           ");
        nftExchange.listAllUser();

        System.out.println("Hello world!");
    }
}