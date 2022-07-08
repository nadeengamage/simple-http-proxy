import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.util.ArrayList;

public class HTTPResponse {
    ArrayList<String> lines = new ArrayList<>();

    HTTPResponse(BufferedReader reader) throws Exception {
        String line;

        while((line = reader.readLine()) != null) {
            lines.add(line);
        }

        // TODO: set resLine, headers and resBody using lines<>
    }

    void send (DataOutputStream stream) throws Exception {
        for (String line : lines) {
            System.out.println("RES > " + line);
            stream.writeBytes(line + "\r\n");
            stream.flush();
        }
        stream.writeBytes("\r\n");
        stream.flush();
    }
}
