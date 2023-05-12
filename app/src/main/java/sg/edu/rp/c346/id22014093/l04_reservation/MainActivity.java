package sg.edu.rp.c346.id22014093.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editname;
    EditText editnum;
    EditText editpax;
    RadioGroup radioGroup;
    DatePicker dp;
    TimePicker tp;
    Button buttonReset;
    Button buttonConfirm;
    RadioButton buttonSmoke;
    RadioButton buttonnonSmoke;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editname = findViewById(R.id.editname);
        editnum = findViewById(R.id.editnum);
        editpax = findViewById(R.id.editpax);
        radioGroup = findViewById(R.id.radioGroup);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        buttonReset = findViewById(R.id.buttonReset);
        buttonConfirm = findViewById(R.id.buttonConfirm);
        buttonSmoke = findViewById(R.id.buttonSmoke);
        buttonnonSmoke = findViewById(R.id.buttonnonSmoke);

        dp.updateDate(2023,5,1);
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);



        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dp.getDayOfMonth();
                int month = dp.getMonth();
                int year = dp.getYear();
                int hour = tp.getCurrentHour();
                int minute = tp.getCurrentMinute();
                String name = editname.getText().toString();
                String phone = editnum.getText().toString();
                String group = radioGroup.toString();
                String tableArea;
                if (buttonSmoke.isChecked()) {
                    tableArea = "Smoking";
                }else {
                    tableArea = "Non-Smoking";
                }
                String message = "Reservation Details:\n " + "Name" +editname + "Mobile" + editnum + "Group Size" + radioGroup + "\n" + "Date: " + day + (month+1) + year + "\n"
                        + "Time: " + hour + ":" + minute + "\n" + "Table Area: " + tableArea;
                Toast.makeText(MainActivity.this, message,Toast.LENGTH_SHORT).show();
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dp.updateDate(2023,5,1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                buttonnonSmoke.isChecked();
                editname.setText("");
                editnum.setText("");
                editpax.setText("");
            }
        });




    }
}