package info.repalle.niyojakavargam.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import activities.repalle.info.repalle.R;

public class JoinWithUs extends AppCompatActivity implements
        View.OnClickListener {

    EditText name,mobile,mail,village,invisible;
    Button cancel;
    Spinner mandal;
    String  Name,Mobile,Mail,Village,Mandal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinus);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.ic_logo);
        String[] nums = new String[]{"Select Mandal","Repalle", "Nagaram", "Nizampatnam", "Cherukupalli"};
        mandal = (Spinner) findViewById(R.id.mandal);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nums);
        mandal.setAdapter(adapter1);
        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        mail=(EditText)findViewById(R.id.mail);
        village=(EditText)findViewById(R.id.village);
        invisible=(EditText)findViewById(R.id.invisible);
        cancel=(Button)findViewById(R.id.cancel);
        Button sub=(Button)findViewById(R.id.register);
        cancel.setOnClickListener(this);
        sub.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                if (checkValidation()) {
                    if(CheckInternet.checkInternetConenction(JoinWithUs.this)) {
                        new PostDataAsyncTask().execute();
                        startActivity(new Intent(getApplicationContext(),Home.class));
                    }else {
                        CheckInternet.showAlertDialog(JoinWithUs.this, "No Internet Connection",
                                "You don't have internet connection.");
                    }
                }
            }
        });
    }
    public class PostDataAsyncTask extends AsyncTask<String, String, String> {

        protected void onPreExecute() {
            super.onPreExecute();
            // do stuff before posting data
        }

        @Override
        protected String doInBackground(String... strings) {
            try {

                Name = name.getText().toString();
                Mobile   = mobile.getText().toString();
                Mail = mail.getText().toString();
                Village   = village.getText().toString();
                Mandal=mandal.getSelectedItem().toString();
                // url where the data will be posted
                String postReceiverUrl = "http://eloksolutions.in/diviseema/register.php";
                //Log.v(TAG, "postURL: " + postReceiverUrl);
                // HttpClient
                HttpClient httpClient = new DefaultHttpClient();
                // post header
                HttpPost httpPost = new HttpPost(postReceiverUrl);
                // add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("Name", Name));
                nameValuePairs.add(new BasicNameValuePair("Mobile", Mobile));
                nameValuePairs.add(new BasicNameValuePair("Email", Mail));
                nameValuePairs.add(new BasicNameValuePair("Village", Village));
                nameValuePairs.add(new BasicNameValuePair("Mandal",Mandal));

                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // execute HTTP post request
                HttpResponse response = httpClient.execute(httpPost);
                HttpEntity resEntity = response.getEntity();

                if (resEntity != null) {

                    String responseStr = EntityUtils.toString(resEntity).trim();
                    // Log.v(TAG, "Response: " + responseStr);

                    // you can add an if statement here and do other actions based on the response
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // do stuff after posting data
            Toast.makeText(JoinWithUs.this, "Register successfully", Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public void onClick(View v) {
        if(v == cancel){
            startActivity(new Intent(getApplicationContext(), Home.class));
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            case R.id.action_settings:
                startActivity(new Intent(this, Home.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private boolean checkValidation() {
        boolean ret = true;
        if(!Validation.hasSelected(mandal,invisible)) ret=false;
        if (!Validation.hasText(village)) ret = false;
        if (!Validation.hasText(mail)) ret = false;
        if (!Validation.isPhoneNumber(mobile, true)) ret = false;
        if (!Validation.hasText(name)) ret = false;
        return ret;
    }
}


