import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Deals deals = new Deals();
        String dealId = "deal1";
        Deal deal = new Deal(dealId, "IphoneX", 999.99, 10, LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
        Map<String, Deal> dealMap = new HashMap<>();
        dealMap.put(dealId,deal);
        deals.setDeals(dealMap);

        CreateDeal createDeal = new CreateDeal(deals);

        LimitedTimeDealsManager limitedTimeDeals = new LimitedTimeDealsManager();
        limitedTimeDeals.createDeal("deal1", "IphoneX", 999.99, 10, LocalDateTime.now().plusSeconds(1), LocalDateTime.now().plusHours(2));

//        limitedTimeDeals.createDeal("deal2", "Mac", 1100.99, 1000, LocalDateTime.now().plusHours(3));
//
//        limitedTimeDeals.createDeal("deal1", "Phone", 999.99, 100, LocalDateTime.now().plusHours(2));

        limitedTimeDeals.claimDeal("user1", "deal1");
        Thread.sleep(2000);
        UpdateDealParams updateDealParams = new UpdateDealParams();
        updateDealParams.setNewMaxItems(1);
        limitedTimeDeals.updateDeal("deal1", updateDealParams);
        limitedTimeDeals.claimDeal("user2", "deal1");
        limitedTimeDeals.claimDeal("user3", "deal1");
    }
}