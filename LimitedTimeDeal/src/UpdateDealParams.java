import java.time.LocalDateTime;

public class UpdateDealParams {
    private int newMaxItems;
    private LocalDateTime newEndTime;

    public UpdateDealParams() {
        this.newMaxItems = 0;
    }

    public int getNewMaxItems() {
        return newMaxItems;
    }

    public void setNewMaxItems(int newMaxItems) {
        this.newMaxItems = newMaxItems;
    }

    public LocalDateTime getNewEndTime() {
        return newEndTime;
    }

    public void setNewEndTime(LocalDateTime newEndTime) {
        this.newEndTime = newEndTime;
    }
}
