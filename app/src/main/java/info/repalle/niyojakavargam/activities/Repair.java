package info.repalle.niyojakavargam.activities;

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

;


public class Repair extends AppCompatActivity {
    GridView grid;
    ImageView add;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_image_text_example);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab =getSupportActionBar();
       // setTitle("సమగ్ర సమాచారం");
        ab.setDisplayShowHomeEnabled(true);
        //add = (ImageView) findViewById(R.id.add);
        //add.setVisibility(View.GONE);
        final String[] services = new String[] { "కార్ రిపేర్",
                "బైక్ రిపేర్",
                "మొబైల్ రిపేర్",
                "కంప్యూటర్స్ అండ్ ప్రింటర్ రిపేర్",
                "లాప్టాప్ & టాబ్లెట్స్",
                "ఏసి రిపేర్",
                "ఫ్రిడ్జ్ రిపేర్",
                "వాషింగ్ మెషిన్ రిపేర్",
                "ఎయిర్ కూలర్లు రిపేర్",
                "గేజర్ రిపేర్",
                "జెనరేటర్స్",
                "ఇన్వర్టర్స్",
                "టివి & డీవీ డీ ప్లేయర్స్",
                "కెమెరా రిపేర్",
                "గ్యాస్-స్టవ్ రిపేర్",
                "కుట్టుమిషన్లు",
                "వ్యవసాయ ఇంజిన్స్ ",
                "మందు పంపులు"

        };
        int [] Images={
                R.drawable.carrepair,
                R.drawable.bikerepair,
                R.drawable.mobilerepair,
                R.drawable.computerrepair,
                R.drawable.loptoprepair,
                R.drawable.acrepair,
                R.drawable.refrigeratorrepair,
                R.drawable.washing,
                R.drawable.aircooler,
                R.drawable.gejar,
                R.drawable.genarator,
                R.drawable.invetor,
                R.drawable.dvd,
                R.drawable.camerarepair,
                R.drawable.gas,
                R.drawable.tailor,
                R.drawable.farmer,
                R.drawable.pumps,

        };
        if (CheckInternet.checkInternetConenction(context)) {
        ShopesGridview adapter = new ShopesGridview(Repair.this, services, Images);
        grid=(GridView)findViewById(R.id.grid_view_image_text);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +array[+ position], Toast.LENGTH_SHORT).show();
                switch (services[position]) {
                    case "కార్ రిపేర్":
                        String uri = "http://mainframestutor.in/car-repair-in-repalle/";
                        Intent intent = new Intent(Repair.this, WebActivity.class);
                        intent.putExtra("uri", uri);
                        startActivity(intent);
                        break;

                    case "బైక్ రిపేర్":
                        String uri4 = "http://mainframestutor.in/bike-repair-in-repalle/";
                        Intent intent4 = new Intent(Repair.this, WebActivity.class);
                        intent4.putExtra("uri", uri4);
                        startActivity(intent4);
                        break;
                    case "మొబైల్ రిపేర్":
                        String uri5 = "http://mainframestutor.in/mobile-repair-in-repalle/";
                        Intent intent5 = new Intent(Repair.this, WebActivity.class);
                        intent5.putExtra("uri", uri5);
                        startActivity(intent5);
                        break;
                    case "కంప్యూటర్స్ అండ్ ప్రింటర్ రిపేర్":
                        String uri6 = "http://mainframestutor.in/computer-pinter-repairs-in-repalle/";
                        Intent intent6 = new Intent(Repair.this, WebActivity.class);
                        intent6.putExtra("uri", uri6);
                        startActivity(intent6);
                        break;
                    case "లాప్టాప్ & టాబ్లెట్స్":
                        String uri7 = "http://mainframestutor.in/laptop-tablets-repair-in-repalle/";
                        Intent intent7 = new Intent(Repair.this, WebActivity.class);
                        intent7.putExtra("uri", uri7);
                        startActivity(intent7);
                        break;
                    case "ఏసి రిపేర్":
                        String uri8 = "http://mainframestutor.in/ac-repair-in-repalle/";
                        Intent intent8 = new Intent(Repair.this, WebActivity.class);
                        intent8.putExtra("uri", uri8);
                        startActivity(intent8);
                        break;
                    case "ఫ్రిడ్జ్ రిపేర్":
                        String uri9 = "http://mainframestutor.in/refrigerator-repair-in-repalle/";
                        Intent intent9 = new Intent(Repair.this, WebActivity.class);
                        intent9.putExtra("uri", uri9);
                        startActivity(intent9);
                        break;
                    case "వాషింగ్ మెషిన్ రిపేర్":
                        String uri11 = "http://mainframestutor.in/washing-machine-repair-in-repalle/";
                        Intent intent11 = new Intent(Repair.this, WebActivity.class);
                        intent11.putExtra("uri", uri11);
                        startActivity(intent11);
                        break;
                    case "ఎయిర్ కూలర్లు రిపేర్":
                        String uri14 = "http://mainframestutor.in/air-cooler-repairs-in-repalle/";
                        Intent intent14 = new Intent(Repair.this, WebActivity.class);
                        intent14.putExtra("uri", uri14);
                        startActivity(intent14);
                        break;
                    case "గేజర్ రిపేర్":
                        String uri15 = "http://mainframestutor.in/geyser-repair-in-repalle/";
                        Intent intent15 = new Intent(Repair.this, WebActivity.class);
                        intent15.putExtra("uri", uri15);
                        startActivity(intent15);
                        break;
                    case "జెనరేటర్స్":
                        String uri16 = "http://mainframestutor.in/generator-repair-in-repalle/";
                        Intent intent16 = new Intent(Repair.this, WebActivity.class);
                        intent16.putExtra("uri", uri16);
                        startActivity(intent16);
                        break;
                    case "ఇన్వర్టర్స్":
                        String uri17 = "http://mainframestutor.in/inverter-repair-in-repalle/";
                        Intent intent17 = new Intent(Repair.this, WebActivity.class);
                        intent17.putExtra("uri", uri17);
                        startActivity(intent17);
                        break;
                    case "టివి & డీవీ డీ ప్లేయర్స్":
                        String uri18 = "http://mainframestutor.in/tv-dvd-repairs-in-repalle/";
                        Intent intent18 = new Intent(Repair.this, WebActivity.class);
                        intent18.putExtra("uri", uri18);
                        startActivity(intent18);
                        break;
                    case "కెమెరా రిపేర్":
                        String uri19 = "http://mainframestutor.in/camera-repairs-in-repalle/";
                        Intent intent19 = new Intent(Repair.this, WebActivity.class);
                        intent19.putExtra("uri", uri19);
                        startActivity(intent19);
                        break;
                    case "గ్యాస్-స్టవ్ రిపేర్":
                        String uri20 = "http://mainframestutor.in/gas-stove-repair-in-repalle/";
                        Intent intent20 = new Intent(Repair.this, WebActivity.class);
                        intent20.putExtra("uri", uri20);
                        startActivity(intent20);
                        break;
                    case "కుట్టుమిషన్లు":
                        String uri21 = "http://mainframestutor.in/sewing-machine-repair-in-repalle/";
                        Intent intent21 = new Intent(Repair.this, WebActivity.class);
                        intent21.putExtra("uri", uri21);
                        startActivity(intent21);
                        break;
                    case "వ్యవసాయ ఇంజిన్స్ ":
                        String uri22 = "http://mainframestutor.in/agriculture-engines-repair/";
                        Intent intent22 = new Intent(Repair.this, WebActivity.class);
                        intent22.putExtra("uri", uri22);
                        startActivity(intent22);
                        break;
                    case "మందు పంపులు":
                        String uri23 = "http://mainframestutor.in/pumps-repair-in-repalle/";
                        Intent intent23 = new Intent(Repair.this, WebActivity.class);
                        intent23.putExtra("uri", uri23);
                        startActivity(intent23);
                        break;

                    default:
                        break;
                }

            }
        });
        }
        else

        {
            CheckInternet.showAlertDialog(Repair.this, "No Internet Connection",
                    "You don't have internet connection.");
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

}
