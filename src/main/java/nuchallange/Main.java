package nuchallange;

import com.google.gson.Gson;
import nuchallange.model.ResponseState;
import nuchallange.process.ProcessData;
import nuchallange.process.ProcessJson;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        /* trying comments*/

        ProcessData processData = new ProcessData(null);
        Gson gson = new Gson();
        JSONParser parser = new JSONParser();

        ProcessJson processJson = new ProcessJson(gson,parser,processData);

        Path path = Paths.get("data/data.txt");

        List<ResponseState> list = Files.
                lines(Paths.get(path.toAbsolutePath().toString()))
                .map(s -> {
                    try {
                        return processJson.handleJson(s);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.toList());
        list.stream().forEach(System.out::println);





    }
}
