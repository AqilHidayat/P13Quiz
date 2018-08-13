package sg.edu.rp.c346.p13quiz;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver br = new WallpaperReceiver();
    RadioGroup rgBadGood;
    RadioButton rb1;
    RadioButton rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rgBadGood = findViewById(R.id.radioBG);
        rb1 = findViewById(R.id.radioButtonGood);
        rb2 = findViewById(R.id.radioButtonBad);

        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
        filter.addAction("android.intent.action.WALLPAPER_CHANGED");
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unregisterReceiver(br);
    }



    @Override
    protected void onPause() {
        super.onPause();

     SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
     SharedPreferences.Editor prefEdit = prefs.edit();

     if(rb1.isChecked()){
         prefEdit.putString("rb", getString(R.string.rb1));

     }else{
         prefEdit.putString("rb", getString(R.string.rb2));
     }



        prefEdit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();

  
    }



}
