package info.repalle.niyojakavargam.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import activities.repalle.info.repalle.R;

public class LadiesSpecial extends ActionBarActivity {
    ListView listView ;
    List<HashMap<String,String>> aList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab =getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.ic_logo);
        listView = (ListView) findViewById(R.id.list);
        String[] menus = new String[] {"బ్యూటీ టిప్స్",
                "ఫాషన్ డిజైనింగ్ ",
                "ఇంటీరియర్ డిజైనింగ్",
                "తెలుగు పండుగలు ",
                "మన సాంప్రదాయాలు",
                "ఆరోగ్యం కోసం యోగ"};
        int[] images = {
                R.drawable.ic_beautytips,
                R.drawable.ic_fashion,
                R.drawable.ic_nteriortips,
                R.drawable.ic_telugufestivals,
                R.drawable.ic_tradition,
                R.drawable.ic_yoga
        };

        aList = new ArrayList<HashMap<String,String>>();

        for(int i=0;i<menus.length;i++){
            HashMap<String, String> hm = new HashMap<String,String>();
            hm.put("img",Integer.toString(images[i]));
            hm.put("menu",menus[i]);
            aList.add(hm);
        }
        String[] from = {"img","menu"};
        int[] to = {R.id.img,R.id.txt};
        SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList, R.layout.listview, from, to);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        String uri = "http://mainframestutor.in/beauty-tips-for-repalle/ ";
                        Intent intent = new Intent(LadiesSpecial.this,WebActivity.class);
                        intent.putExtra("uri",uri);
                        startActivity(intent);
                        break;
                    case 1:
                        String uri1 = "http://mainframestutor.in/fashion-designing-tips/";
                        Intent intent1 = new Intent(LadiesSpecial.this,WebActivity.class);
                        intent1.putExtra("uri",uri1);
                        startActivity(intent1);
                        break;
                    case 2:
                        String uri2 = "http://mainframestutor.in/interior-design-tips/";
                        Intent intent2 = new Intent(LadiesSpecial.this,WebActivity.class);
                        intent2.putExtra("uri",uri2);
                        startActivity(intent2);
                        break;
                    case 3:
                        String uri3 = "http://mainframestutor.in/telugu-festivals/";
                        Intent intent3 = new Intent(LadiesSpecial.this,WebActivity.class);
                        intent3.putExtra("uri",uri3);
                        startActivity(intent3);
                        break;
                    case 4:
                        String uri4 ="http://mainframestutor.in/our-tradition-in-repalle/";
                        Intent intent4 = new Intent(LadiesSpecial.this,WebActivity.class);
                        intent4.putExtra("uri",uri4);
                        startActivity(intent4);
                        break;
                    case 5:
                        String uri5 ="http://mainframestutor.in/yoga-for-health/";
                        Intent intent5 = new Intent(LadiesSpecial.this,WebActivity.class);
                        intent5.putExtra("uri",uri5);
                        startActivity(intent5);
                        break;
                    default:
                        break;
                }
            }

        });

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
}
