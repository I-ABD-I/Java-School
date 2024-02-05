package dataStructs.queue.stadium;

public class Menagment {
    public Cashery[] casheries = new Cashery[13];

    public boolean addBuyer(Buyer b) {
        Cashery min = this.casheries[0];
        for (Cashery cashery : this.casheries) {
            if (cashery.getWaits() < min.getWaits()) {
                min = cashery;
            }
        }

        if (!min.isAvailable(b.getNumOfTikets())) {
            return false;
        }

        min.addBuyer(b);
        return true;
    }
}
