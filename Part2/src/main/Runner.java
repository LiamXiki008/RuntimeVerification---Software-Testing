package main;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import com.google.gson.Gson;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;


import java.util.Objects;

public class Runner {
    OkHttpClient client = new OkHttpClient();

    //Method to post valid alert
    public void validPostAlert(){
        System.out.println("Valid Post Alert");
    }

    //Method to post invalid alert
    public void invalidPostAlert(){
        System.out.println("Invalid Post Alert");
    }

    //Method to delete alerts
    public void deleteAlerts(){
        System.out.println("Deleted Alerts");
    }

    public void postAttempt() throws Exception {

        Alert testAlert = new Alert();
        String testAlertJson;

        testAlert = new Alert(
                6,"ASUS TUF Gaming F17 17.3","ASUS TUF Gaming F17 17.3 FHD IPS 144Hz Core i7-11800H (11th Gen) 1TB SSD 16GB RAM RTX3060 (6GB) Win11 (Ex Display)","https://www.scanmalta.com/shop/asus-tuf-gaming-f17-17-3-fhd-ips-144hz-core-i7-11800h-11th-gen-1tb-ssd-16gb-ram-rtx3060-6gb-win10-ex-display.html",
                "https://www.scanmalta.com/shop/pub/media/catalog/product/cache/b084519189a7c7b3054def1f3dcab96f/3/3/3399009-l-a.jpg","aba2df1c-5441-4581-9dc2-5413c9691825",102900);

        System.out.println("Creating new alert.");
        testAlertJson = new Gson().toJson(testAlert);

        RequestBody body = RequestBody.create(
                testAlertJson,
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new Exception("Unexpected code " + response);
            System.out.println(Objects.requireNonNull(response.body()).string());
        }

    }

    public void deleteAttempt() throws IOException {
        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert?userId=aba2df1c-5441-4581-9dc2-5413c9691825")
                .delete()
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new Exception("Unexpected code:" + response);
            System.out.println(Objects.requireNonNull(response.body()).string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postInvalidAlertAttempt() throws Exception{
        Alert testAlert = new Alert();
        String testAlertJson;

        testAlert = new Alert(
                -1,"invalid","invalid","invalid",
                "invalid","aba2df1c-5441-4581-9dc2-5413c9691825",0);

        System.out.println("Creating invalid alert.");
        testAlertJson = new Gson().toJson(testAlert);

        RequestBody body = RequestBody.create(
                testAlertJson,
                MediaType.parse("application/json; charset=utf-8")
        );

        Request request = new Request.Builder()
                .url("https://api.marketalertum.com/Alert")
                .addHeader("Content-Type", "application/json")
                .post(body)
                .build();

        try(Response response = client.newCall(request).execute()){
            if(!response.isSuccessful()) throw new Exception("Unexpected code:" + response);
            System.out.println(Objects.requireNonNull(response.body()).string());
        }

    }

    public void run(final Api api) throws Exception {

        this.deleteAttempt();
        api.setApi(client);
        int noOfAlerts = api.noOfAlerts;
        System.out.println("No of alerts before post: " + noOfAlerts);

        while(true) {
            //Randomly generate a number between 1 and 5
            int random = (int) (Math.random() * 5) + 1;

            switch (random) {
                case 1:
                    this.postInvalidAlertAttempt();
                    api.setApi(client);

                    if (api.eventLogType == 0 && api.noOfAlerts == noOfAlerts + 1) {
                        noOfAlerts = api.noOfAlerts;
                        this.invalidPostAlert();
                    }
                    break;

                case 2:
                    this.deleteAttempt();
                    api.setApi(client);
                    if (api.eventLogType == 1 && api.noOfAlerts == 0) {
                        noOfAlerts = api.noOfAlerts;
                        this.deleteAlerts();
                    }

                default:
                    this.postAttempt();
                    api.setApi(client);
                    if (api.eventLogType == 0 && api.noOfAlerts == noOfAlerts + 1) {
                        noOfAlerts = api.noOfAlerts;
                        this.validPostAlert();
                    }
                    break;
            }

            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    public static void main(String[] args) throws Exception {
        Runner runner = new Runner();
        Api api = new Api();
        runner.run(api);
    }
}
