package m2iformation.fr.threads_web;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etUrl;
    private WebView wvPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUrl = findViewById(R.id.etUrl);
        wvPage = findViewById(R.id.wvPage);
    }

    public void getUrl(View view) {
        ClientHttp client = new ClientHttp();
        client.setAdr(etUrl.getText().toString());
        client.start();
        try {
            client.join();
            client.getResponse();
            wvPage.loadData(client.getResponse(), "text/html", "utf-8"); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
