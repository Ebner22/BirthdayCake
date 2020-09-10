package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;

public class CakeController implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener{
    private CakeView cake_view_ref;
    private CakeModel cake_model_ref;
    private Button lit_button_ref;
    private int frost_switch_id;
    private int candles_switch_id;

    public CakeController(CakeView c_view_ref, Button lit_button, int f_switch_id, int c_switch_id){
        cake_view_ref=c_view_ref;
        cake_model_ref=c_view_ref.getCake_model_ref();
        lit_button_ref=lit_button;
        frost_switch_id=f_switch_id;
        candles_switch_id=c_switch_id;
    }


    @Override
    public void onClick(View v) {
        Log.d("button","Blew out candles. ");
        cake_model_ref.lit=!cake_model_ref.lit;
        if (cake_model_ref.lit){
            lit_button_ref.setText("BLOW OUT");
        }
        else{
            lit_button_ref.setText("RELIGHT");
        }
        cake_view_ref.invalidate();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId()==candles_switch_id) {
            Log.d("switch", "Switch for candles changed ");
            cake_model_ref.candles = !cake_model_ref.candles;
            cake_view_ref.invalidate();
        }
        else if (buttonView.getId()==frost_switch_id){
            Log.d("switch", "Switch for frosting changed ");
            cake_model_ref.frosting=!cake_model_ref.frosting;
            if (cake_model_ref.frosting){
                cake_view_ref.frostHeight=50.0f;
            }
            else{
                cake_view_ref.frostHeight=0.0f;
            }
            cake_view_ref.invalidate();
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("seekbar","Changed number of candles ");
        cake_model_ref.num_candles=progress;
        cake_view_ref.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //do nothing
    }
}
