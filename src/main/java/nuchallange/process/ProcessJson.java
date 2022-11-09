package nuchallange.process;

import com.google.gson.Gson;
import nuchallange.model.AccountData;
import nuchallange.model.ResponseState;
import nuchallange.model.TransactionData;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ProcessJson {

    private final Gson gson;
    private final JSONParser parser;

    private final ProcessData processData;

    public ProcessJson(Gson gson, JSONParser parser, ProcessData processData) {
        this.gson = gson;
        this.parser = parser;
        this.processData = processData;
    }

    public ResponseState handleJson(String s) throws ParseException {
        JSONObject json = (JSONObject) parser.parse(s);
        if ((json.containsKey("account"))){
            AccountData accountData = gson.fromJson(json.get("account").toString(), AccountData.class);
            return processData.handleData(accountData);
        }
        if ((json.containsKey("transaction"))){
            TransactionData transactionData = gson.fromJson(json.get("transaction").toString(), TransactionData.class);
            return  processData.handleData(transactionData);
        }
        return new ResponseState();
    }
}
