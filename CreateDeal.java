import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class CreateDeal extends  Deals {

    private Deals deals;

    public CreateDeal(Deals deals) {
        this.deals = deals;
    }

    public void createDeal(String id, String productName, double price, int maxItems, LocalDateTime startTime, LocalDateTime endTime) {
        if(deals.getDeals().containsKey(id)) {
            System.out.println("Deal has already been created");
            return;
        }
        Deal deal = new Deal(id, productName, price, maxItems, startTime, endTime);
        Map <String, Deal> dealMap = new HashMap<>();
        dealMap.put(id, deal);
        deals.setDeals(dealMap);
        System.out.println("Deal created successfully for :" + productName);
    }
}
