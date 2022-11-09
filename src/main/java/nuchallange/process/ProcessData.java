package nuchallange.process;

import nuchallange.model.AccountData;
import nuchallange.model.ResponseState;
import nuchallange.model.TransactionData;

public class ProcessData {

    private AccountData globalState;

    public ProcessData(AccountData globalState) {
        this.globalState = globalState;
    }

    public  ResponseState handleData(AccountData accountData){
        if(globalState != null) {
            ResponseState responseState = new ResponseState(globalState);
            responseState.addViolation("account-already-initialized");
            return responseState;
        }
        if(globalState == null && !accountData.isActive()) {
            ResponseState responseState = new ResponseState(globalState);
            responseState.addViolation("account-not-active");
            return responseState;
        }
        globalState = new AccountData(accountData);
        return new ResponseState(accountData);
    }

    public  ResponseState handleData( TransactionData transactionData){
        if(globalState == null) {
            ResponseState responseState = new ResponseState(globalState);
            responseState.addViolation("account-not-initialized");
            return responseState;
        }
        if(globalState.getAvailable() < transactionData.getAmount()){
            ResponseState responseState = new ResponseState(globalState);
            responseState.addViolation("insufficient-limit");
            return responseState;
        }
        globalState = new AccountData(globalState.isActive(),
                globalState.getAvailable()-transactionData.getAmount());
        return new ResponseState(globalState);
    }
}
