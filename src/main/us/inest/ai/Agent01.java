package us.inest.ai;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Agent01 {
    public static void main(String[] args) throws IOException {
        System.out.println("Done");
        String modelName = "gemma4:31b-cloud";
        String prompt = "What is the capital of Texas state";
        URL url = new URL("http://localhost:11434/api/generate");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json;utf-8");
        conn.setRequestProperty("Accept", "application/json;utf-8");
        conn.setDoOutput(true);
        String jsonInputString = String.format(
                "{\"model\": \"%s\", \"prompt\": \"%s\", \"stream\": false}", modelName, prompt);
        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        int code = conn.getResponseCode();
        System.out.println("Response Code : " + code);
        BufferedReader in = new BufferedReader(
                new java.io.InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println(response.toString());

        JSONObject jsonObject = new JSONObject(response.toString());
        String responseText = jsonObject.getString("response");
        System.out.println(responseText);

        conn.disconnect();
    }
}
