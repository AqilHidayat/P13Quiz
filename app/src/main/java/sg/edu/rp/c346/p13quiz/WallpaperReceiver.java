package sg.edu.rp.c346.p13quiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.RadioButton;
import android.widget.Toast;

/**
 * Created by 16019623 on 13/8/2018.
 */


public class WallpaperReceiver extends BroadcastReceiver {




    @Override
    public void onReceive(Context context, Intent intent) {
       SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
       String msg = prefs.getString("rb", "");



        Toast my_toast = Toast.makeText(context, msg , Toast.LENGTH_LONG);
        my_toast.show();
    }


}
