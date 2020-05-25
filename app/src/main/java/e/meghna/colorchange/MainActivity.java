package e.meghna.colorchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences perferences = getSharedPreferences("COLOR_PREF", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = perferences.edit();

        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.layout);

        if (perferences.contains("colorID"))
            layout.setBackgroundColor(perferences.getInt("colorId", 0));
        RadioGroup radioGroup_colors = (RadioGroup)findViewById(R.id.radioGroup_colors);
        radioGroup_colors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int colorCode = 0;
                switch (checkedId) {
                    case R.id.radioButton_Blue:
                        colorCode = Color.BLUE;
                        break;
                    case R.id.radioButton_Magenta:
                        colorCode = Color.MAGENTA;
                        break;
                    case R.id.radioButton_Yellow:
                        colorCode = Color.YELLOW;
                        break;
                    case R.id.radioButton_Green:
                        colorCode = Color.GREEN;
                        break;
                }
                layout.setBackgroundColor(colorCode);
                editor.putInt("colorId",colorCode);
                editor.commit();
            }
        });
    }

}
