package info.repalle.niyojakavargam.activities;

/**
 * Created by welcome on 1/19/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import activities.repalle.info.repalle.R;


public class Home extends AppCompatActivity {
    GridView grid;
    ImageView add;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_image_text_example);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab =getSupportActionBar();
        ab.setDisplayShowHomeEnabled(true);
        ab.setIcon(R.mipmap.ic_logo);

        final String[] services = new String[] {"సమగ్ర సమాచారం",
                "ప్రత్యెక వ్యాపార\n" +
                        "సంస్థలు ",
                "మమ్మల్ని సంప్రదించుటకు",
                "మేము చేస్తున్నపనులు ,ఆశయాలు",
                "రక్తం కావలిసిన వారు",
                "రక్తం డొనేట్ చేయ్యధలుచుటకు",
                "మా ఈవెంట్స్ గేలరీ",
                "ఎడ్యుకేషన్ గైడెన్స్ సెల్",
                "విమెన్ ప్రొటెక్షన్ సెల్",
                "మాతో కలిసిపని చేయుటకు  ",
        };
        int[] Images = {
                R.drawable.info,
                R.drawable.speciall,
                R.drawable.contact,
                R.drawable.goals,
                R.drawable.blood,
                R.drawable.blooddonation,
                R.drawable.event,
                R.drawable.education,
                R.drawable.women,
                R.drawable.reg,

        };
        ShopesGridview adapter = new ShopesGridview(Home.this, services, Images);
        grid=(GridView)findViewById(R.id.grid_view_image_text);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +array[+ position], Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        Intent intent = new Intent(Home.this,SubMenu.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(Home.this,SpecialServices.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri9 = "http://mainframestutor.in/contact-us/";
                        Intent intent9 = new Intent(Home.this,WebActivity.class);
                        intent9.putExtra("uri", uri9);

                        startActivity(intent9);
                }
                else

                {
                    CheckInternet.showAlertDialog(Home.this, "No Internet Connection",
                            "You don't have internet connection.");
                }

                        break;

                    case 3:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri = "http://mainframestutor.in/activities-goals-in-repalle-constituency/";
                        Intent intent2 = new Intent(Home.this,WebActivity.class);
                        intent2.putExtra("uri",uri);
                        startActivity(intent2);
            }
            else

            {
                CheckInternet.showAlertDialog(Home.this, "No Internet Connection",
                        "You don't have internet connection.");
            }
                        break;
                    case 4:

                        Intent intent8 = new Intent(Home.this,BloodRequest.class);
                        startActivity(intent8);
                        break;

                    case 5:
                        Intent intent3 = new Intent(Home.this,BloodDonars.class);
                        startActivity(intent3);
                        break;

                    case 6:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri3 ="http://mainframestutor.in/events-gallery/";
                        Intent intent5 = new Intent(Home.this,WebActivity.class);
                        intent5.putExtra("uri",uri3);
                        startActivity(intent5);
        }
        else

        {
            CheckInternet.showAlertDialog(Home.this, "No Internet Connection",
                    "You don't have internet connection.");
        }
                        break;

                    case 7:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri4 ="http://mainframestutor.in/educational-guidance-cell-in-repalle/";
                        Intent intent6 = new Intent(Home.this,WebActivity.class);
                        intent6.putExtra("uri",uri4);
                        startActivity(intent6);
    }
    else

    {
        CheckInternet.showAlertDialog(Home.this, "No Internet Connection",
                "You don't have internet connection.");
    }
                        break;

                    case 8:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri6 ="http://mainframestutor.in/women-protection-cell-in-repalle/";
                        Intent intent7 = new Intent(Home.this,WebActivity.class);
                        intent7.putExtra("uri",uri6);
                        startActivity(intent7);
}
else

        {
        CheckInternet.showAlertDialog(Home.this, "No Internet Connection",
        "You don't have internet connection.");
        }
                        break;

                    case 9:
                        Intent intent10 = new Intent(Home.this,JoinWithUs.class);
                        startActivity(intent10);
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
