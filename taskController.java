package com.example.api;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class taskController {

    @FXML
    private Button clickMeBtn;

    @FXML
    private TextField resultTextField;

    @FXML
    private void initialize() {
        resultTextField.setVisible(false);
    }

    @FXML
    private void onButtonClick() {
        try {
            String apiUrl = "https://www.boredapi.com/api/activity";
            String apiResponse = fetchDataFromAPI(apiUrl);

            JSONObject json = new JSONObject(apiResponse);


            String task = json.getString("activity");

            resultTextField.setText(task);
            resultTextField.setVisible(true);

        } catch (IOException | InterruptedException e) {
            handleException(e);
        }
    }

    private String fetchDataFromAPI(String apiUrl) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private void handleException(Exception e) {
        e.printStackTrace();

    }
}

