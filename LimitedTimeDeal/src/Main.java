import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws InterruptedException {

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