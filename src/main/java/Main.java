import com.google.gson.Gson;
import model.Account;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import model.Operations;
import model.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import state.OperationProcesorMachine;

public class Main {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data/data.txt");

        OperationProcesorMachine machine = new OperationProcesorMachine();

        BiFunction<Operations, OperationProcesorMachine, Response> process =
                (operation, operationMachine) -> operationMachine.processOperation(operation);

        List<Response> list =Files.
                             lines(Paths.get(path.toAbsolutePath().toString()))
                             .map(Utils.mapToModel)
                             .map(operations -> process.apply(operations,machine)).collect(Collectors.toList());
        list.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------------------------------------------------");

      //List<Account> list = Files.lines(Paths.get(path.toAbsolutePath().toString() )).filter(s->s.contains("account")).map(mapToAccount).collect(Collectors.toList());


    }


}
