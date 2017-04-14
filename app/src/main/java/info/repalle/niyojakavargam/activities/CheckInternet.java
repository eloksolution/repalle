package info.repalle.niyojakavargam.activities;


import android.app.AlertDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.net.ConnectivityManager;
        import android.net.NetworkInfo;
import android.widget.Toast;

import activities.repalle.info.repalle.R;

public class CheckInternet {

    /** CHECK WHETHER INTERNET CONNECTION IS AVAILABLE OR NOT */
    public static boolean checkInternetConenction(Context context) {
        final ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetworkInfo = connMgr.getActiveNetworkInfo();

        if (activeNetworkInfo != null) { // connected to the internet
            Toast.makeText(context, activeNetworkInfo.getTypeName(), Toast.LENGTH_SHORT).show();

            if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_WIFI) {
                // connected to wifi
                return true;
            } else if (activeNetworkInfo.getType() == ConnectivityManager.TYPE_MOBILE) {
                // connected to the mobile provider's data plan
                return true;
            }
        }
        return false;
    }

    public static void showAlertDialog(Context context, String title, String message) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        // Setting Dialog Title
        alertDialog.setTitle(title);
        // Setting Dialog Message
        alertDialog.setMessage(message);
        // Setting alert dialog icon
        alertDialog.setIcon(R.drawable.fail);
        // etting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Showing Alert Message
        alertDialog.show();
    }
}