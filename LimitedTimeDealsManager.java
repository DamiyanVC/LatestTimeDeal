import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class LimitedTimeDealsManager {
    private Map<String, Deal> deals;
    private Map<String, String> users;

    public LimitedTimeDealsManager() {
        this.deals = new HashMap<>();
        this.users = new HashMap<>();
    }

    // create a deal
    public void createDeal(String id, String productName, double price, int maxItems, LocalDateTime startTime, LocalDateTime endTime) {
        if(deals.containsKey(id)) {
            System.out.println("Deal has already been created");
            return;
        }
        Deal deal = new Deal(id, productName, price, maxItems, startTime, endTime);
        deals.put(id,deal);
        System.out.println("Deal created successfully for :" + productName);
    }


    // claim a deal
    public void claimDeal(String userId, String dealID) {
        Deal deal = deals.get(dealID);

        if (deal==null) {
            System.out.println("Deal does not exist");
            return;
        }

        if (LocalDateTime.now().isBefore(deal.getStartTime())) {
            System.out.println("Wait for the deal to start");
            return;
        }

        if (LocalDateTime.now().isAfter(deal.getEndTime())) {
            System.out.println("Sorry, the Deal is already over");
            return;
        }

        if (deal.getItemsSold() > deal.getMaxItems()) {
            System.out.println("Sorry, all the Items for this deal have been claimed");
            return;
        }

        if (users.containsKey(userId)) {
            System.out.println("Sorry, " + userId + " You can only claim the deal once");
            return;
        }

        boolean dealClaimed = deal.claimItem();
        if (dealClaimed) {
            if (!users.containsKey(userId)) {
                users.put(userId, dealID);
                System.out.println("Wohoo! " + userId + " You have successfully claimed the deal for :" + deal.getProductName());
            }
        } else {
            System.out.println("Sorry, You can only claim the deal once");
        }
    }

    //update deal
    public void updateDeal(String id, UpdateDealParams updateDealParams) {
        Deal deal = deals.get(id);

        if (deal==null) {
            System.out.println("Deal does not exist");
            return;
        }

        if (updateDealParams.getNewMaxItems() > 0) {
            deal.setMaxItems(updateDealParams.getNewMaxItems());
        }

        if (updateDealParams.getNewEndTime()!=null) {
            deal.setEndTime(updateDealParams.getNewEndTime());
        }

        System.out.println("Deal updated successfully for :" + deal.getProductName());
    }
}
