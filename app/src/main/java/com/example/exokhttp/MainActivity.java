package com.example.exokhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.textclassifier.TextLinks;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView txtReponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    txtReponse = findViewById(R.id.txtReponse);
    Button btnServiceWeb = findViewById(R.id.btnServiceWeb);

    btnServiceWeb.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AsyncCallWS asyncCallWS = new AsyncCallWS();
            asyncCallWS.execute();
        }
    });

    }


    private class AsyncCallWS extends AsyncTask<String,Integer,String>
    {
        @Override
        protected void onPreExecute(){super.onPreExecute();}


        @Override
        protected String doInBackground(String... strings) {
            return callServiceWeb();

        }

        @Override
        protected void onPostExecute(String retourServiceWeb){
            super.onPostExecute(retourServiceWeb);
            txtReponse.setText(retourServiceWeb);


        }
    }

    private String callServiceWeb()
    {
        String url="http://www.claudehenry.fr/serviceweb/bonjour";
        /* on instancie notre objet okthhp*/
        OkHttpClient client = new OkHttpClient();
        String retourServiceWeb ="";

        /* appel get
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();*/

        /* on créé la demande à partir de l'url*/
        Request request =   new Request.Builder().url(url).build();

        try {
            /*on ontient la reponse*/
            Response response = client.newCall(request).execute();

            if(response.isSuccessful()){
                retourServiceWeb = response.body().string();

            }
        }
        catch (Exception ex)
        {
            retourServiceWeb = ex.getMessage();
        }

        return retourServiceWeb;

    }


}
