package info.repalle.niyojakavargam.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
public class WaterCan extends AppCompatActivity implements
        View.OnClickListener {

    EditText name,mobile,address,invisible,invisible1;
    Button cancel;
    Spinner noofcans,city;
    String  Name,Mobile,City,Cans,Address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watercan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.ic_logo);
        String[] nums = new String[]{"NO OF CANS","1", "2", "3", "4", "5", "6","7", "8", "9","10"};
        noofcans = (Spinner) findViewById(R.id.noofcans);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, nums);
        // adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        noofcans.setAdapter(adapter);
        String[] cities = new String[]{"Select City","Repalle", "Nagaram", "Nizampatnam", "Cherukupalli"};
        city = (Spinner) findViewById(R.id.city);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, cities);
        // adapter1.SetDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        city.setAdapter(adapter1);

        name=(EditText)findViewById(R.id.name);
        mobile=(EditText)findViewById(R.id.mobile);
        address=(EditText)findViewById(R.id.address);
        invisible=(EditText)findViewById(R.id.invisible);
        invisible1=(EditText)findViewById(R.id.invisible1);
        cancel=(Button)findViewById(R.id.cancel);
        Button sub=(Button)findViewById(R.id.submit);

        cancel.setOnClickListener(this);
        sub.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View v)
            {
                if (checkValidation()) {
                    if(CheckInternet.checkInternetConenction(WaterCan.this)) {
                        new PostDataAsyncTask().execute();
                        startActivity(new Intent(getApplicationContext(), SpecialServices.class));
                    }else {
                        CheckInternet.showAlertDialog(WaterCan.this, "No Internet Connection",
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
                City = city.getSelectedItem().toString();
                Cans = noofcans.getSelectedItem().toString();
                Address=address.getText().toString();

                // url where the data will be posted
                String postReceiverUrl = "http://eloksolutions.in/diviseema/watercan.php";
                //Log.v(TAG, "postURL: " + postReceiverUrl);
                // HttpClient
                HttpClient httpClient = new DefaultHttpClient();
                // post header
                HttpPost httpPost = new HttpPost(postReceiverUrl);
                // add your data
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("Name", Name));
                nameValuePairs.add(new BasicNameValuePair("Mobile", Mobile));
                nameValuePairs.add(new BasicNameValuePair("City", City));
                nameValuePairs.add(new BasicNameValuePair("Cans", Cans));
                nameValuePairs.add(new BasicNameValuePair("Address",Address));


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
            Toast.makeText(WaterCan.this, "send successfully", Toast.LENGTH_LONG).show();

        }
    }
    public void onClick(View v) {
        if(v == cancel){
            startActivity(new Intent(getApplicationContext(), SpecialServices.class));
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
        if(!Validation.hasSelected(noofcans,invisible1)) ret = false;
        if (!Validation.isPhoneNumber(mobile, true)) ret = false;
        if (!Validation.hasText(name)) ret = false;
        if(!Validation.hasSelected(city,invisible)) ret = false;
        return ret;
    }
}


