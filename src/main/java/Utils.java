import com.google.gson.Gson;
import model.Account;
import model.Operations;
import model.Transaction;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.function.Function;

public class Utils {
    public static Function<String, Operations> mapToModel = s -> {
        Gson gson = new Gson();
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(s);
            Operations result = (json.containsKey("account")) ? gson.fromJson(json.get("account").toString(), Account.class)
                    : gson.fromJson(json.get("transaction").toString(), Transaction.class);

            return result;

        } catch (ParseException parseException) {
            parseException.printStackTrace();
        }
        return new Account(false, 0);
    };
}
