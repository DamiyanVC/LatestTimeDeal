import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class ClaimDeal extends  Deals {

    private Deals deals;
    private Map<String, String> users;

    public ClaimDeal(Deals deals) {
        this.deals = deals;
        this.users = new HashMap<>();
    }

    public void claimDeal(String userId, String dealID) {
        Deal deal = deals.getDeals().get(dealID);

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
}
