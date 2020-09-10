package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cv_id=findViewById(R.id.cakeview);
        Button blowOut=findViewById(R.id.blow_out_button);
        CakeController c_contrl=new CakeController(cv_id, blowOut, R.id.Fosting, R.id.candles);

        blowOut.setOnClickListener(c_contrl);

        Switch candles_switch=findViewById(R.id.candles);
        candles_switch.setOnCheckedChangeListener(c_contrl);

        Switch frost_switch=findViewById(R.id.Fosting);
        frost_switch.setOnCheckedChangeListener(c_contrl);

        SeekBar num_candles_seekbar=findViewById(R.id.candles_seekbar);
        num_candles_seekbar.setOnSeekBarChangeListener(c_contrl);
    }
    public void goodbye(View button){
        Log.i("button", "Goodbye");
    }
}
