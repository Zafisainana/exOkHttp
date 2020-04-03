package com.example.exokhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.textclassifier.TextLinks;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void callServiceWeb()
    {
        String url="http://www.claudehenry.fr/serviceweb/bonjour";
        /* on instancie notre objet okthhp*/
        OkHttpClient client = new OkHttpClient();

        /* appel get
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();*/

        /* on créé la demande à partir de l'url*/
        Request request =   new Request.Builder()
                .url(url)
                .build();

        try {
            /*on ontient la reponse*/
            Response response = client.newCall(request).execute();

            if(response.isSuccessful()){
                String retour = response.body().string();
            }
        }
        catch (Exception ex)
        {

        }

    }
}
