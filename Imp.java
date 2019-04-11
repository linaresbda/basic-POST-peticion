import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Imp {

    public static void sendPost() throws IOException {
        URL url = new URL("");
        String xml = "";

        byte[] data = xml.getBytes("UTF-8");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
        conn.setRequestProperty("SOAPAction", "");
        conn.setRequestProperty("User-Agent", "Test-Client/1.0.0 (java 1.8.0)");
        conn.setRequestProperty("Content-Length", String.valueOf(data.length));
        conn.setDoOutput(true);
        conn.getOutputStream().write(data);

        Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
        for (int c = in.read(); c != -1; c = in.read()) {
            System.out.print((char) c);
        }
    }

    public static void main(String[] args) {
        try {
            sendPost();
        } catch (IOException e) {
            System.out.println("error " + e.getMessage());
        }
    }
}