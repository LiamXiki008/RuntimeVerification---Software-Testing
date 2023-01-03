package main;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;
import java.util.Objects;

public class Api {
    int noOfAlerts;
    int eventLogType;

    public Api(){}

    public void setApi(OkHttpClient client) throws IOException{
        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/EventsLog/aba2df1c-5441-4581-9dc2-5413c9691825")
                .addHeader("Content-Type", "application/json")
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new IOException("Unexpected code:" + response);

            String jsonString = Objects.requireNonNull(response.body()).string();

            main.Response[] responseArray = new Gson().fromJson(jsonString, main.Response[].class);

            this.noOfAlerts = responseArray[0].systemState.alerts.size();
            this.eventLogType = responseArray[0].eventLogType;
        }
    }
}
