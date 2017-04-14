package info.repalle.niyojakavargam.activities;

/**
 * Created by welcome on 1/19/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

import activities.repalle.info.repalle.R;


public class StoresActivityGrid extends AppCompatActivity {
    GridView grid;
    ImageView add;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_image_text_example);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab =getSupportActionBar();
        setTitle("షాప్స్ & స్టోర్స్");
        ab.setDisplayShowHomeEnabled(true);
        //add = (ImageView) findViewById(R.id.add);
        //add.setVisibility(View.GONE);
        final String[] services = new String[] { "మెడికల్ షాప్స్ ",

                "మొబైల్ షాప్స్",

                "ఆటోమొబైల్ షాప్స్",

                "బుక్స్ షాప్స్",

                "కిరాణ & జెనరల్ స్టోర్స్",

                "ఆక్వాఫీడ్స్ స్టోర్స్",

                "ఫోటో స్టూడియోస్",

                "పెస్టిసైడ్స్ స్టోర్స్",

                "పతంజలి స్టోర్స్",

                "అగ్రికల్చర్ నీడ్స్ స్టోర్స్",

                "ఫర్నిచర్ షాప్స్",

                "ఫాన్సీ స్టోర్స్",

                "సలూన్ షాప్స్",
        "డ్రెస్ షాప్స్"};
        int [] Images={
                R.drawable.medical, R.drawable.mobile3, R.drawable.automobile, R.drawable.book4, R.drawable.general2, R.drawable.aquadic,
                R.drawable.potostudio, R.drawable.pestcides, R.drawable.patanjali, R.drawable.agric, R.drawable.furniture, R.drawable.fansy1,R.drawable.sellon,R.drawable.dresshops
        };
        ShopesGridview adapter = new ShopesGridview(StoresActivityGrid.this, services, Images);
        grid=(GridView)findViewById(R.id.grid_view_image_text);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +array[+ position], Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        if (CheckInternet.checkInternetConenction(context)) {

                            String uri = "http://mainframestutor.in/medical-stores-shops/";
                            Intent intent = new Intent(StoresActivityGrid.this, WebActivity.class);
                            intent.putExtra("uri", uri);
                            startActivity(intent);
                        } else {
                            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                    "You don't have internet connection.");
                        }
                        break;
                    case 1:
                        if (CheckInternet.checkInternetConenction(context)) {
                            String uri1 = "http://mainframestutor.in/mobile-stores-shops/";
                            Intent intent1 = new Intent(StoresActivityGrid.this, WebActivity.class);
                            intent1.putExtra("uri", uri1);

                            startActivity(intent1);
                        } else {
                            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                    "You don't have internet connection.");
                        }
                        break;
                    case 2:
                        if (CheckInternet.checkInternetConenction(context)) {
                            String uri2 = "http://mainframestutor.in/automobile-stores-shops/";
                            Intent intent2 = new Intent(StoresActivityGrid.this, WebActivity.class);
                            intent2.putExtra("uri", uri2);
                            startActivity(intent2);
                        } else {
                            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                    "You don't have internet connection.");
                        }
                        break;
                    case 3:
                        if (CheckInternet.checkInternetConenction(context)) {
                            String uri3 = "http://mainframestutor.in/books-stores-shops/";
                            Intent intent3 = new Intent(StoresActivityGrid.this, WebActivity.class);
                            intent3.putExtra("uri", uri3);
                            startActivity(intent3);
                        } else {
                            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                    "You don't have internet connection.");
                        }
                        break;
                    case 4:
                        if (CheckInternet.checkInternetConenction(context)) {
                            String uri4 = "http://mainframestutor.in/general-stores-shops/";
                            Intent intent4 = new Intent(StoresActivityGrid.this, WebActivity.class);
                            intent4.putExtra("uri", uri4);
                            startActivity(intent4);
                        } else {
                            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                    "You don't have internet connection.");
                        }
                        break;
                    case 5:
                        if (CheckInternet.checkInternetConenction(context)) {
                            String uri5 = "http://mainframestutor.in/aquafeeds-stores/";
                            Intent intent5 = new Intent(StoresActivityGrid.this, WebActivity.class);
                            intent5.putExtra("uri", uri5);
                            startActivity(intent5);
                        } else {
                            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                    "You don't have internet connection.");
                        }
                        break;
                    case 6:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri6 = "http://mainframestutor.in/photo-studios-in-repalle/";
                        Intent intent6 = new Intent(StoresActivityGrid.this, WebActivity.class);
                        intent6.putExtra("uri", uri6);
                        startActivity(intent6);
                }else{
                        CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                                "You don't have internet connection.");
                    }
                    break;
                    case 7:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri7 = "http://mainframestutor.in/pesticides-shops-in-repalle/";
                        Intent intent7 = new Intent(StoresActivityGrid.this, WebActivity.class);
                        intent7.putExtra("uri", uri7);
                        startActivity(intent7);
                }else{
                    CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                            "You don't have internet connection.");
                }
                break;
                case 8:if (CheckInternet.checkInternetConenction(context)) {

                String uri8 = "http://mainframestutor.in/patanjali-stores-in-repalle/";
                Intent intent8 = new Intent(StoresActivityGrid.this, WebActivity.class);
                intent8.putExtra("uri", uri8);
                startActivity(intent8);
            }

            else

            {
                CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                        "You don't have internet connection.");
            }

            break;
            case 9:
                if (CheckInternet.checkInternetConenction(context)) {
            String uri9 = "http://mainframestutor.in/agriculture-needs-stores-shops/";
            Intent intent9 = new Intent(StoresActivityGrid.this, WebActivity.class);
            intent9.putExtra("uri",uri9);

            startActivity(intent9);
        }else {
                CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                        "You don't have internet connection.");
            }
                        break;
                    case 10:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri10 = "http://mainframestutor.in/furniture-shops-in-repalle/";
                        Intent intent10 = new Intent(StoresActivityGrid.this, WebActivity.class);
                        intent10.putExtra("uri", uri10);
                        startActivity(intent10);
                     }else {
            CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
                    "You don't have internet connection.");
        }
                        break;
                    case 11:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri11 = "http://mainframestutor.in/fancy-stores-in-repalle/";
                        Intent intent11 = new Intent(StoresActivityGrid.this, WebActivity.class);
                        intent11.putExtra("uri", uri11);
                        startActivity(intent11);
}else {
        CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
        "You don't have internet connection.");
        }
                        break;
                    case  12:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri12 = "http://mainframestutor.in/fancy-stores-in-repalle/";
                        Intent intent12 = new Intent(StoresActivityGrid.this, WebActivity.class);
                        intent12.putExtra("uri", uri12);
                        startActivity(intent12);
        }else {
        CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
        "You don't have internet connection.");
        }
                        break;
                    case  13:
                        if (CheckInternet.checkInternetConenction(context)) {
                        String uri13 = "http://mainframestutor.in/dress-shops/";
                        Intent intent13 = new Intent(StoresActivityGrid.this, WebActivity.class);
                        intent13.putExtra("uri", uri13);
                        startActivity(intent13);
        }else {
        CheckInternet.showAlertDialog(StoresActivityGrid.this, "No Internet Connection",
        "You don't have internet connection.");
        }
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
