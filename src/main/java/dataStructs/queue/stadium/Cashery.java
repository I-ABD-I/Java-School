package dataStructs.queue.stadium;

import utils.Queue;

/**
 * Cashery
 */
public class Cashery {

    @SuppressWarnings("unused")
    private int remainingTikets;
    private Queue<Buyer> buyers;

    public Cashery() {
        this.remainingTikets = 1000;
        this.buyers = new Queue<>();
    }

    public int getWaits() {
        return 0;
    }

    public void Remove() {
        this.remainingTikets -= this.buyers.remove().getNumOfTikets();
    }

    public void addBuyer(Buyer buyer) {
        this.buyers.insert(buyer);
    }

    public boolean isAvailable(int numOfTikets) {
        return false;
    }
}
