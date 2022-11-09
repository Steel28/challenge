package nuchallange.model;

public final class AccountData implements Data {
    private final boolean active;
    private final int available;

    public AccountData(boolean active, int available) {
        this.active = active;
        this.available = available;
    }

    public AccountData(AccountData accountData) {
        this.active = accountData.isActive();
        this.available = accountData.getAvailable();
    }

    public boolean isActive() {
        return active;
    }

    public int getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "AccountData{" +
                "active=" + active +
                ", available=" + available +
                '}';
    }
}
