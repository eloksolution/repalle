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


public class SubMenu extends AppCompatActivity {
    GridView grid;
    ImageView add;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridview_image_text_example);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar ab =getSupportActionBar();
        setTitle("సమగ్ర సమాచారం");
        ab.setDisplayShowHomeEnabled(true);
        //add = (ImageView) findViewById(R.id.add);
        //add.setVisibility(View.GONE);
        final String[] services = new String[] { "చరిత్ర",
                "పట్టణాలు",
                "గ్రామాలు",
                "దేవాలయాలు",
                "స్కూల్స్",
                "కాలేజీలు",
                "హాస్పిటల్స్",
                "రెస్టారెంట్లు",
                "బార్స్",
                "ట్రావెల్స్",
                "పర్యాటక ప్రాంతాలు",
                "ఎడ్యుకేషనల్ ఇన్స్టిట్యూట్స్",
                "బ్యాంక్స్",
                "ఏ.టి.మ్స్",
                "పోస్ట్ ఆఫీసులు",
                "పోలీస్ స్టేషన్లు",
                "ఫైర్ స్టేషన్లు",
                "ఆయిల్ బంక్స్",
                "జిమ్ సెంటర్స్",
                "బ్యూటీ పార్లర్స్",
                "వెహికల్ షోరూమ్స్",
                "ఫంక్షన్స్ హాల్స్",
                "షాప్స్ & స్టోర్స్",
                "ప్రభుత్వ కార్యాలయాలు",
                "మీసేవా సెంటర్స్",
                "సినిమాలు",
                "ఆరోగ్య-సమాచారం",
                "వ్యవసాయ-సమాచారం",
                "పిల్లలకు - పధకాలు",
                "మహిళలకు -పధకాలు",
                "స్త్రీల కొరకు స్పెషల్",
                "విలువైన-సమాచారం",
                "కృష్ణా పుష్కర్ ఘాట్స్",
                "ఉద్యోగ-సమాచారం",
                "ఫోన్-బుక్",
                "వరదల సమాచారం",
                "జరగబోవు కార్యక్రమాలు",
                "రాజకీయ నాయకులు",
                "ప్రసిద్ధి  చెందిన వ్యక్తులు",
                "ఆదర్శ వ్యక్తులు",
                "స్వాతంత్ర సమరయోధులు",
                "చిత్ర-కళాకారులు",
                "రేపల్లె -ఫోటో గాలరి",
                "నగరం-ఫోటో గాలరి",
                "నిజాంపట్నం-ఫోటో గాలరి",
                "చెరుకుపల్లి-ఫోటో గాలరి"
        };
        int [] Images={
                R.drawable.charithra,
                R.drawable.cities,
                R.drawable.vilages,
                R.drawable.temple,
                R.drawable.school,
                R.drawable.colleges,
                R.drawable.hospital,
                R.drawable.hotel,
                R.drawable.bar,
                R.drawable.travels,
                R.drawable.visiting,
                R.drawable.education,
                R.drawable.bank,
                R.drawable.atm,
                R.drawable.postooffice,
                R.drawable.police,
                R.drawable.fire,
                R.drawable.petrol,
                R.drawable.gym,
                R.drawable.beaty,
                R.drawable.showroom,
                R.drawable.functionhals,
                R.drawable.stores,
                R.drawable.govtof1,
                R.drawable.meseva,
                R.drawable.cinima,
                R.drawable.health,
                R.drawable.agric,
                R.drawable.childrens,
                R.drawable.ladies,
                R.drawable.ladiesspecial,
                R.drawable.tips,
                R.drawable.krishnapuksha,
                R.drawable.job,
                R.drawable.phone,
                R.drawable.divisema,
                R.drawable.news,
                R.drawable.politics,
                R.drawable.inspiring,
                R.drawable.vivekananda,
                R.drawable.freedom,
                R.drawable.film,
                R.drawable.gantasalav,
                R.drawable.diviseema,
                R.drawable.koduru,
                R.drawable.nagaya,
                R.drawable.chalapalli,
                R.drawable.mopidevi,
                R.drawable.gantasala,
                R.drawable.cherukupalli
        };
        if (CheckInternet.checkInternetConenction(context)) {
        ShopesGridview adapter = new ShopesGridview(SubMenu.this, services, Images);
        grid=(GridView)findViewById(R.id.grid_view_image_text);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(MainActivity.this, "You Clicked at " +array[+ position], Toast.LENGTH_SHORT).show();
                switch (services[position]) {
                    case "చరిత్ర":
                        String uri = "http://mainframestutor.in/";
                        Intent intent = new Intent(SubMenu.this, WebActivity.class);
                        intent.putExtra("uri", uri);
                        startActivity(intent);
                        break;
                    case "పట్టణాలు":
                        Intent intent1 = new Intent(SubMenu.this, Cities.class);
                        startActivity(intent1);
                        break;
                    case "గ్రామాలు":
                        Intent intent2 = new Intent(SubMenu.this, Villages.class);
                        startActivity(intent2);
                        break;
                    case "దేవాలయాలు":
                        Intent intent3 = new Intent(SubMenu.this, Temples.class);
                        startActivity(intent3);
                        break;
                    case "స్కూల్స్":
                        String uri4 = "http://mainframestutor.in/schools-in-repalle-constituency/";
                        Intent intent4 = new Intent(SubMenu.this, WebActivity.class);
                        intent4.putExtra("uri", uri4);
                        startActivity(intent4);
                        break;
                    case "కాలేజీలు":
                        String uri5 = "http://mainframestutor.in/colleges-in-repalle-constituency/";
                        Intent intent5 = new Intent(SubMenu.this, WebActivity.class);
                        intent5.putExtra("uri", uri5);
                        startActivity(intent5);
                        break;
                    case "హాస్పిటల్స్":
                        String uri6 = "http://mainframestutor.in/hospitals-in-repalle-constituency/";
                        Intent intent6 = new Intent(SubMenu.this, WebActivity.class);
                        intent6.putExtra("uri", uri6);
                        startActivity(intent6);
                        break;
                    case "రెస్టారెంట్లు":
                        String uri7 = "http://mainframestutor.in/restaurants-hotels-in-repalle-constituency/";
                        Intent intent7 = new Intent(SubMenu.this, WebActivity.class);
                        intent7.putExtra("uri", uri7);
                        startActivity(intent7);
                        break;
                    case "బార్స్":
                        String uri8 = "http://mainframestutor.in/bars-in-repalle-constituency/";
                        Intent intent8 = new Intent(SubMenu.this, WebActivity.class);
                        intent8.putExtra("uri", uri8);
                        startActivity(intent8);
                        break;
                    case "ట్రావెల్స్":
                        String uri9 = "http://mainframestutor.in/transportation-from-repalle/";
                        Intent intent9 = new Intent(SubMenu.this, WebActivity.class);
                        intent9.putExtra("uri", uri9);
                        startActivity(intent9);
                        break;
                    case "పర్యాటక ప్రాంతాలు":
                        String uri11 = "http://mainframestutor.in/visiting-places-in-repalle-constituency/";
                        Intent intent11 = new Intent(SubMenu.this, WebActivity.class);
                        intent11.putExtra("uri", uri11);
                        startActivity(intent11);
                        break;
                    case "ఎడ్యుకేషనల్ ఇన్స్టిట్యూట్స్":
                        String uri14 = "http://mainframestutor.in/educational-institutions-in-repalle/";
                        Intent intent14 = new Intent(SubMenu.this, WebActivity.class);
                        intent14.putExtra("uri", uri14);
                        startActivity(intent14);
                        break;
                    case "బ్యాంక్స్":
                        String uri15 = "http://mainframestutor.in/banks-in-repalle-constituency/";
                        Intent intent15 = new Intent(SubMenu.this, WebActivity.class);
                        intent15.putExtra("uri", uri15);
                        startActivity(intent15);
                        break;
                    case "ఏ.టి.మ్స్":
                        String uri16 = "http://mainframestutor.in/atm-centers-in-repalle-constituency/";
                        Intent intent16 = new Intent(SubMenu.this, WebActivity.class);
                        intent16.putExtra("uri", uri16);
                        startActivity(intent16);
                        break;
                    case "పోస్ట్ ఆఫీసులు":
                        String uri17 = "http://mainframestutor.in/post-offices-in-repalle/";
                        Intent intent17 = new Intent(SubMenu.this, WebActivity.class);
                        intent17.putExtra("uri", uri17);
                        startActivity(intent17);
                        break;
                    case "పోలీస్ స్టేషన్లు":
                        String uri18 = "http://mainframestutor.in/police-stations-in-repalle-constituency/";
                        Intent intent18 = new Intent(SubMenu.this, WebActivity.class);
                        intent18.putExtra("uri", uri18);
                        startActivity(intent18);
                        break;
                    case "ఫైర్ స్టేషన్లు":
                        String uri19 = "http://mainframestutor.in/fire-stations-in-repalle-constituency/";
                        Intent intent19 = new Intent(SubMenu.this, WebActivity.class);
                        intent19.putExtra("uri", uri19);
                        startActivity(intent19);
                        break;
                    case "ఆయిల్ బంక్స్":
                        String uri20 = "http://mainframestutor.in/fuel-stations-in-repalle-constituency/";
                        Intent intent20 = new Intent(SubMenu.this, WebActivity.class);
                        intent20.putExtra("uri", uri20);
                        startActivity(intent20);
                        break;
                    case "జిమ్ సెంటర్స్":
                        String uri21 = "http://mainframestutor.in/gym-centers-in-repalle-constituency/";
                        Intent intent21 = new Intent(SubMenu.this, WebActivity.class);
                        intent21.putExtra("uri", uri21);
                        startActivity(intent21);
                        break;
                    case "బ్యూటీ పార్లర్స్":
                        String uri22 = "http://mainframestutor.in/beauty-parlors-in-repalle-constituency/";
                        Intent intent22 = new Intent(SubMenu.this, WebActivity.class);
                        intent22.putExtra("uri", uri22);
                        startActivity(intent22);
                        break;
                    case "వెహికల్ షోరూమ్స్":
                        String uri23 = "http://mainframestutor.in/vehicle-showrooms-in-repalle/";
                        Intent intent23 = new Intent(SubMenu.this, WebActivity.class);
                        intent23.putExtra("uri", uri23);
                        startActivity(intent23);
                        break;
                    case "ఫంక్షన్స్ హాల్స్":
                        String uri24 = "http://mainframestutor.in/function-halls-in-repalle/";
                        Intent intent24 = new Intent(SubMenu.this, WebActivity.class);
                        intent24.putExtra("uri", uri24);
                        startActivity(intent24);
                        break;
                    case "షాప్స్ & స్టోర్స్":
                        //String uri25 = "http://mainframestutor.in/stores-in-repalle/";
                        Intent intent25 = new Intent(SubMenu.this, StoresActivityGrid.class);
                        //intent25.putExtra("uri",uri25);
                        startActivity(intent25);
                        break;


                    case "ప్రభుత్వ కార్యాలయాలు":
                        String uri26 = "http://mainframestutor.in/govt-offices-from-repalle/";
                        Intent intent26 = new Intent(SubMenu.this, WebActivity.class);
                        intent26.putExtra("uri", uri26);
                        startActivity(intent26);
                        break;
                    case "మీసేవా సెంటర్స్":
                        String uri27 = "http://mainframestutor.in/meeseva-centers-in-repalle/";
                        Intent intent27 = new Intent(SubMenu.this, WebActivity.class);
                        intent27.putExtra("uri", uri27);
                        startActivity(intent27);
                        break;
                    case "సినిమాలు":
                        String uri28 = "http://mainframestutor.in/theaters-in-repalle-constituency/";
                        Intent intent28 = new Intent(SubMenu.this, WebActivity.class);
                        intent28.putExtra("uri", uri28);
                        startActivity(intent28);
                        break;
                    case "ఆరోగ్య-సమాచారం":
                        String uri31 = "http://mainframestutor.in/health-awareness-for-repalle/";
                        Intent intent31 = new Intent(SubMenu.this, WebActivity.class);
                        intent31.putExtra("uri", uri31);
                        startActivity(intent31);
                        break;
                    case "వ్యవసాయ-సమాచారం":
                        String uri32 = "http://mainframestutor.in/agriculture-awareness/";
                        Intent intent32 = new Intent(SubMenu.this, WebActivity.class);
                        intent32.putExtra("uri", uri32);
                        startActivity(intent32);
                        break;
                    case "పిల్లలకు - పధకాలు":
                        String uri33 = "http://mainframestutor.in/schemes-for-childrens/";
                        Intent intent33 = new Intent(SubMenu.this, WebActivity.class);
                        intent33.putExtra("uri", uri33);
                        startActivity(intent33);
                        break;
                    case "మహిళలకు -పధకాలు":
                        String uri34 = "http://mainframestutor.in/schemes-for-womens/";
                        Intent intent34 = new Intent(SubMenu.this, WebActivity.class);
                        intent34.putExtra("uri", uri34);
                        startActivity(intent34);
                        break;
                    case "స్త్రీల కొరకు స్పెషల్":
                        Intent intent35 = new Intent(SubMenu.this, LadiesSpecial.class);
                        startActivity(intent35);
                        break;
                    case "విలువైన-సమాచారం":
                        String uri36 = "http://mainframestutor.in/useful-tips-for/";
                        Intent intent36 = new Intent(SubMenu.this, WebActivity.class);
                        intent36.putExtra("uri", uri36);
                        startActivity(intent36);
                        break;
                    case "కృష్ణా పుష్కర్ ఘాట్స్":
                        String uri37 = "http://mainframestutor.in/krishna-pushkar-ghats-from-repalle/";
                        Intent intent37 = new Intent(SubMenu.this, WebActivity.class);
                        intent37.putExtra("uri", uri37);
                        startActivity(intent37);
                        break;
                    case "ఉద్యోగ-సమాచారం":
                        String uri38 = "http://mainframestutor.in/jobs-info-2/";
                        Intent intent38 = new Intent(SubMenu.this, WebActivity.class);
                        intent38.putExtra("uri", uri38);
                        startActivity(intent38);
                        break;
                    case "ఫోన్-బుక్":
                        String uri39 = "http://mainframestutor.in/repalle-phone-book/";
                        Intent intent39 = new Intent(SubMenu.this, WebActivity.class);
                        intent39.putExtra("uri", uri39);
                        startActivity(intent39);
                        break;
                    case "వరదల సమాచారం":
                        String uri40 = "http://mainframestutor.in/repalle-flood-photos/";
                        Intent intent40 = new Intent(SubMenu.this, WebActivity.class);
                        intent40.putExtra("uri", uri40);
                        startActivity(intent40);
                        break;
                    case "జరగబోవు కార్యక్రమాలు":
                        String uri41 = "http://mainframestutor.in/interview-questions/";
                        Intent intent41 = new Intent(SubMenu.this, WebActivity.class);
                        intent41.putExtra("uri", uri41);
                        startActivity(intent41);
                        break;
                    case "రాజకీయ నాయకులు":
                        String uri42 = "http://mainframestutor.in/repalle-politicians/";
                        Intent intent42 = new Intent(SubMenu.this, WebActivity.class);
                        intent42.putExtra("uri", uri42);
                        startActivity(intent42);
                        break;
                    case "ప్రసిద్ధి  చెందిన వ్యక్తులు":
                        String uri43 = "http://mainframestutor.in/repalle-popular-persons/";
                        Intent intent43 = new Intent(SubMenu.this, WebActivity.class);
                        intent43.putExtra("uri", uri43);
                        startActivity(intent43);
                        break;
                    case "ఆదర్శ వ్యక్తులు":
                        String uri44 = "http://mainframestutor.in/repalle-inspiring-persons/";
                        Intent intent44 = new Intent(SubMenu.this, WebActivity.class);
                        intent44.putExtra("uri", uri44);
                        startActivity(intent44);
                        break;
                    case "స్వాతంత్ర సమరయోధులు":
                        String uri45 = "http://mainframestutor.in/repalle-freedom-fighters/";
                        Intent intent45 = new Intent(SubMenu.this, WebActivity.class);
                        intent45.putExtra("uri", uri45);
                        startActivity(intent45);
                        break;
                    case "చిత్ర-కళాకారులు":
                        String uri46 = " http://mainframestutor.in/repalle-film-industry-persons/";
                        Intent intent46 = new Intent(SubMenu.this, WebActivity.class);
                        intent46.putExtra("uri", uri46);
                        startActivity(intent46);
                        break;
                    case "రేపల్లె -ఫోటో గాలరి":
                        String uri47 = "http://mainframestutor.in/repalle-photos/";
                        Intent intent47 = new Intent(SubMenu.this, WebActivity.class);
                        intent47.putExtra("uri", uri47);
                        startActivity(intent47);
                        break;
                    case "నగరం-ఫోటో గాలరి":
                        String uri48 = "http://mainframestutor.in/nagaram-photos/";
                        Intent intent48 = new Intent(SubMenu.this, WebActivity.class);
                        intent48.putExtra("uri", uri48);
                        startActivity(intent48);
                        break;
                    case "నిజాంపట్నం-ఫోటో గాలరి":
                        String uri49 = "http://mainframestutor.in/nizampatnam-photos/";
                        Intent intent49 = new Intent(SubMenu.this, WebActivity.class);
                        intent49.putExtra("uri", uri49);
                        startActivity(intent49);
                        break;
                    case "చెరుకుపల్లి-ఫోటో గాలరి":
                        String uri50 = "http://mainframestutor.in/cherukupalli-photos/";
                        Intent intent50 = new Intent(SubMenu.this, WebActivity.class);
                        intent50.putExtra("uri", uri50);
                        startActivity(intent50);
                        break;
                    default:
                        break;
                }

            }
        });
        }
        else

        {
            CheckInternet.showAlertDialog(SubMenu.this, "No Internet Connection",
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
