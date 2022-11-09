package nuchallange.model;

public final class TransactionData implements Data {
    private final String merchant;
    private final int amount;
    private final String time;

    public TransactionData(String merchant, int amount, String time) {
        this.merchant = merchant;
        this.amount = amount;
        this.time = time;
    }

    public String getMerchant() {
        return merchant;
    }

    public int getAmount() {
        return amount;
    }

    public String getTime() {
        return time;
    }
}
