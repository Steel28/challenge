package nuchallange.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseState {
    private AccountData accountData;
    private List<String> violations = new ArrayList<>();

    public ResponseState() {

    }

    public ResponseState(AccountData accountData) {
        this.accountData = accountData;
    }

    public void addViolation(String violation){
        violations.add(violation);
    }

    public AccountData getAccountData() {
        return accountData;
    }

    public List<String> getViolations() {
        return new ArrayList<>(violations);
    }

    @Override
    public String toString() {
        return "ResponseState{" +
                "accountData=" + accountData +
                ", violations=" + violations +
                '}';
    }
}
