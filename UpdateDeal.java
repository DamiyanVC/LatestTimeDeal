import java.util.Map;

public class UpdateDeal extends  Deals {

    private Deals deals;

    public UpdateDeal(Deals deals) {
        this.deals = deals;
    }

    public void updateDeal(String id, UpdateDealParams updateDealParams) {
        Deal deal = deals.getDeals().get(id);

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
