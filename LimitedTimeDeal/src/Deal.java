import java.time.LocalDateTime;

public class Deal {
    private String id;
    private String productName;
    private double price;

    private int itemsSold;
    private int maxItems;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Deal(String id, String productName, double price, int maxItems, LocalDateTime startTime, LocalDateTime endTime) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.maxItems = maxItems;
        this.startTime = startTime;
        this.endTime = endTime;
        this.itemsSold = 0;
    }

    public int getItemsSold() {
        return itemsSold;
    }

    public void setItemsSold(int itemsSold) {
        this.itemsSold = itemsSold;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean claimItem() {
        if (itemsSold <= maxItems) {
            itemsSold++;
            return true;
        }
        return false;
    }
}
